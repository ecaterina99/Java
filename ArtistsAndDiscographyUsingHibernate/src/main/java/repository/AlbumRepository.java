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
    private final HibernateConnection dbManager;

    public AlbumRepository() {
        this.dbManager = HibernateConnection.getInstance();
    }

    public void save(Album album) {
        Session session = null;
        try {
            session = dbManager.getSession();
            session.beginTransaction();
            session.merge(album);
            dbManager.commitTransaction(session);
            System.out.println("Album successfully added");
        } catch (HibernateException e) {
            dbManager.rollbackTransaction(session);
            throw new RuntimeException("Error inserting album", e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public List<Album> getAllAlbums() {
        Session session = null;
        try {
            session = dbManager.getSession();
            String hql = "from Album";
            return session.createQuery(hql, Album.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all albums", e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public void update(Album album) {
        Session session = null;
        try {
            session = dbManager.getSession();
            session.beginTransaction();
            session.merge(album);
            dbManager.commitTransaction(session);
            System.out.println("Album successfully updated");
        } catch (HibernateException e) {
            dbManager.rollbackTransaction(session);
            throw new RuntimeException("Error updating album", e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = dbManager.getSession();
            session.beginTransaction();
            Album album = session.get(Album.class, id);
            if (album != null) {
                session.remove(album);
                dbManager.commitTransaction(session);
                System.out.println("Album deleted successfully.");
            } else {
                dbManager.commitTransaction(session);
                System.out.println("Album with ID " + id + " does not exist.");
            }
        } catch (HibernateException e) {
            dbManager.rollbackTransaction(session);
            throw new RuntimeException("Error deleting album", e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public Album getAlbumById(int id) {
        Session session = null;
        try {
            session = dbManager.getSession();
            return session.get(Album.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting album by ID", e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public List<Album> getAlbumsByArtistId(int artistId) {
        Session session = null;
        try {
            session = dbManager.getSession();
            String hql = "from Album where artist.id = :artistId";
            return session.createQuery(hql, Album.class)
                    .setParameter("artistId", artistId)
                    .list();
        } catch (Exception e) {
            throw new RuntimeException("Error finding albums by artist id: " + e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public List<Album> getAlbumsByLabel(String recordLabel) {
        Session session = null;
        try {
            session = dbManager.getSession();
            String hql = "from Album a join fetch a.artist where a.recordLabel = :label";
            return session.createQuery(hql, Album.class)
                    .setParameter("label", recordLabel)
                    .list();
        } catch (Exception e) {
            throw new RuntimeException("Error getting albums by label: " + e);
        } finally {
            dbManager.closeSession(session);
        }
    }

    public List<String> getAllLabels() {
        Session session = null;
        try {
            session = dbManager.getSession();
            String hql = "select DISTINCT a.recordLabel from Album a";
            return session.createQuery(hql, String.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all labels: " + e);
        } finally {
            dbManager.closeSession(session);
        }
    }
}
