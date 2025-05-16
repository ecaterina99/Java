
import model.Album;
import model.Artist;
import connection.DBConnection;
import lib.ValidationResult;
import lib.Validator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            initSelectOption();
            DBConnection.closeConnection();
        } catch (Exception e) {
            System.err.println("Error in application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void initSelectOption() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    initSelectCRUDOption();
                    break;
                case "2":
                    displaySoloArtists();
                    break;
                case "3":
                    displayArtistsAfterYear(scanner);
                    break;
                case "4":
                    displayArtistDiscography(scanner);
                    break;
                case "5":
                    displayAlbumsByLabel(scanner);
                    break;
                case "6":
                    displayAllLabels();
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== ARTIST MANAGEMENT SYSTEM ===");
        System.out.println("1. Show CRUD operations");
        System.out.println("2. Show solo artists");
        System.out.println("3. Show artists after a specific year");
        System.out.println("4. Show artist discography");
        System.out.println("5. Show albums by record label");
        System.out.println("0. Exit");
        System.out.print("Enter an option: ");
    }

    private static void initSelectCRUDOption() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayCRUDOptions();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createArtist(scanner);
                    break;
                case "2":
                    displayAllArtists();
                    break;
                case "3":
                    setUpdates(scanner);
                    break;
                case "4":
                    deleteArtistById(scanner);
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

    private static void displayCRUDOptions() {
        System.out.println("\n--- CRUD OPERATIONS ---");
        System.out.println("1. insert artist");
        System.out.println("2. display all artists");
        System.out.println("3. update artist");
        System.out.println("4. delete artist");
        System.out.println("0. exit");
        System.out.print("Please choose the option: ");
    }

    public static Artist findArtistById(int id) {
        String query = "SELECT * FROM artists WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static void createArtist(Scanner scanner) {
        Artist artist = new Artist();
        // Read and validate artist name
        while (true) {
            System.out.print("Name: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateName(input);
            if (result.isValid()) {
                artist.setName(input);
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Read and validate artist type
        while (true) {
            System.out.print("Model.Artist type(solo/band): ");
            String typeInput = scanner.nextLine();
            ValidationResult result = Validator.validateArtistType(typeInput);
            if (result.isValid()) {
                artist.setType(typeInput);
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Read and validate launch year
        while (true) {
            System.out.print("Launch year: ");
            String launchYearInput = scanner.nextLine();
            ValidationResult result = Validator.validateLaunchYear(launchYearInput);
            if (result.isValid()) {
                artist.setLaunchYear(Integer.parseInt(launchYearInput));
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Read and validate split year
        while (true) {
            System.out.print("Split Year: (leave empty if still active) ");
            String splitYearInput = scanner.nextLine();
            if (!splitYearInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateSplitYear(splitYearInput, artist.getLaunchYear());
                if (result.isValid()) {
                    artist.setSplitYear(Integer.parseInt(splitYearInput));
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
                    artist.setWebsite(websiteInput);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        try {
            insertArtistIntoDatabase(artist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertArtistIntoDatabase(Artist artist) throws SQLException {
        String query = "INSERT INTO artists (name, type, launch_year, split_year, website) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, artist.getName());
            ps.setString(2, artist.getType());
            ps.setInt(3, artist.getLaunchYear());

            if (artist.getSplitYear() != null) {
                ps.setInt(4, artist.getSplitYear());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            if (artist.getWebsite() != null && !artist.getWebsite().isEmpty()) {
                ps.setString(5, artist.getWebsite());
            } else {
                ps.setNull(5, Types.VARCHAR);
            }

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting artist failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Model.Artist added successfully with ID: " + id);
                } else {
                    throw new SQLException("Inserting artist failed, no ID obtained.");
                }
            }
        }
    }

    public static void displayAllArtists() {
        List<Artist> artistsList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("select * from artists")) {
            while (rs.next()) {
                Artist a = new Artist(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("launch_year"),
                        rs.getInt("split_year"),
                        rs.getString("website"));
                artistsList.add(a);
            }
            for (Artist artist : artistsList) {
                System.out.println(artist.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setUpdates(Scanner scanner) {
        System.out.print("Enter artist Id to update: ");
        String updateIdInput = scanner.nextLine();
        ValidationResult res = Validator.validateNumberFormat(updateIdInput);
        if (!res.isValid()) {
            System.out.println(res.getMessage());
            return;
        }
        int artistId = Integer.parseInt(updateIdInput);

        //show artist details
        Artist artist = findArtistById(artistId);
        if (artist == null) {
            System.out.println("Model.Artist with Id: " + artistId + " not found");
            return;
        }
        System.out.println("Model.Artist details: " + artist);

        // Update name if provided
        System.out.print("Enter new name (leave empty to keep the current one): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            artist.setName(newName);
        }

        // Update type if provided
        while (true) {
            System.out.print("Enter new type (solo/band) (leave empty to keep the current one): ");
            String typeInput = scanner.nextLine();
            if (!typeInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateArtistType(typeInput);
                if (result.isValid()) {
                    artist.setType(typeInput);
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
            System.out.print("Enter new launch year (leave empty to keep current one): ");
            String launchYearInput = scanner.nextLine();
            if (!launchYearInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateLaunchYear(launchYearInput);
                if (result.isValid()) {
                    int newLaunchYear = Integer.parseInt(launchYearInput);
                    artist.setLaunchYear(newLaunchYear);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        // Update split year if provided
        while (true) {
            System.out.print("Enter new split year (leave empty to keep current one): ");
            String splitYearInput = scanner.nextLine();
            if (!splitYearInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateSplitYear(splitYearInput, artist.getLaunchYear());
                if (result.isValid()) {
                    int newSplitYear = Integer.parseInt(splitYearInput.trim());
                    artist.setSplitYear(newSplitYear);
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
            System.out.print("Enter new website (leave empty to keep current one): ");
            String websiteInput = scanner.nextLine();
            if (!websiteInput.trim().isEmpty()) {
                ValidationResult result = Validator.validateWebsite(websiteInput);
                if (result.isValid()) {
                    artist.setWebsite(websiteInput);
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
            updateArtistInDatabase(artist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateArtistInDatabase(Artist artist) throws SQLException {
        String query = "update artists set name=?, type=?, launch_year=?, split_year=?, website=? where id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, artist.getName());
            ps.setString(2, artist.getType());
            ps.setInt(3, artist.getLaunchYear());

            if (artist.getSplitYear() != null) {
                ps.setInt(4, artist.getSplitYear());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            if (artist.getWebsite() != null && !artist.getWebsite().isEmpty()) {
                ps.setString(5, artist.getWebsite());
            } else {
                ps.setNull(5, Types.VARCHAR);
            }

            ps.setInt(6, artist.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Model.Artist updated successfully!");
            } else {
                System.out.println("No artist was updated.");
            }
        }
    }

    private static void deleteArtistById(Scanner scanner) {
        System.out.print("Enter artist Id to delete: ");
        String deleteIdInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(deleteIdInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int artistId = Integer.parseInt(deleteIdInput);
        Artist artistToDelete = findArtistById(artistId);

        if (artistToDelete == null) {
            System.out.println("Model.Artist with ID " + deleteIdInput + " does not exist!");
        } else {
            // Confirm deletion
            String confirmation = "";
            while (!confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("n")) {
                System.out.print("Are you sure you want to delete this artist? (select: y/n): ");
                confirmation = scanner.nextLine();
            }

            if (confirmation.equalsIgnoreCase("y")) {
                try {
                    deleteArtistFromDatabase(artistId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void deleteArtistFromDatabase(int id) throws SQLException {
        String query = "delete from artists where id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Model.Artist deleted successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displaySoloArtists() {
        List<Artist> soloArtists = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from artists where type='Solo' ")) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayArtistsAfterYear(Scanner scanner) throws SQLException {
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

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
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

    private static void displayArtistDiscography(Scanner scanner) throws SQLException {
        System.out.println("Please, enter artist's id:");
        String artistId = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(artistId);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int id = Integer.parseInt(artistId);
        Artist artist = findArtistById(id);

        if (artist == null) {
            System.out.println("Model.Artist with ID " + artistId + " does not exist!");
            return;
        }

        List<Album> artistAlbums = findAlbumsByArtistId(id);
        Discography discography = new Discography(artist, artistAlbums);
        System.out.println(discography);

    }

    private static List<Album> findAlbumsByArtistId(int artistId) throws SQLException {
        List<Album> albums = new ArrayList<>();
        String query = "SELECT artist_id, title, release_year, record_label FROM albums WHERE artist_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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

    public static void displayAlbumsByLabel(Scanner scanner) throws SQLException {
        System.out.println("All labels from discography:");
        displayAllLabels();
        List<String> allLabels = getAllLabels();

        while (true) {
            System.out.println("Please, choose the label:");
            String labelInput = scanner.nextLine();
            ValidationResult result = Validator.validateLabel(labelInput);

            if (!allLabels.contains(labelInput)) {
                System.out.println("Label not found. Please enter a valid label from the list.");
            } else if (!result.isValid()) {
                System.out.println(result.getMessage());
            } else {
                List<Album> albumsByLabel = getAlbumsByLabel(labelInput);
                for (Album album : albumsByLabel) {
                    System.out.println(album.albumsAndArtists());
                }
                break;
            }
        }
    }

    private static List<Album> getAlbumsByLabel(String recordLabel) throws SQLException {
        List<Album> albumsByLabel = new ArrayList<>();

        String query = "SELECT a.id, a.artist_id, a.title, a.release_year, a.record_label, " +
                "art.id, art.name, art.type, art.launch_year, art.split_year, art.website " +
                "FROM albums a JOIN artists art ON a.artist_id = art.id WHERE a.record_label = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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

    private static List<String> getAllLabels() throws SQLException {
        List<String> labels = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT DISTINCT record_label FROM albums")) {
            while (rs.next()) {
                labels.add(rs.getString("record_label"));
            }
        }
        return labels;
    }

    private static void displayAllLabels() throws SQLException {
        List<String> labels = getAllLabels();
        for (String label : labels) {
            System.out.println(label);
        }
    }

}


