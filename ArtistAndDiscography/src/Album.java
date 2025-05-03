public class Album {
    private int id;
    private int artist_id;
    private String title;
    private int releaseYear;
    private String recordLabel;


    public Album(int id, int artistId, String title, int releaseYear, String recordLabel) {
        this.id = id;
        this.artist_id = artistId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.recordLabel = recordLabel;
    }

    public Album(int artistId, String title, int releaseYear, String recordLabel) {
        this.artist_id = artistId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.recordLabel = recordLabel;
    }

    public int getId() {
        return id;
    }

    public int getArtist_id() {
        return artist_id;
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

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
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
        return "Album id: "+ this.id + " title: " + this.title + " releaseYear: " + this.releaseYear + " recordLabel: " + this.recordLabel;
    }
}
