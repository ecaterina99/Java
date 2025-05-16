package repository;

import connection.DBConnection;
import lib.ValidationResult;
import lib.Validator;
import model.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtistRepository {
    Connection conn = DBConnection.getConnection();

    public ArtistRepository() throws SQLException {
    }
    public void insertArtistIntoDatabase(Artist artist) throws SQLException {
        String query = "INSERT INTO artists (name, type, launch_year, split_year, website) VALUES (?, ?, ?, ?, ?)";

        try (
                PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, artist.getName());
            ps.setString(2, artist.getType());
            ps.setInt(3, artist.getLaunchYear());

            if (artist.getSplitYear() != null) {
                ps.setInt(4, artist.getSplitYear());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            if (artist.getWebsite() != null && !artist.getWebsite().isEmpty()) {
                ps.setString(5, artist.getWebsite());
            } else {
                ps.setNull(5, Types.VARCHAR);
            }

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Inserting artist failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Model.Artist added successfully with ID: " + id);
                } else {
                    throw new SQLException("Inserting artist failed, no ID obtained.");
                }
            }
        }
    }

    public static Artist findArtistById(int id) {
        String query = "SELECT * FROM artists WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    Artist artist = new Artist(
                            resultSet.getString("name"),
                            resultSet.getString("type"),
                            resultSet.getInt("launch_year"),
                            resultSet.getObject("split_year") != null ? resultSet.getInt("split_year") : null,
                            resultSet.getString("website")
                    );
                    artist.setId(resultSet.getInt("id"));
                    return artist;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void update(Artist artist) throws SQLException {
        String query = "update artists set name=?, type=?, launch_year=?, split_year=?, website=? where id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)
        ) {
            ps.setString(1, artist.getName());
            ps.setString(2, artist.getType());
            ps.setInt(3, artist.getLaunchYear());

            if (artist.getSplitYear() != null) {
                ps.setInt(4, artist.getSplitYear());
            } else {
                ps.setNull(4, Types.INTEGER);
            }

            if (artist.getWebsite() != null && !artist.getWebsite().isEmpty()) {
                ps.setString(5, artist.getWebsite());
            } else {
                ps.setNull(5, Types.VARCHAR);
            }

            ps.setInt(6, artist.getId());

            if (ps.executeUpdate() > 0) {
                System.out.println("Model.Artist updated successfully!");
            } else {
                System.out.println("No artist was updated.");
            }
        }
    }

    public void deleteArtistFromDatabase(Artist artist,int id)  {
        String query = "delete from artists where id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Model.Artist deleted successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Artist> getAllArtists() {
        List<Artist> artistsList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("select * from artists")) {
            while (rs.next()) {
                Artist a = new Artist(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("launch_year"),
                        rs.getInt("split_year"),
                        rs.getString("website"));
                artistsList.add(a);
            }
            return artistsList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Artist> getSoloArtists(){
        List<Artist> soloArtists = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("select * from artists where type='Solo' ")) {
            while (rs.next()) {
                Artist artist = new Artist(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("launch_year"),
                        rs.getInt("split_year"),
                        rs.getString("website")
                );
                soloArtists.add(artist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (soloArtists.isEmpty()) {
            System.out.println("No solo artists found in the database.");
            return null;
        } else {
            return soloArtists;
        }
    }

    public  List<Artist> getArtistsAfterYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year to filter artists after: ");
        String yearInput = scanner.nextLine();

        ValidationResult result = Validator.validateNumberFormat(yearInput);
        if (!result.isValid()) {
            System.out.println(result.getMessage());
            return null;
        }

        int year = Integer.parseInt(yearInput);
        List<Artist> artistsFilteredByYear = new ArrayList<>();
        String query = "SELECT * FROM artists WHERE launch_year > ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
                statement.setInt(1, year);

                while (resultSet.next()) {
                    Artist artist = new Artist(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("type"),
                            resultSet.getInt("launch_year"),
                            resultSet.getInt("split_year"),
                            resultSet.getString("website")
                    );
                    artistsFilteredByYear.add(artist);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        if (artistsFilteredByYear.isEmpty()) {
            System.out.println("No artists found that launched after year " + year + ".");
            return null;
        } else {
            return artistsFilteredByYear;
        }
    }
}

