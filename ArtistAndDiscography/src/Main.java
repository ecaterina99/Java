import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Artist artist = new Artist("Rammstein", "band", 1994, 2025, "www.rammstein.de");
        Artist updatedArtist = new Artist("Rammstein", "band", 1994, 2025, "www.rammstein.de", 8);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/artists_catalog", "root", "123123");
        ) {
            System.out.println("Connected to database ");
            //insertArtist(conn, artist);
            //updateArtist(conn, updatedArtist);
            //deleteArtist(conn, 13);
          //  readArtists(conn);
          //  readAlbum(conn);
            showSoloArtists(conn);
            System.out.println();
            showArtistsNewGeneration(conn);


        } catch (SQLException e) {
            System.out.println("Error in database connection " + e.getMessage());
        }

    }


    public static void insertArtist(Connection conn, Artist artist) throws SQLException {
        String query = "insert into artists (name,type,launch_year,split_year,website) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, artist.getName());
        ps.setString(2, artist.getType());
        ps.setInt(3, artist.getLaunchYear());
        ps.setInt(4, artist.getSplitYear());
        ps.setString(5, artist.getWebsite());
        ps.execute();
    }

    public static void readArtists(Connection conn) throws SQLException {
        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists");

        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getString("name"), rs.getString("type"), rs.getInt("launch_year"), rs.getInt("split_year"), rs.getString("website"));
            artistsList.add(a);
        }

        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }


    public static void showSoloArtists(Connection conn) throws SQLException {
        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists where type='Solo' ");
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getString("name"), rs.getString("type"), rs.getInt("launch_year"), rs.getInt("split_year"), rs.getString("website"));
            artistsList.add(a);
        }
        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }


    public static void showArtistsNewGeneration(Connection conn) throws SQLException {
        List<Artist> artistsList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from artists where launch_year>2000 ");
        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Artist a = new Artist(rs.getString("name"), rs.getString("type"), rs.getInt("launch_year"), rs.getInt("split_year"), rs.getString("website"));
            artistsList.add(a);
        }
        for (Artist a : artistsList) {
            System.out.println(a.toString());
        }
    }


    public static void readAlbum(Connection conn) throws SQLException {
        List<Album> albumList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from albums");

        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Album al = new Album(rs.getInt("artist_id"), rs.getString("title"), rs.getInt("release_year"), rs.getString("record_label"));
            albumList.add(al);
        }

        for (Album al : albumList) {
            System.out.println(al.toString());
        }
    }


    public static void updateArtist(Connection conn, Artist artist) throws SQLException {
        String query = "update artists set name=?,type=?, launch_year=?,split_year=?,website=? where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, artist.getName());
        ps.setString(2, artist.getType());
        ps.setInt(3, artist.getLaunchYear());
        ps.setInt(4, artist.getSplitYear());
        ps.setString(5, artist.getWebsite());
        ps.setInt(6, artist.getId());
        ps.execute();

    }

    public static void deleteArtist(Connection conn, int id) throws SQLException {
        String query = "delete from artists where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.execute();
    }

}
