package main;

import connection.HibernateConnection;
import lib.ValidationResult;
import lib.Validator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;


public class Main {
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

        while (!exit) {
            displayMainOptions();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    selectCRUDOption(session);
                    break;
                case "2":
                    displaySoloArtists(session);
                    break;
                case "3":
                    displayArtistsAfterYear(session, scanner);
                    break;
                case "4":
                    displayArtistDiscography(session, scanner);
                    break;
                case "5":
                    displayAlbumsByLabel(session, scanner);
                    break;
                case "6":
                    displayAllLabels(session);
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

    private static void selectCRUDOption(Session session) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayCRUDOptions();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createArtist(session, scanner);
                    break;
                case "2":
                    displayAllArtists(session);
                    break;
                case "3":
                    setUpdates(session, scanner);
                    break;
                case "4":
                    deleteArtistById(session, scanner);
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

    public static Artist findArtistById(Session session, int id) {
        try {
            String hql = "from Artist where id = :id";
            Query<Artist> query = session.createQuery(hql, Artist.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static void createArtist(Session session, Scanner scanner) {
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
            System.out.print("Artist type(solo/band): ");
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
        insertArtistIntoDatabase(session, artist);
    }

    public static void insertArtistIntoDatabase(Session session, Artist artist) {
        try {
            session.persist(artist);
            System.out.println("Artist successfully added with ID: " + artist.getId());
        } catch (HibernateException e) {
            System.err.println("Error inserting artist: " + e.getMessage());
            throw e;
        }
    }

    public static void displayAllArtists(Session session) {
        try {
            String hql = "from Artist";
            Query query = session.createQuery(hql);
            List<Artist> artistsList = query.list();
            if (artistsList.isEmpty()) {
                System.out.println("No artists found in the database");
            } else {
                System.out.println("\n=== All Artists ===");
                for (Artist artist : artistsList) {
                    System.out.println(artist);
                }
            }
        } catch (Exception e) {
            System.err.println("Error displaying artists: " + e.getMessage());
        }
    }

    private static void setUpdates(Session session, Scanner scanner) {
        System.out.print("Enter artist Id to update: ");
        String updateIdInput = scanner.nextLine();
        ValidationResult res = Validator.validateNumberFormat(updateIdInput);
        if (!res.isValid()) {
            System.out.println(res.getMessage());
            return;
        }
        int artistId = Integer.parseInt(updateIdInput);

        //show artist details
        Artist artist = findArtistById(session, artistId);
        if (artist == null) {
            System.out.println("Artist with Id: " + artistId + " not found");
            return;
        }
        System.out.println("Artist details: " + artist);

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
        updateArtistInDatabase(session, artist);
    }

    private static void updateArtistInDatabase(Session session, Artist artist) {
        try {
            session.merge(artist);
            System.out.println("Artist successfully updated");
        } catch (HibernateException e) {
            System.err.println("Error inserting artist: " + e.getMessage());
            throw e;
        }
    }

    private static void deleteArtistById(Session session, Scanner scanner) {
        System.out.print("Enter artist Id to delete: ");
        String deleteIdInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(deleteIdInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int artistId = Integer.parseInt(deleteIdInput);
        Artist artistToDelete = findArtistById(session, artistId);

        if (artistToDelete == null) {
            System.out.println("Artist with ID " + deleteIdInput + " does not exist!");
        } else {
            // Confirm deletion
            String confirmation = "";
            while (!confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("n")) {
                System.out.print("Are you sure you want to delete this artist? (select: y/n): ");
                confirmation = scanner.nextLine();
            }

            if (confirmation.equalsIgnoreCase("y")) {
                deleteArtistFromDatabase(session, artistId, artistToDelete);
            }
        }
    }

    private static void deleteArtistFromDatabase(Session session, int artistId, Artist artist) {
        try {
            artist = session.get(Artist.class, artistId);
            if (artist != null) {
                session.remove(artist);
                System.out.println("Artist deleted successfully.");
            } else {
                System.out.println("Artist with ID " + artistId + " does not exist.");
            }
        } catch (HibernateException e) {
            System.err.println("Error deleting  artist: " + e.getMessage());
            throw e;
        }
    }

    public static void displaySoloArtists(Session session) {
        try {
            String hql = "from Artist where type = 'Solo'";
            Query query = session.createQuery(hql);
            List<Artist> soloArtists = query.list();

            if (soloArtists.isEmpty()) {
                System.out.println("No solo artists found in the database.");
            } else {
                System.out.println("\n=== Solo Artists ===");
                for (Artist artist : soloArtists) {
                    System.out.println(artist.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Error displaying solo artists: " + e.getMessage());
        }
    }

    public static void displayArtistsAfterYear(Session session, Scanner scanner) {
        System.out.print("Enter the year to filter artists after: ");
        String yearInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(yearInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int year = Integer.parseInt(yearInput);

        String hql = "from Artist WHERE launchYear > :year";
        Query<Artist> query = session.createQuery(hql, Artist.class);
        query.setParameter("year", year);

        try {
            List<Artist> artistsFilteredByYear = query.list();

            if (artistsFilteredByYear.isEmpty()) {
                System.out.println("No artists found that launched after year " + year + ".");
            } else {
                System.out.println("\n=== Artists Launched After " + year + " ===");
                for (Artist art : artistsFilteredByYear) {
                    System.out.println(art.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Error displaying artists after year: " + e.getMessage());
        }
    }

    private static void displayArtistDiscography(Session session, Scanner scanner) {
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

    private static List<Album> findAlbumsByArtistId(Session session, int artistId) {
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

    public static void displayAlbumsByLabel(Session session, Scanner scanner) {
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

    private static List<Album> getAlbumsByLabel(Session session, String recordLabel) {
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

    private static List<String> getAllLabels(Session session) {
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

    private static void displayAllLabels(Session session) {
        List<String> labels = getAllLabels(session);
        for (String label : labels) {
            System.out.println(label);
        }
    }
}

