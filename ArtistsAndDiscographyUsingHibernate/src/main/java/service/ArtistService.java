package service;

import model.Artist;
import repository.ArtistRepository;

import java.util.List;
/**
 * Service layer for artist-related operations.
 * This class acts as a bridge between the controller and the repository layer.
 */
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public void create(Artist artist) {
        artistRepository.save(artist);
    }

    public List<Artist> read() {
        return artistRepository.getAllArtists();
    }

    public void update(Artist artist) {
        artistRepository.update(artist);
    }

    public void delete(int artistId) {
        artistRepository.delete(artistId);
    }

    public Artist findArtist(int id) {
        return artistRepository.findArtistById(id);
    }

    public List<Artist> readSoloArtists() {
        return artistRepository.getSoloArtists();
    }

    public List<Artist> readArtistsAfterYear(int year) {
        return artistRepository.getArtistsAfterYear(year);
    }

}
