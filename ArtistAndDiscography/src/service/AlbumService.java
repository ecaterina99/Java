package service;
import model.Album;
import model.Artist;
import repository.AlbumRepository;
import repository.ArtistRepository;
import java.sql.SQLException;
import java.util.List;

public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository repository, ArtistRepository artistRepository) {
        this.albumRepository = repository;
        this.artistRepository = artistRepository;
    }

    public List<String> readAllLabels() {
        return albumRepository.getAllLabels();
    }

    public List<Album> readAlbumsByLabel(String label) {
        return albumRepository.getAlbumsByLabel(label);
    }

    public List<Album> readArtistDiscography(int artistId) throws SQLException {
        return albumRepository.getAlbumsByArtistId(artistId);
    }

    public Artist findArtist(int artistId) {
        return artistRepository.findArtistById(artistId);
    }
}