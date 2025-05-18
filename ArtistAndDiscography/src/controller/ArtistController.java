package controller;

import lib.ValidationResult;
import lib.Validator;
import model.Artist;
import service.ArtistService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArtistController {

    private final ArtistService artistService;
    private final Scanner scanner = new Scanner(System.in);

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    /**
     * Reads and validates user input to create a new Artist.
     * After validation, it sends the Artist object to the service layer for persistence.
     */
    public void createArtist() {
        Artist artist = new Artist();
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
            artistService.createArtist(artist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates an existing artist’s information.
     * Prompts the user to enter the artist ID, displays current details,
     * then asks for updated fields (optional).
     * After validation, it sends the updated Artist object to the service layer for persistence.
     */
    public void updateArtist() {
        System.out.print("Enter artist Id to update: ");
        String updateIdInput = scanner.nextLine();
        ValidationResult res = Validator.validateNumberFormat(updateIdInput);
        if (!res.isValid()) {
            System.out.println(res.getMessage());
            return;
        }
        int artistId = Integer.parseInt(updateIdInput);

        Artist artist = artistService.findArtist(artistId);
        if (artist == null) {
            System.out.println("Model.Artist with Id: " + artistId + " not found");
            return;
        }
        System.out.println("Model.Artist details: " + artist);

        System.out.print("Enter new name (leave empty to keep the current one): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            artist.setName(newName);
        }

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

        try {
            artistService.updateArtist(artist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Deletes an artist by ID after confirmation.
    public void deleteArtist() {
        System.out.print("Enter artist Id to delete: ");
        String deleteIdInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(deleteIdInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }

        int artistId = Integer.parseInt(deleteIdInput);
        Artist artistToDelete = artistService.findArtist(artistId);

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
                    artistService.deleteArtist(artistToDelete, artistId);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    //Displays all artists stored in the database.
    public void displayAllArtists() {
        List<Artist> artistsList = artistService.readArtist();
        for (Artist artist : artistsList) {
            System.out.println(artist.toString());
        }
    }

    // Displays only artists of type 'solo'.
    public void displaySoloArtists() {
        List<Artist> soloArtists = artistService.readSoloArtists();
        System.out.println("\n=== Solo Artists ===");
        for (Artist artist : soloArtists) {
            System.out.println(artist.toString());
        }
    }

    //Asks for a year and displays all artists launched after that year.
    public void displayArtistsAfterYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year to filter artists after: ");
        String yearInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(yearInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }
        int year = Integer.parseInt(yearInput);
        try {
            List<Artist> artistsFilteredByYear = artistService.readArtistsAfterYear(year);
            System.out.println("\n=== Artists List ===");
            for (Artist artist : artistsFilteredByYear) {
                System.out.println(artist.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

}
