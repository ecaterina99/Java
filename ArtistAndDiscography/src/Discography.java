import model.Album;
import model.Artist;

import java.util.List;

public class Discography {
    private Artist artist;
    private List<Album> albums;

    public Discography(Artist artist, List<Album> albums) {
        this.artist = artist;
        this.albums = albums;
    }

    public Artist getArtist() {
        return artist;
    }
    public List<Album> getAlbums() {
        return albums;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Model.Artist: ").append(artist.getName())
                .append(" (").append(artist.getType()).append(")\n");

        if (albums.isEmpty()) {
            sb.append("No albums found for this artist.");
        } else {
            sb.append("Albums:\n");
            for (Album album : albums) {
                sb.append(" - ").append(album.getTitle())
                        .append(" (").append(album.getReleaseYear()).append(")")
                        .append(", Label: ").append(album.getRecordLabel())
                        .append("\n");
            }
        }

        return sb.toString();
    }
}
