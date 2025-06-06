package model;

public class Album {
    private int id;
    private int artistId;
    private String title;
    private int releaseYear;
    private String recordLabel;
    private Artist artist;

    public Album(int id, int artistId, String title, int releaseYear, String recordLabel, Artist artist) {
        this.id = id;
        this.artistId = artistId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.recordLabel = recordLabel;
        this.artist = artist;
    }

    public Album(int artistId, String title, int releaseYear, String recordLabel) {
        this.artistId = artistId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.recordLabel = recordLabel;
    }

    public int getId() {
        return id;
    }

    public int getArtistId() {
        return artistId;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    @Override
    public String toString() {
        return "Model.Album title: " + this.title + ", release year: " + this.releaseYear + ", record label: " + this.recordLabel;
    }

    public String albumsAndArtists() {
        return "Record label: " + this.recordLabel + ", album title: " + this.title + ", release year: " + this.releaseYear + ", artist: " + artist.toString();
    }
}
