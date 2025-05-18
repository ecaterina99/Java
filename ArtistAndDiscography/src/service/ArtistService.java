package service;

import model.Artist;
import repository.ArtistRepository;
import java.sql.SQLException;
import java.util.List;

public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository repository) {
        this.artistRepository = repository;
    }

    public Artist findArtist(int id){
        return artistRepository.findArtistById(id);
    }

    public void createArtist(Artist artist) throws SQLException {
        artistRepository.insertArtist(artist);
    }

    public void updateArtist(Artist artist) throws SQLException {
        artistRepository.updateArtist(artist);
    }

    public void deleteArtist(Artist artist, int artistId) throws SQLException {
        artistRepository.deleteArtist(artist, artistId);
    }

    public List<Artist> readArtist(){
        return artistRepository.getAllArtists();
    }

    public List<Artist> readSoloArtists(){
        return artistRepository.getSoloArtists();
    }

    public List<Artist> readArtistsAfterYear(int year){
        return artistRepository.getArtistsAfterYear(year);
    }
}
