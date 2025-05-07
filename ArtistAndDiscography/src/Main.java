//TODO add try-catch block
//TODO rename methods & variables

import lib.ValidationResult;
import lib.Validator;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        setConnection();
    }


    private static void setConnection() throws IOException {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/database.properties")) {
            props.load(fis);

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to database successfully!");
                selectOption(conn);
            } catch (SQLException e) {
                System.out.println("Error in database connection " + e.getMessage());
            }
        }
    }

    private static void selectOption(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainOptions();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    selectCRUDOption(connection);
                    break;
                case "2":
                    displaySoloArtists(connection);
                    break;
                case "3":
                    displayArtistsAfterYear(connection, scanner);
                    break;
                case "4":
                    displayArtistDiscography(connection, scanner);
                    break;
                case "5":
                    displayAlbumsByLabel(connection, scanner);
                    break;
                case "6":
                    showAllLabels(connection);
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMainOptions() {
        System.out.println("\n=== ARTIST MANAGEMENT SYSTEM ===");
        System.out.println("1. Demonstrate CRUD operations");
        System.out.println("2. Show solo artists");
        System.out.println("3. Show artists after a specific year");
        System.out.println("4. Show artist discography");
        System.out.println("5. Show albums by record label");
        System.out.println("0. Exit");
        System.out.print("Enter an option: ");
    }

    private static void selectCRUDOption(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayCRUDOptions();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createArtist(connection, scanner);
                    break;
                case "2":
                    readAllArtists(connection);
                    break;
                case "3":
                    updateExistingArtist(connection, scanner);
                    break;
                case "4":
                    deleteArtistById(connection, scanner);
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayCRUDOptions() throws SQLException {
        System.out.println("\n--- CRUD OPERATIONS ---");
        System.out.println("1. insert new artist");
        System.out.println("2. read all artist");
        System.out.println("3. update artist");
        System.out.println("4. delete artist");
        System.out.println("0. exit");
        System.out.print("Please choose the option: ");
    }

    private static void createArtist(Connection conn, Scanner scanner) throws SQLException {
        Artist newArtist = new Artist();
        // Get artist name with validation
        while (true) {
            System.out.print("Enter your name: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateName(input);
            if (result.isValid()) {
                newArtist.setName(input);
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get artist type with validation
        while (true) {
            System.out.print("Enter artist type(solo/band): ");
            String typeInput = scanner.nextLine();
            ValidationResult result = Validator.validateArtistType(typeInput);
            if (result.isValid()) {
                newArtist.setType(typeInput);
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get launch year with validation
        while (true) {
            System.out.print("Launch year: ");
            String launchYearInput = scanner.nextLine();
            ValidationResult result = Validator.validateLaunchYear(launchYearInput);
            if (result.isValid()) {
                newArtist.setLaunchYear(Integer.parseInt(launchYearInput));
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get split year with validation
        while (true) {
            System.out.print("Split Year: (leave empty if still active) ");
            String splitYearInput = scanner.nextLine();
            if (!splitYearInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateSplitYear(splitYearInput, newArtist.getLaunchYear());
                if (result.isValid()) {
                    newArtist.setSplitYear(Integer.parseInt(splitYearInput));
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        // Read and validate website name
        while (true) {
            System.out.print("Website: (leave empty if doesn't exist) ");
            String websiteInput = scanner.nextLine();
            if (!websiteInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateWebsite(websiteInput);
                if (result.isValid()) {
                    newArtist.setWebsite(websiteInput);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }
        try {
            int artistId = insertArtistIntoDatabase(conn, newArtist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Artist findArtistById(Connection conn, int id) throws SQLException {
        String query = "SELECT * FROM artists WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            Artist artist = new Artist(
                    resultSet.getString("name"),
                    resultSet.getString("type"),
                    resultSet.getInt("launch_year"),
                    resultSet.getObject("split_year") != null ? resultSet.getInt("split_year") : null,
                    resultSet.getString("website")
            );
            artist.setId(resultSet.getInt("id"));
            return artist;
        }
        return null;
    }

    public static void readAllArtists(Connection conn) throws SQLException {
        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists");

        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("launch_year"),
                    rs.getInt("split_year"),
                    rs.getString("website"));
            artistsList.add(a);
        }

        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }

    private static void updateExistingArtist(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter artist Id to update: ");
        int artistId = Integer.parseInt(scanner.nextLine());

        //show current artist details
        Artist currentArtist = findArtistById(connection, artistId);
        if (currentArtist == null) {
            System.out.println("Artist with Id: " + artistId + " not found");
            return;
        }
        System.out.println("Artist details: " + currentArtist);

        // Update name if provided
        System.out.print("Enter new name (leave empty to keep the current one): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            currentArtist.setName(newName);
        }

        // Update type if provided
        while (true) {
            System.out.print("Enter new type (solo/band) (leave empty to keep the current one): ");
            String typeInput = scanner.nextLine();
            if (!typeInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateArtistType(typeInput);
                if (result.isValid()) {
                    currentArtist.setType(typeInput);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        // Update launch year if provided
        while (true) {
            System.out.print("Enter new launch year (leave empty to keep current): ");
            String launchYearInput = scanner.nextLine();
            ValidationResult result = Validator.validateNewLaunchYear(launchYearInput);
            if (result.isValid()) {
                if (!launchYearInput.trim().isEmpty()) {
                    int newLaunchYear = Integer.parseInt(launchYearInput);
                    currentArtist.setLaunchYear(newLaunchYear);
                }
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Update split year if provided
        while (true) {
            System.out.print("Enter new split year (leave empty to keep current): ");
            String splitYearInput = scanner.nextLine();
            if (!splitYearInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateSplitYear(splitYearInput, currentArtist.getLaunchYear());
                if (result.isValid()) {
                    int newSplitYear = Integer.parseInt(splitYearInput.trim());
                    currentArtist.setSplitYear(newSplitYear);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        // Update website if provided
        while (true) {
            System.out.print("Enter new website (leave empty to keep current): ");
            String websiteInput = scanner.nextLine();
            if (!websiteInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateWebsite(websiteInput);
                if (result.isValid()) {
                    currentArtist.setWebsite(websiteInput);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        // Update artist in the database
        try {
            updateArtistInDatabase(connection, currentArtist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteArtistById(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter artist Id to delete: ");
        String deleteIdInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(deleteIdInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int artistId = Integer.parseInt(deleteIdInput);
        Artist artistToDelete = findArtistById(conn, artistId);

        if (artistToDelete == null) {
            System.out.println("Artist with ID " + deleteIdInput + " does not exist!");
            return;
        } else {
            // Confirm deletion
            String confirmation = "";
            while (!confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("n")) {
                System.out.print("Are you sure you want to delete this artist? (select: y/n): ");
                confirmation = scanner.nextLine();
            }

            if (confirmation.equalsIgnoreCase("y")) {

                try {
                    deleteArtistFromDatabase(conn, artistId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static int insertArtistIntoDatabase(Connection conn, Artist artist) throws SQLException {
        String query = "insert into artists (name,type,launch_year,split_year,website) values(?,?,?,?,?)";

        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, artist.getName());
        statement.setString(2, artist.getType());
        statement.setInt(3, artist.getLaunchYear());

        if (artist.getSplitYear() != null) {
            statement.setInt(4, artist.getSplitYear());
        } else {
            statement.setNull(4, Types.INTEGER);
        }

        if (artist.getWebsite() != null && !artist.getWebsite().isEmpty()) {
            statement.setString(5, artist.getWebsite());
        } else {
            statement.setNull(5, Types.VARCHAR);
        }

        if (statement.executeUpdate() > 0) {
            System.out.println("Artist added successfully.");
        }

        //Returns: a ResultSet object containing the auto-generated key(s) generated
        // by the execution of this Statement object

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating artist failed, no ID obtained.");
            }
        }
    }

    public static void updateArtistInDatabase(Connection conn, Artist artist) throws SQLException {
        String query = "update artists set name=?, type=?, launch_year=?, split_year=?, website=? where id=?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, artist.getName());
        statement.setString(2, artist.getType());
        statement.setInt(3, artist.getLaunchYear());

        if (artist.getSplitYear() != null) {
            statement.setInt(4, artist.getSplitYear());
        } else {
            statement.setNull(4, Types.INTEGER);
        }

        if (artist.getWebsite() != null && !artist.getWebsite().isEmpty()) {
            statement.setString(5, artist.getWebsite());
        } else {
            statement.setNull(5, Types.VARCHAR);
        }

        statement.setInt(6, artist.getId());

        if (statement.executeUpdate() > 0) {
            System.out.println("Artist updated successfully!");
        } else {
            System.out.println("No artist was updated.");
        }
    }

    public static void deleteArtistFromDatabase(Connection conn, int id) throws SQLException {
        String query = "delete from artists where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        if (ps.executeUpdate() > 0) {
            System.out.println("Artist deleted successfully.");
        }
    }

    public static void displaySoloArtists(Connection conn) throws SQLException {
        List<Artist> soloArtists = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists where type='Solo' ");
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist artist = new Artist(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("launch_year"),
                    rs.getInt("split_year"),
                    rs.getString("website")
            );
            soloArtists.add(artist);
        }
        if (soloArtists.isEmpty()) {
            System.out.println("No solo artists found in the database.");
        } else {
            System.out.println("\n=== Solo Artists ===");
            for (Artist artist : soloArtists) {
                System.out.println(artist.toString());
            }
        }
    }

    public static void displayArtistsAfterYear(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter the year to filter artists after: ");
        String yearInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(yearInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int year = Integer.parseInt(yearInput);
        List<Artist> artistsFilteredByYear = new ArrayList<>();
        String query = "SELECT * FROM artists WHERE launch_year > ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, year);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Artist artist = new Artist(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("type"),
                            resultSet.getInt("launch_year"),
                            resultSet.getInt("split_year"),
                            resultSet.getString("website")
                    );
                    artistsFilteredByYear.add(artist);
                }
            }
        }
        if (artistsFilteredByYear.isEmpty()) {
            System.out.println("No artists found that launched after year " + year + ".");
        } else {
            System.out.println("\n=== Artists Launched After " + year + " ===");
            for (Artist artist : artistsFilteredByYear) {
                System.out.println(artist.toString());
            }
        }
    }

    private static void displayArtistDiscography(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Please, enter artist's id:");
        String idArtistToDisplay = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(idArtistToDisplay);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int artistId = Integer.parseInt(idArtistToDisplay);
        Artist artistToDisplay = findArtistById(connection, artistId);

        if (artistToDisplay == null) {
            System.out.println("Artist with ID " + idArtistToDisplay + " does not exist!");
            return;
        }

        List<Album> artistAlbums = findAlbumsByArtistId(connection, artistId);
        Discography discography = new Discography(artistToDisplay, artistAlbums);
        System.out.println(discography);


    }

    private static List<Album> findAlbumsByArtistId(Connection connection, int artistId) throws SQLException {
        List<Album> albums = new ArrayList<>();
        String query = "SELECT artist_id, title, release_year, record_label FROM albums WHERE artist_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artistId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Album album = new Album(
                            resultSet.getInt("artist_id"),
                            resultSet.getString("title"),
                            resultSet.getInt("release_year"),
                            resultSet.getString("record_label")
                    );
                    albums.add(album);
                }
            }
        }
        return albums;
    }

    public static void displayAlbumsByLabel(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("All labels from discography:");
        showAllLabels(connection);
        List<String> allLabels = getAllLabels(connection);

        while (true) {
            System.out.println("Please, choose the label:");
            String labelInput = scanner.nextLine();
            ValidationResult result = Validator.validateLabel(labelInput);

            if (!allLabels.contains(labelInput)) {
                System.out.println("Label not found. Please enter a valid label from the list.");
            } else if (!result.isValid()) {
                System.out.println(result.getMessage());
            } else {
                List<Album> albumsByLabel = getAlbumsByLabel(connection, labelInput);
                for (Album album : albumsByLabel) {
                    System.out.println(album.albumsAndArtists());
                }
                break;
            }
        }
    }

    private static List<Album> getAlbumsByLabel(Connection connection, String recordLabel) throws SQLException {
        List<Album> albumsByLabel = new ArrayList<>();

        String query = "SELECT a.id, a.artist_id, a.title, a.release_year, a.record_label, " +
                "art.id, art.name, art.type, art.launch_year, art.split_year, art.website " +
                "FROM albums a JOIN artists art ON a.artist_id = art.id WHERE a.record_label = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, recordLabel);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Artist artist = new Artist(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("type"),
                            resultSet.getInt("launch_year"),
                            resultSet.getInt("split_year"),
                            resultSet.getString("website")
                    );

                    Album album = new Album(
                            resultSet.getInt("id"),
                            resultSet.getInt("artist_id"),
                            resultSet.getString("title"),
                            resultSet.getInt("release_year"),
                            resultSet.getString("record_label"),
                            artist
                    );
                    albumsByLabel.add(album);
                }
            }
        }
        return albumsByLabel;
    }

    private static List<String> getAllLabels(Connection conn) throws SQLException {
        List<String> labels = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT DISTINCT record_label FROM albums")) {
            while (rs.next()) {
                labels.add(rs.getString("record_label"));
            }
        }
        return labels;
    }

    private static void showAllLabels(Connection conn) throws SQLException {
        List<String> labels = getAllLabels(conn);
        for (String label : labels) {
            System.out.println(label);
        }
    }
}


