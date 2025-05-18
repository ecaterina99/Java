package repository;

import connection.DBConnection;
import model.Album;
import model.Artist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {

    private Connection connection;

    public AlbumRepository() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Album> getAlbumsByLabel(String recordLabel) {
        List<Album> albumsByLabel = new ArrayList<>();

        String query = "SELECT a.id, a.artist_id, a.title, a.release_year, a.record_label, " +
                "art.id, art.name, art.type, art.launch_year, art.split_year, art.website " +
                "FROM albums a JOIN artists art ON a.artist_id = art.id WHERE a.record_label = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, recordLabel);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Artist artist = new Artist(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("type"),
                            resultSet.getInt("launch_year"),
                            resultSet.getInt("split_year"),
                            resultSet.getString("website")
                    );

                    Album album = new Album(
                            resultSet.getInt("id"),
                            resultSet.getInt("artist_id"),
                            resultSet.getString("title"),
                            resultSet.getInt("release_year"),
                            resultSet.getString("record_label"),
                            artist
                    );
                    albumsByLabel.add(album);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return albumsByLabel;
    }

    public List<String> getAllLabels() {
        List<String> labels = new ArrayList<>();
        try (
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("SELECT DISTINCT record_label FROM albums")) {
            while (rs.next()) {
                labels.add(rs.getString("record_label"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return labels;
    }

    public List<Album> getAlbumsByArtistId(int artistId) throws SQLException {
        List<Album> albums = new ArrayList<>();
        String query = "SELECT artist_id, title, release_year, record_label FROM albums WHERE artist_id = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artistId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Album album = new Album(
                            resultSet.getInt("artist_id"),
                            resultSet.getString("title"),
                            resultSet.getInt("release_year"),
                            resultSet.getString("record_label")
                    );
                    albums.add(album);
                }
            }
        }
        return albums;
    }


}
