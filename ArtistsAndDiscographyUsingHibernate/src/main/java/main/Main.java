package main;

import lib.HibernateUtil;
import lib.ValidationResult;
import lib.Validator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        setConnection();
    }

    private static void setConnection() throws SQLException {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction(); // start transaction

            //main logic
            selectOption(session);

            tx.commit(); //end transaction
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }


        //verification

    }

    private static void selectOption(Session session) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainOptions();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    selectCRUDOption(session);
                    break;
             /*   case "2":
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
                    displayAllLabels(connection);


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
        System.out.println("1. Demonstrate CRUD operations");
        System.out.println("2. Show solo artists");
        System.out.println("3. Show artists after a specific year");
        System.out.println("4. Show artist discography");
        System.out.println("5. Show albums by record label");
        System.out.println("0. Exit");
        System.out.print("Enter an option: ");
    }

    private static void selectCRUDOption(Session session) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayCRUDOptions();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createArtist(session, scanner);
                    break;
               /* case "2":
                    displayAllArtists(connection);
                    break;
                case "3":
                    setUpdates(connection, scanner);
                    break;
                case "4":
                    deleteArtistById(connection, scanner);
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

    private static void displayCRUDOptions() {
        System.out.println("\n--- CRUD OPERATIONS ---");
        System.out.println("1. insert artist");
        System.out.println("2. display all artists");
        System.out.println("3. update artist");
        System.out.println("4. delete artist");
        System.out.println("0. exit");
        System.out.print("Please choose the option: ");
    }


    private static void createArtist(Session session, Scanner scanner) throws SQLException {
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
        //TODO add block try/catch
        insertArtistIntoDatabase(session, artist);
    }

    public static void insertArtistIntoDatabase(Session session, Artist artist) throws SQLException {
        session.persist(artist);
    }

}