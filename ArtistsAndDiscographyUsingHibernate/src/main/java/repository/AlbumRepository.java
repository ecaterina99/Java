package repository;

import connection.HibernateConnection;
import model.Album;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class AlbumRepository {
    private final HibernateConnection connection;

    public AlbumRepository() {
        this.connection = HibernateConnection.getInstance();
    }

    public void save(Album album) {
        Session session = null;
        try {
            session = connection.beginTransaction();

            session.merge(album);

            connection.commitTransaction(session);
            System.out.println("Album successfully added");
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error inserting album", e);
        }
    }

    public List<Album> getAlbumsByLabel(String recordLabel) {
        Session session = null;

        try {
            session = connection.beginTransaction();

            String hql = "from Album a join fetch a.artist where a.recordLabel = :label";
            List<Album> albumsByLabel = session.createQuery(hql, Album.class).setParameter("label", recordLabel).list();

            connection.commitTransaction(session);
            return albumsByLabel;
        } catch (Exception e) {
            throw new RuntimeException("Error getting albums by label: " + e);
        }
    }

    public List<String> getAllLabels() {
        Session session = null;

        try {
            session = connection.beginTransaction();

            String hql = "select DISTINCT a.recordLabel from Album a";
            List<String> recordLabels = session.createQuery(hql, String.class).getResultList();

            connection.commitTransaction(session);
            return recordLabels;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all labels: " + e);

        }
    }

    public List<Album> getAlbumsByArtistId(int artistId) {
        Session session = null;

        try {
            session = connection.beginTransaction();

            String hql = "from Album where artist.id= :artistId";
            List<Album> albums = session.createQuery(hql, Album.class).setParameter("artistId", artistId).list();

            return albums;
        } catch (Exception e) {
            throw new RuntimeException("Error finding albums by artist id: " + e);
        }
    }

}
