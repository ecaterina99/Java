package controller;

import lib.ValidationResult;
import lib.Validator;
import model.Album;
import model.Artist;
import model.Discography;
import service.AlbumService;

import java.util.List;
import java.util.Scanner;

public class AlbumController {
    private final AlbumService albumService;
    private final Scanner scanner = new Scanner(System.in);

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    public void createAlbum() {
        Album album = new Album();

        while (true) {
            System.out.print("Artist id: ");
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
        albumService.save(album);

    }

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
            System.out.print("Enter new artist id (leave empty to keep the current one): ");
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
        albumService.save(album);

    }

    public void deleteAlbum() {
    }

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

    public void displayAllLabels() {
        List<String> labels = albumService.readAllLabels();
        for (String label : labels) {
            System.out.println(label);
        }
    }

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
