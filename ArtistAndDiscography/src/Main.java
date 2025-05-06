import lib.ValidationResult;
import lib.Validator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/artists_catalog";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123123";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to database successfully!");
            displayAllFunctionality(conn);
        } catch (SQLException e) {
            System.out.println("Error in database connection " + e.getMessage());
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== ARTIST MANAGEMENT SYSTEM ===");
        System.out.println("1. Demonstrate CRUD operations");
        System.out.println("2. Show solo artists");
        System.out.println("3. Show artists after a specific year");
        System.out.println("4. Show artist discography");
        System.out.println("5. Show albums by record label");
        System.out.println("0. Exit");
    }

    private static void displayAllFunctionality(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            System.out.print("Enter an option: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    displayCrudMenu(connection);
                    break;
                case "2":
                    displaySoloArtists(connection);
                    break;
//                case "3":
//                    showArtistsAfterYear(connection,scanner);
//                    break;
//                case "4":
//                    displayArtistDiscography(connection, scanner);
//                    break;
//                case "5":
//                    displayAlbumsByLabel(connection, scanner);
//                    break;

                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void printCRUDMenu() throws SQLException {
        System.out.println("\n--- CRUD OPERATIONS ---");
        System.out.println("1. insert new artist");
        System.out.println("2. read all artist");
        System.out.println("3. update artist");
        System.out.println("4. delete artist");
        System.out.println("0. exit");
    }

    private static void displayCrudMenu(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printCRUDMenu();
            System.out.print("Please choose the option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    createNewArtist(connection, scanner);
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


    private static void createNewArtist(Connection conn, Scanner scanner) throws SQLException {
        // Get artist name with validation
        String name = "";
        while (true) {
            System.out.print("Enter your name: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateName(input);
            if (result.isValid()) {
                name = input;
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get artist type with validation
        String type = "";
        while (true) {
            System.out.print("Enter artist type(solo/band): ");
            String typeInput = scanner.nextLine();
            ValidationResult result = Validator.validateArtistType(typeInput);
            if (result.isValid()) {
                type = typeInput;
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get launch year with validation
        Integer launchYear = null;
        while (true) {
            System.out.print("Launch year: ");
            String launchYearInput = scanner.nextLine();
            ValidationResult result = Validator.validateLaunchYear(launchYearInput);
            if (result.isValid()) {
                launchYear = Integer.parseInt(launchYearInput);
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get split year with validation
        Integer splitYear = null;
        while (true) {
            System.out.print("Split Year: (leave empty if still active) ");
            String splitYearInput = scanner.nextLine();
            ValidationResult result = Validator.validateSplitYear(splitYearInput, launchYear);
            if (result.isValid()) {
                if (!splitYearInput.trim().isEmpty()) {
                    splitYear = Integer.parseInt(splitYearInput.trim());
                }
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Get website with validation
        String website = "";
        while (true) {
            System.out.print("Website: (leave empty if doesn't exist) ");
            String websiteInput = scanner.nextLine();
            ValidationResult result = Validator.validateWebsite(websiteInput);
            if (result.isValid()) {
                if (!websiteInput.trim().isEmpty()) {
                    website = websiteInput;
                }
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Create artist
        Artist newArtist = new Artist(name, type, launchYear, splitYear, website);
        int newId = insertArtistIntoDatabase(conn, newArtist);
        System.out.println("Artist added with ID: " + newId);
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
        System.out.print("Enter artist ID to update: ");
        int artistIdToUpdate = Integer.parseInt(scanner.nextLine());

        //show current artist details
        Artist currentArtist = findArtistById(connection, artistIdToUpdate);
        if (currentArtist == null) {
            System.out.println("Artist not found with ID: " + artistIdToUpdate);
            return;
        }
        System.out.println("Current details: " + currentArtist);


        // Update name if provided
        System.out.print("Enter new name (leave empty to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            currentArtist.setName(newName);
        }

        // Update type if provided
        String newType = "";
        while (true) {
            System.out.print("Enter new type (solo/band) (leave empty to keep current): ");
            String typeInput = scanner.nextLine();
            ValidationResult result = Validator.validateNewArtistType(typeInput);
            if (result.isValid()) {
                if (!typeInput.trim().isEmpty()) {
                    newType = typeInput;
                    currentArtist.setType(newType);
                }
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Update launch year if provided
        int currentLaunchYear = currentArtist.getLaunchYear();
        while (true) {
            System.out.print("Enter new launch year (leave empty to keep current): ");
            String launchYearInput = scanner.nextLine();
            ValidationResult result = Validator.validateNewLaunchYear(launchYearInput);
            if (result.isValid()) {
                if (!launchYearInput.trim().isEmpty()) {
                    int newLaunchYear = Integer.parseInt(launchYearInput);
                    currentArtist.setLaunchYear(newLaunchYear);
                    currentLaunchYear = newLaunchYear;
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
            ValidationResult result = Validator.validateSplitYear(splitYearInput, currentLaunchYear);
            if (result.isValid()) {
                if (!splitYearInput.trim().isEmpty()) {
                    int newSplitYear = Integer.parseInt(splitYearInput.trim());
                    currentArtist.setSplitYear(newSplitYear);
                }
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Update website if provided
        while (true) {
            System.out.print("Enter new website (leave empty to keep current): ");
            String websiteInput = scanner.nextLine();
            ValidationResult result = Validator.validateWebsite(websiteInput);
            if (result.isValid()) {
                if (!websiteInput.trim().isEmpty()) {
                    currentArtist.setWebsite(websiteInput);
                }
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        // Update artist in the database
        updateArtistInDatabase(connection, currentArtist);
        System.out.println("Artist updated successfully!");
    }

    private static void deleteArtistById(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter artist ID to delete: ");
        String deleteIdInput = scanner.nextLine();

        ValidationResult result = Validator.validateId(deleteIdInput);
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
            System.out.print("Are you sure you want to delete this artist? (y/n): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                deleteArtistFromDatabase(conn, artistId);
                System.out.println("Artist with ID " + deleteIdInput + " has been deleted successfully!");
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
        statement.executeUpdate();

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating artist failed, no ID obtained.");
            }
        }
    }

    public static void updateArtistInDatabase(Connection conn, Artist artist) throws SQLException {
        String query = "update artists set name=?,type=?, launch_year=?,split_year=?,website=? where id=?";
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
        statement.execute();
    }

    public static void deleteArtistFromDatabase(Connection conn, int id) throws SQLException {
        String query = "delete from artists where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
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


  /*  public static void displayArtistsAfterYear(Connection conn,Scanner scanner) throws SQLException {

        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists where launch_year>2000 ");
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getString("name"), rs.getString("type"), rs.getInt("launch_year"), rs.getInt("split_year"), rs.getString("website"));
            artistsList.add(a);
        }
        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }
    
   */


}

  /*



    public static void readAlbum(Connection conn) throws SQLException {
        List<Album> albumList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from albums");

        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Album al = new Album(rs.getInt("artist_id"), rs.getString("title"), rs.getInt("release_year"), rs.getString("record_label"));
            albumList.add(al);
        }
        for (Album al : albumList) {
            System.out.println(al.toString());
        }
    }

   */


