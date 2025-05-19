import controller.AlbumController;
import controller.ArtistController;
import connection.DBConnection;
import lib.DependencyContainer;
import repository.AlbumRepository;
import repository.ArtistRepository;
import service.AlbumService;
import service.ArtistService;

import java.sql.*;
import java.util.Scanner;

public class Main {
    // Initializes and stores application-wide dependencies using a custom dependency injection container.
    static DependencyContainer container = configureDependencies();

    public static void main(String[] args) {

        //  Entry point of the application. Starts the main execution flow.
        try {
            run();
            DBConnection.closeConnection();

        } catch (Exception e) {
            System.err.println("Error in application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Main application execution loop.
     * Handles the primary program flow including menu display and user option processing.
     */
    public static void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        var artistController = container.resolve(ArtistController.class);
        var albumController = container.resolve(AlbumController.class);
        while (!exit) {
            displayMainMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    initSelectCRUDOption();
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

    /**
     * Manages the CRUD operations submenu for artist entities.
     * Delegates actions to the ArtistController based on user input.
     */
    private static void initSelectCRUDOption() {
        Scanner scanner = new Scanner(System.in);
        var artistController = container.resolve(ArtistController.class);
        boolean exit = false;

        while (!exit) {
            displayCRUDOptions();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    artistController.createArtist();
                    break;
                case "2":
                    artistController.displayAllArtists();
                    break;
                case "3":
                    artistController.updateArtist();
                    break;
                case "4":
                    artistController.deleteArtist();
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

    //Registers all necessary components (repositories, services, controllers) with the dependency container.

    private static DependencyContainer configureDependencies() {
        DependencyContainer container = new DependencyContainer();

        container.register(ArtistRepository.class, new ArtistRepository());
        container.register(AlbumRepository.class, new AlbumRepository());

        container.register(ArtistService.class, new ArtistService(
                container.resolve(ArtistRepository.class)
        ));

        container.register(AlbumService.class, new AlbumService(
                container.resolve(AlbumRepository.class),
                container.resolve(ArtistRepository.class)
        ));

        container.register(ArtistController.class, new ArtistController(
                container.resolve(ArtistService.class)
        ));
        container.register(AlbumController.class, new AlbumController(
                container.resolve(AlbumService.class)
        ));

        return container;
    }
}


