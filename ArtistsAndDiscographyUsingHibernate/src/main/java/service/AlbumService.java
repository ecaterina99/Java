package service;

import model.Album;
import model.Artist;
import repository.AlbumRepository;
import repository.ArtistRepository;
import java.util.List;

public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository repository, ArtistRepository artistRepository) {
        this.albumRepository = repository;
        this.artistRepository = artistRepository;
    }

    public void save(Album album) {
        albumRepository.save(album);
    }

    public void delete(Album album) {

    }

    public void update(Album album) {
        albumRepository.update(album);
    }

    public Album findAlbum(int id) {
        return albumRepository.findAlbumById(id);
    }

    public List<Album> readAlbumsByLabel(String label) {
        return albumRepository.getAlbumsByLabel(label);
    }

    public List<String> readAllLabels() {
        return albumRepository.getAllLabels();
    }

    public List<Album> readArtistDiscography(int artistId) {
        return albumRepository.getAlbumsByArtistId(artistId);
    }

    public Artist findArtist(int artistId) {
        return artistRepository.findArtistById(artistId);
    }


}
