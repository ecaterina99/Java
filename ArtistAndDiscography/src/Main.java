
import controller.AlbumController;
import controller.ArtistController;
import connection.DBConnection;
import repository.AlbumRepository;
import repository.ArtistRepository;
import service.AlbumService;
import service.ArtistService;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            ArtistRepository artistRepository = new ArtistRepository();
            ArtistService artistService = new ArtistService(artistRepository);
            ArtistController artistController = new ArtistController(artistService);
            AlbumRepository albumRepository = new AlbumRepository();
            AlbumService albumService = new AlbumService(albumRepository);
            AlbumController albumController = new AlbumController(albumService);
            initSelectOption(artistController,albumController);
            DBConnection.closeConnection();

        } catch (Exception e) {
            System.err.println("Error in application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void initSelectOption(ArtistController artistController,AlbumController albumController) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    initSelectCRUDOption(artistController);
                    break;
                case "2":
                    artistController.displaySoloArtists();
                    break;
                case "3":
                    artistController.displayArtistsAfterYear();
                    break;
             case "4":
                    albumController.displayArtistDiscography();
                    break;
                case "5":
                    albumController.displayAlbumsByLabel();
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

    private static void initSelectCRUDOption(ArtistController controller) {
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
                    controller.updateArtist();
                    break;
                case "4":
                    controller.deleteArtist();
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

}


