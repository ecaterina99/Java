package controller;

import lib.ValidationResult;
import lib.Validator;
import model.Album;
import model.Artist;
import model.Discography;
import service.AlbumService;

import java.util.List;
import java.util.Scanner;

/**
 * Controller class for handling user interactions related to Album entities.
 * Manages input, validation, and delegates business logic to the service layer.
 */
public class AlbumController {
    private final AlbumService albumService;
    private final Scanner scanner = new Scanner(System.in);

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    /**
     * Reads and validates user input to create a new Album.
     * After validation, it sends the Artist object to the service layer.
     */
    public void createAlbum() {
        Album album = new Album();

        while (true) {
            System.out.print("The artist ID to whom the album belongs: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateArtistId(input);
            if (result.isValid()) {
                Artist artist = albumService.findArtist(Integer.parseInt(input));
                if (artist == null) {
                    System.out.println("Artist with Id: " + input + " not found");
                    return;
                } else {
                    album.setArtist(artist);
                    break;
                }
            } else {
                System.out.println(result.getMessage());
            }
        }

        while (true) {
            System.out.print("Title: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateTitle(input);
            if (result.isValid()) {
                album.setTitle(input);
                break;
            } else {
                System.out.println(result.getMessage());
            }
        }

        while (true) {
            System.out.print("Release year: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateReleaseYear(input);
            if (result.isValid()) {
                album.setReleaseYear(Integer.parseInt(input));
                break;
            }
            System.out.println(result.getMessage());
        }

        while (true) {
            System.out.print("Record label: ");
            String input = scanner.nextLine();
            ValidationResult result = Validator.validateLabel(input);
            if (result.isValid()) {
                album.setRecordLabel(input);
                break;
            }
            System.out.println(result.getMessage());
        }
        albumService.create(album);

    }

    //Displays all albums found in the database.
    public void displayAllAlbums() {
        List<Album> albumsList = albumService.read();
        if (albumsList.isEmpty()) {
            System.out.println("There are no album in the database");
        } else {
            for (Album album : albumsList) {
                System.out.println(album.toString());
            }
        }
    }

    /**
     * Updates an existing album’s information.
     * Prompts the user to enter the album ID, displays current details,
     * then asks for updated fields (optional).
     */
    public void updateAlbum() {
        System.out.print("Enter album Id to update: ");
        String updateIdInput = scanner.nextLine();
        ValidationResult res = Validator.validateNumberFormat(updateIdInput);
        if (!res.isValid()) {
            System.out.println(res.getMessage());
            return;
        }
        int albumId = Integer.parseInt(updateIdInput);

        Album album = albumService.findAlbum(albumId);
        //show album details
        if (album == null) {
            System.out.println("Album with Id: " + albumId + " not found");
            return;
        }
        System.out.println("Album details: " + album);


        while (true) {
            System.out.print("Enter new artist ID to whom the album belongs.(leave empty to keep the current one): ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                ValidationResult result = Validator.validateArtistId(input);
                if (result.isValid()) {
                    Artist artist = albumService.findArtist(Integer.parseInt(input));
                    if (artist == null) {
                        System.out.println("Artist with Id: " + input + " not found");
                        return;
                    } else {
                        album.setArtist(artist);
                        break;
                    }
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        System.out.print("Enter new title (leave empty to keep the current one): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.isEmpty()) {
            album.setTitle(newTitle);
        }

        while (true) {
            System.out.print("Enter new release year (leave empty to keep the current one): ");
            String releaseYearInput = scanner.nextLine();
            if (!releaseYearInput.isEmpty()) {
                ValidationResult result = Validator.validateReleaseYear(releaseYearInput);
                if (result.isValid()) {
                    int newReleaseYear = Integer.parseInt(releaseYearInput);
                    album.setReleaseYear(newReleaseYear);
                    break;
                } else {
                    System.out.println(result.getMessage());
                }
            } else {
                break;
            }
        }

        System.out.print("Enter new record label (leave empty to keep the current one): ");
        String newRecordLabel = scanner.nextLine();
        if (!newRecordLabel.isEmpty()) {
            album.setRecordLabel(newRecordLabel);
        }
        albumService.update(album);
    }

    //Deletes an album by ID after confirmation.
    public void deleteAlbum() {
        System.out.print("Enter album Id to delete: ");
        String deleteIdInput = scanner.nextLine();
        ValidationResult result = Validator.validateNumberFormat(deleteIdInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }
        int albumId = Integer.parseInt(deleteIdInput);
        Album albumToDelete = albumService.findAlbum(albumId);
        if (albumToDelete == null) {
            System.out.println("Album with ID " + deleteIdInput + " does not exist!");
        } else {
            String confirmation = "";
            while (!confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("n")) {
                System.out.print("Are you sure you want to delete this album? (select: y/n): ");
                confirmation = scanner.nextLine();
            }
            if (confirmation.equalsIgnoreCase("y")) {
                albumService.delete(albumId);
            }
        }
    }

    /**
     * Displays a list of all album labels from the discography,
     * prompts the user to select one, validates it, and then shows
     * all albums associated with that label.
     */
    public void displayAlbumsByLabel() {
        System.out.println("All labels from discography:");
        displayAllLabels();
        List<String> allLabels = albumService.readAllLabels();
        while (true) {
            System.out.println("Please, choose the label:");
            String labelInput = scanner.nextLine();
            ValidationResult result = Validator.validateLabel(labelInput);
            if (!allLabels.contains(labelInput)) {
                System.out.println("Label not found. Please enter a valid label from the list.");
            } else if (!result.isValid()) {
                System.out.println(result.getMessage());
            } else {
                List<Album> albumsByLabel = albumService.readAlbumsByLabel(labelInput);
                for (Album album : albumsByLabel) {
                    System.out.println(album.albumsAndArtists());
                }
                break;
            }
        }
    }

    //Displays all unique labels found in the album database.
    public void displayAllLabels() {
        List<String> labels = albumService.readAllLabels();
        for (String label : labels) {
            System.out.println(label);
        }
    }

    /**
     * Prompts the user for an artist ID and displays their full discography,
     * including all albums associated with the artist.
     */
    public void displayArtistDiscography() {
        System.out.println("Please, enter artist's id:");
        String artistId = scanner.nextLine();
        ValidationResult result = Validator.validateNumberFormat(artistId);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return;
        }
        int id = Integer.parseInt(artistId);
        Artist artist = albumService.findArtist(id);

        if (artist == null) {
            System.out.println("Model.Artist with ID " + artistId + " does not exist!");
            return;
        }

        List<Album> artistAlbums = albumService.readArtistDiscography(id);
        Discography discography = new Discography(artist, artistAlbums);
        System.out.println(discography);
    }

}
