package main;

import connection.HibernateConnection;
import controller.AlbumController;
import controller.ArtistController;
import lib.DependencyContainer;
import lib.ValidationResult;
import lib.Validator;
import model.Album;
import model.Artist;
import model.Discography;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.AlbumRepository;
import repository.ArtistRepository;
import service.AlbumService;
import service.ArtistService;

import java.util.List;
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

            selectOption(session);

            connection.commitTransaction(session);
        }catch (HibernateException e) {
            connection.rollbackTransaction(session);
            System.err.println("Error in database operation: " + e.getMessage());
            throw e;
        }
    }


    private static void selectOption(Session session) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        var artistController = container.resolve(ArtistController.class);
        var albumController = container.resolve(AlbumController.class);

        while (!exit) {
            displayMainOptions();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    selectCRUDOption();
                    break;
               case "2":
                    artistController.displaySoloArtists();
                    break;
                case "3":
                    artistController.displayArtistsAfterYear();
                    break;
             /*    case "4":
                    albumController.displayArtistDiscography();
                    break;
                case "5":
                    albumController.displayAlbumsByLabel();
                    break;

             */
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
        System.out.println("1. Show CRUD operations");
        System.out.println("2. Show solo artists");
        System.out.println("3. Show artists after a specific year");
        System.out.println("4. Show artist discography");
        System.out.println("5. Show albums by record label");
        System.out.println("0. Exit");
        System.out.print("Enter an option: ");
    }

    private static void selectCRUDOption() {
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
                    artistController.setUpdates();
                    break;
                case "4":
                    artistController.deleteArtistById();
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


/*


    private static void displayArtistDiscography() {
        System.out.println("Please, enter artist's id:");
        String artistId = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(artistId);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int id = Integer.parseInt(artistId);
        Artist artist = findArtistById(session, id);

        if (artist == null) {
            System.out.println("Artist with ID " + artistId + " does not exist!");
            return;
        }

        List<Album> artistAlbums = findAlbumsByArtistId(session, id);
        Discography discography = new Discography(artist, artistAlbums);
        System.out.println(discography);

    }

    private static List<Album> findAlbumsByArtistId(int artistId) {
        try {
            String hql = "from Album where artist.id= :artistId";
            Query<Album> query = session.createQuery(hql, Album.class);
            query.setParameter("artistId", artistId);
            List<Album> albums = query.list();
            return albums;
        } catch (Exception e) {
            System.err.println("Error finding albums by artist id: " + e.getMessage());
            return null;
        }
    }

    public static void displayAlbumsByLabel() {
        System.out.println("All labels from discography:");
        displayAllLabels(session);

        List<String> allLabels = getAllLabels(session);

        while (true) {
            System.out.println("Please, choose the label:");
            String labelInput = scanner.nextLine();
            ValidationResult result = Validator.validateLabel(labelInput);

            if (!allLabels.contains(labelInput)) {
                System.out.println("Label not found. Please enter a valid label from the list.");
            } else if (!result.isValid()) {
                System.out.println(result.getMessage());
            } else {
                List<Album> albumsByLabel = getAlbumsByLabel(session, labelInput);
                for (Album album : albumsByLabel) {
                    System.out.println(album.albumsAndArtists());
                }
                break;
            }
        }
    }

    private static List<Album> getAlbumsByLabel(String recordLabel) {
        try {
            String hql = "from Album a join fetch a.artist where a.recordLabel = :label";
            Query<Album> query = session.createQuery(hql, Album.class);
            query.setParameter("label", recordLabel);
            List<Album> albumsByLabel = query.list();
            return albumsByLabel;
        } catch (Exception e) {
            System.err.println("Error getting albums by label: " + e.getMessage());
            return null;
        }
    }

    private static List<String> getAllLabels() {
        try {
            String hql = "select DISTINCT a.recordLabel from Album a";
            Query<String> query = session.createQuery(hql, String.class);
            List<String> recordLabels = query.getResultList();
            return recordLabels;
        } catch (Exception e) {
            System.err.println("Error getting all labels: " + e.getMessage());
            return null;
        }
    }

    private static void displayAllLabels() {
        List<String> labels = getAllLabels(session);
        for (String label : labels) {
            System.out.println(label);
        }
    }

 */
}

