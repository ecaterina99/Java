
import controller.ArtistController;
import model.Album;
import model.Artist;
import connection.DBConnection;
import lib.ValidationResult;
import lib.Validator;
import repository.ArtistRepository;
import service.ArtistService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            ArtistRepository repository = new ArtistRepository();
            ArtistService service = new ArtistService(repository);
            ArtistController controller = new ArtistController(service);
            initSelectOption(controller);

            DBConnection.closeConnection();
        } catch (Exception e) {
            System.err.println("Error in application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void initSelectOption(ArtistController controller) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    initSelectCRUDOption(controller);
                    break;
                case "2":
                    controller.displaySoloArtists();
                    break;
                case "3":
                    controller.displayArtistsAfterYear();
                    break;
              /* case "4":
                    displayArtistDiscography(scanner);
                    break;

               */
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

    private static void initSelectCRUDOption(ArtistController controller) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayCRUDOptions();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    controller.createArtist();
                    break;
                case "2":
                    controller.displayAllArtists();
                break;
                case "3":
                    controller.setUpdates();
                    break;
                case "4":
                    controller.deleteArtistById();
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



   /* private static void displayArtistDiscography(Scanner scanner) throws SQLException {
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


    */
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


