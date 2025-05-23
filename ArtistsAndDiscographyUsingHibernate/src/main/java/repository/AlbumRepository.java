package repository;

import connection.HibernateConnection;
import model.Album;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Repository class responsible for managing Album data in the database.
 */
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

    public List<Album> getAllAlbums() {
        try (Session session = connection.getSession()) {
            String hql = "from Album";
            return session.createQuery(hql, Album.class).list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Album album) {
        Session session = null;
        try {
            session = connection.beginTransaction();
            session.merge(album);
            connection.commitTransaction(session);
            System.out.println("Album successfully updated");
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error updating album", e);
        }
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = connection.beginTransaction();

            Album album = session.get(Album.class, id);
            if (album != null) {
                session.remove(album);
                connection.commitTransaction(session);
                System.out.println("Album deleted successfully.");
            } else {
                connection.commitTransaction(session);
                System.out.println("Album with ID " + id + " does not exist.");
            }
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error deleting album", e);
        }
    }

    public Album getAlbumById(int id) {
        try (Session session = connection.getSession()) {
            return session.get(Album.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Album> getAlbumsByArtistId(int artistId) {
        try (Session session = connection.getSession()) {
            String hql = "from Album where artist.id= :artistId";
            return session.createQuery(hql, Album.class).setParameter("artistId", artistId).list();
        } catch (Exception e) {
            throw new RuntimeException("Error finding albums by artist id: " + e);
        }
    }

    public List<Album> getAlbumsByLabel(String recordLabel) {
        try (Session session = connection.getSession()) {
            String hql = "from Album a join fetch a.artist where a.recordLabel = :label";
            return session.createQuery(hql, Album.class).setParameter("label", recordLabel).list();
        } catch (Exception e) {
            throw new RuntimeException("Error getting albums by label: " + e);
        }
    }

    public List<String> getAllLabels() {
        try (Session session = connection.getSession()) {
            String hql = "select DISTINCT a.recordLabel from Album a";
            return session.createQuery(hql, String.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all labels: " + e);
        }
    }

}
