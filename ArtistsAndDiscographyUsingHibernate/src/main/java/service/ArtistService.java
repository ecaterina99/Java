package service;

import model.Artist;
import repository.ArtistRepository;

import java.sql.SQLException;
import java.util.List;


public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void createArtist(Artist artist){
        artistRepository.insertArtist(artist);
    }

    public Artist findArtist(int id) {
        return artistRepository.findArtistById(id);
    }

    public List<Artist> readArtist() {
        return artistRepository.getAllArtists();
    }

    public void updateArtist(Artist artist) {
        artistRepository.updateArtist(artist);
    }

    public void deleteArtist(int artistId){
        artistRepository.deleteArtist(artistId);
    }

    public List<Artist> readSoloArtists() {
        return artistRepository.getSoloArtists();
    }

    public List<Artist> readArtistsAfterYear(int year) {
        return artistRepository.getArtistsAfterYear(year);
    }

}
