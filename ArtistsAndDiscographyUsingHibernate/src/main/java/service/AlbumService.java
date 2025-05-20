package service;

import repository.AlbumRepository;
import repository.ArtistRepository;

public class AlbumService {


    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository repository, ArtistRepository artistRepository) {
        this.albumRepository = repository;
        this.artistRepository = artistRepository;
    }

}
