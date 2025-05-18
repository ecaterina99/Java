package controller;

import lib.ValidationResult;
import lib.Validator;
import model.Album;
import model.Artist;
import model.Discography;
import repository.ArtistRepository;
import service.AlbumService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AlbumController {

    private final AlbumService albumService;
    private final Scanner scanner=new Scanner(System.in);

    public AlbumController(AlbumService albumService) {
        this.albumService=albumService;
    }

    public void displayAlbumsByLabel() {
        System.out.println("All labels from discography:");
        displayAllLabels();
        List<String> allLabels =albumService.readAllLabels();

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

    public void displayAllLabels()  {
        List<String> labels = albumService.readAllLabels();
        for (String label : labels) {
            System.out.println(label);
        }
    }

    public void displayArtistDiscography() throws SQLException {
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
