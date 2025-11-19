package repository;

import connection.HibernateConnection;
import model.Artist;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

/**
 * Repository class responsible for managing Artist data in the database.
 */
public class ArtistRepository {
    private final HibernateConnection connection;

    public ArtistRepository() {
        this.connection = HibernateConnection.getInstance();
    }

    public void save(Artist artist) {
        Session session = null;
        try {
            session = connection.getSession();
            session.beginTransaction();
            session.persist(artist);
            connection.commitTransaction(session);
            System.out.println("Artist successfully added with ID: " + artist.getId());
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error inserting artist", e);
        } finally {
            connection.closeSession(session);
        }
    }

    public List<Artist> getAllArtists() {
        Session session = null;
        try {
            session = connection.getSession();
            String hql = "from Artist";
            return session.createQuery(hql, Artist.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Error listing artists", e);
        } finally {
            connection.closeSession(session);
        }
    }

    public void update(Artist artist) {
        Session session = null;
        try {
            session = connection.getSession();
            session.beginTransaction();
            session.merge(artist);
            connection.commitTransaction(session);
            System.out.println("Artist successfully updated");
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error updating artist", e);
        } finally {
            connection.closeSession(session);
        }
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = connection.getSession();
            session.beginTransaction();
            Artist artist = session.get(Artist.class, id);
            if (artist != null) {
                session.remove(artist);
                connection.commitTransaction(session);
                System.out.println("Artist deleted successfully.");
            } else {
                connection.commitTransaction(session);
                System.out.println("Artist with ID " + id + " does not exist.");
            }
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error deleting artist", e);
        } finally {
            connection.closeSession(session);
        }
    }

    public Artist findArtistById(int id) {
        Session session = null;
        try {
            session = connection.getSession();
            return session.get(Artist.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding artist", e);
        } finally {
            connection.closeSession(session);
        }
    }

    public List<Artist> getSoloArtists() {
        Session session = null;
        try {
            session = connection.getSession();
            String hql = "from Artist where type = 'Solo'";
            return session.createQuery(hql, Artist.class).list();
        } catch (HibernateException e) {
            throw new RuntimeException("Error displaying solo artist", e);
        } finally {
            connection.closeSession(session);
        }
    }

    public List<Artist> getArtistsAfterYear(int year) {
        Session session = null;
        try {
            session = connection.getSession();
            String hql = "from Artist WHERE launchYear > :year";
            return session.createQuery(hql, Artist.class)
                    .setParameter("year", year)
                    .list();
        } catch (HibernateException e) {
            throw new RuntimeException("Error filtering artists by year", e);
        } finally {
            connection.closeSession(session);
        }
    }
}
