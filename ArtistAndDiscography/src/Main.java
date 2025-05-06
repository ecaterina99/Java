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

    private static void printMenu() {
        System.out.println("\n=== ARTIST MANAGEMENT SYSTEM ===");
        System.out.println("1. Demonstrate CRUD operations");
        System.out.println("2. Show solo artists");
        System.out.println("3. Show artists after a specific year");
        System.out.println("4. Show artist discography");
        System.out.println("5. Show albums by record label");
        System.out.println("0. Exit");
    }

    private static void displayAllFunctionality(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            System.out.print("Enter an option: ");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    displayCRUDOperations(conn);
                    break;
                case "2":
                    showSoloArtists(conn);
                    break;
                case "3":
                    showArtistsNewGeneration(conn);
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


    private static void printCRUDMenu() throws SQLException {
        System.out.println("\n--- CRUD OPERATIONS ---");
        System.out.println("1. insert new artist");
        System.out.println("2. read all artist");
        System.out.println("3. update artist");
        System.out.println("4. delete artist");
        System.out.println("0. exit");
    }

    private static void displayCRUDOperations(Connection conn) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printCRUDMenu();
            System.out.print("Please choose the option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    createArtist(conn, scanner);
                    break;
                case "2":
                    readArtists(conn);
                    break;
              /*
                case "3":
                    updateArtist(conn, scanner);
                    break;
                case "4":
                    deleteArtist(conn, scanner);
                    break;
               */

                case "3":
                    System.out.print("Enter artist ID to update: ");
                    int updateArtistById = scanner.nextInt();
                    scanner.nextLine();

                    Artist currentArtist = getArtistById(conn, updateArtistById);

                    if (currentArtist == null) {
                        System.out.println("Artist not found!");
                        break;
                    }

                    System.out.println("Current details: " + currentArtist);

                    System.out.print("New name (leave empty to keep current): ");
                    String newName = scanner.nextLine();
                    if (!newName.isEmpty()) {
                        currentArtist.setName(newName);
                    }

                    System.out.print("New type (leave empty to keep current): ");
                    String newType = scanner.nextLine();
                    if (!newType.isEmpty()) {
                        currentArtist.setType(newType);
                    }

                    System.out.print("New launch year (leave empty to keep current): ");
                    String newLaunchYear = scanner.nextLine();
                    if (!newLaunchYear.isEmpty()) {
                        currentArtist.setLaunchYear(Integer.parseInt(newLaunchYear));
                    }

                    System.out.print("New split year (leave empty to keep current): ");
                    String newSplitYearStr = scanner.nextLine();
                    if (!newSplitYearStr.isEmpty()) {
                        if (newSplitYearStr.equalsIgnoreCase("null")) {
                            currentArtist.setSplitYear(0);
                        } else {
                            currentArtist.setSplitYear(Integer.parseInt(newSplitYearStr));
                        }
                    }

                    System.out.print("New website (leave empty to keep current): ");
                    String newWebsite = scanner.nextLine();
                    if (!newWebsite.isEmpty()) {
                        currentArtist.setWebsite(newWebsite);
                    }

                    updateArtist(conn, currentArtist);
                    System.out.println("Artist updated successfully!");
                    break;

                case "4":
                    System.out.print("Enter artist ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    Artist artistToDelete = getArtistById(conn, deleteId);
                    if (artistToDelete == null) {
                        System.out.println("Artist with ID " + deleteId + " does not exist!");
                        break;
                    } else {
                        deleteArtist(conn, deleteId);
                        System.out.println("Artist with ID " + deleteId + " deleted successfully!");
                        break;
                    }


                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void createArtist(Connection conn, Scanner scanner) throws SQLException {
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

        String website = "";
        while (true) {
            System.out.print("Website: (leave empty if doesn't exist) ");
            String websiteInput = scanner.nextLine();
            ValidationResult result = Validator.validateWebsite(websiteInput);
            if (result.isValid()) {
                website = websiteInput;
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        Artist newArtist = new Artist(name, type, launchYear, splitYear, website);
        int newId = insertArtist(conn, newArtist);
        System.out.println("Artist added with ID: " + newId);
    }


    public static Artist getArtistById(Connection conn, int id) throws SQLException {
        String query = "SELECT * FROM artists WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Artist artist = new Artist(
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("launch_year"),
                    rs.getObject("split_year") != null ? rs.getInt("split_year") : null,
                    rs.getString("website")
            );
            artist.setId(rs.getInt("id"));
            return artist;
        }
        return null;
    }

    public static int insertArtist(Connection conn, Artist artist) throws SQLException {
        String query = "insert into artists (name,type,launch_year,split_year,website) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
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
        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("Creating artist failed, no ID obtained.");
            }
        }
    }

    public static void readArtists(Connection conn) throws SQLException {
        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists");

        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getInt("launch_year"), rs.getInt("split_year"), rs.getString("website"));
            artistsList.add(a);
        }

        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }


    public static void showSoloArtists(Connection conn) throws SQLException {
        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists where type='Solo' ");
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getString("name"), rs.getString("type"), rs.getInt("launch_year"), rs.getInt("split_year"), rs.getString("website"));
            artistsList.add(a);
        }
        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }

    public static void showArtistsNewGeneration(Connection conn) throws SQLException {
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

    public static void updateArtist(Connection conn, Artist artist) throws SQLException {
        String query = "update artists set name=?,type=?, launch_year=?,split_year=?,website=? where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
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
        ps.execute();
    }

    public static void deleteArtist(Connection conn, int id) throws SQLException {
        String query = "delete from artists where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }

}



