package repository;

import connection.HibernateConnection;
import model.Album;
import org.hibernate.Session;

import java.util.List;

public class AlbumRepository {
    private final HibernateConnection connection;
    Session session = null;

    public AlbumRepository() {
        this.connection = HibernateConnection.getInstance();
    }

    public List<Album> getAlbumsByLabel(String recordLabel) {
        try {
            session = connection.beginTransaction();
            String hql = "from Album a join fetch a.artist where a.recordLabel = :label";
            List<Album> albumsByLabel = session.createQuery(hql, Album.class).setParameter("label", recordLabel).list();
            connection.commitTransaction(session);
            return albumsByLabel;
        } catch (Exception e) {
            System.err.println("Error getting albums by label: " + e.getMessage());
            return null;
        }
    }

    public List<String> getAllLabels() {
        try {
            session = connection.beginTransaction();
            String hql = "select DISTINCT a.recordLabel from Album a";
            List<String> recordLabels = session.createQuery(hql, String.class).getResultList();
            connection.commitTransaction(session);
            return recordLabels;
        } catch (Exception e) {
            System.err.println("Error getting all labels: " + e.getMessage());
            return null;
        }
    }

    public List<Album> getAlbumsByArtistId(int artistId) {
        try {
            session = connection.beginTransaction();
            String hql = "from Album where artist.id= :artistId";
            List<Album> albums = session.createQuery(hql, Album.class).setParameter("artistId", artistId).list();
            return albums;
        } catch (Exception e) {
            System.err.println("Error finding albums by artist id: " + e.getMessage());
            return null;
        }
    }

}
