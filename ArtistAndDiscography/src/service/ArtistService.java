package service;

import model.Artist;
import repository.ArtistRepository;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    private final ArtistRepository repository;

    public ArtistService(ArtistRepository repository) {
        this.repository = repository;
    }

    public void createArtist(Artist artist) throws SQLException {
        repository.insertArtistIntoDatabase(artist);
    }

    public void updateArtist(Artist artist) throws SQLException {
        repository.update(artist);
    }

    public void deleteArtist(Artist artist, int artistId) throws SQLException {
        repository.deleteArtistFromDatabase(artist, artistId);
    }

    public List<Artist> readArtist(){
        return repository.getAllArtists();
    }

    public List<Artist> readSoloArtists(){
        return repository.getSoloArtists();
    }

    public List<Artist> readArtistsAfterYear(){
        return repository.getArtistsAfterYear();
    }



}
