package main;

import connection.HibernateConnection;
import controller.AlbumController;
import controller.ArtistController;
import lib.DependencyContainer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import repository.AlbumRepository;
import repository.ArtistRepository;
import service.AlbumService;
import service.ArtistService;

import java.util.Scanner;

public class Main {
    static DependencyContainer container = configureDependencies();

    public static void main(String[] args) {
        try {
            // Use the improved connection management method
            setConnection();

            System.out.println("Database operations completed successfully");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateConnection.getInstance().shutdown();
        }
    }

    private static void setConnection() {
        HibernateConnection connection = HibernateConnection.getInstance();
        Session session = null;

        try {
            session = connection.beginTransaction();
            run(session);
            connection.commitTransaction(session);
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            System.err.println("Error in database operation: " + e.getMessage());
            throw e;
        }
    }

    private static void run(Session session) {
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

    private static void initSelectCRUDOption() {
        Scanner scanner = new Scanner(System.in);
        var artistController = container.resolve(ArtistController.class);
        var albumController = container.resolve(AlbumController.class);
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
                case "5":
                    albumController.displayAllLabels();
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
        System.out.println("5. display all albums");
        System.out.println("0. exit");
        System.out.print("Please choose the option: ");
    }

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

