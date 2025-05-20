package controller;

import service.AlbumService;

import java.util.Scanner;

public class AlbumController {
    private final AlbumService albumService;
    private final Scanner scanner = new Scanner(System.in);

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

}
