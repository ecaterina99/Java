package repository;

import connection.HibernateConnection;
import model.Artist;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class ArtistRepository {
    private final HibernateConnection connection;

    /**
     * Repository class responsible for managing Artist data in the database.
     */
    public ArtistRepository() {
        this.connection = HibernateConnection.getInstance();
    }

    public void save(Artist artist) {
        Session session = null;
        try {
            session = connection.beginTransaction();

            session.persist(artist);

            connection.commitTransaction(session);
            System.out.println("Artist successfully added with ID: " + artist.getId());
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error inserting artist", e);
        }
    }

    public List<Artist> getAllArtists() {
        Session session = null;
        try {
            session = connection.getSession();
            String hql = "from Artist";
            return session.createQuery(hql, Artist.class).list();
        } catch (Exception e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error listing artists", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Artist artist) {
        Session session = null;
        try {
            session = connection.beginTransaction();

            session.merge(artist);

            connection.commitTransaction(session);
            System.out.println("Artist successfully updated");
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error updating artist", e);
        }
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = connection.beginTransaction();

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
        }
    }

    public Artist findArtistById(int id) {
        try (Session session = connection.getSession()) {
            return session.get(Artist.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Error finding artist", e);
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
            if (session != null) {
                session.close();
            }
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
            if (session != null) {
                session.close();
            }
        }
    }
}
