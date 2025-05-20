package repository;

import connection.HibernateConnection;
import model.Artist;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

public class ArtistRepository {
    private final HibernateConnection connection;
    Session session = null;

    public ArtistRepository() {
        this.connection = HibernateConnection.getInstance();
    }

    public void insertArtist(Artist artist) {
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

    public Artist findArtistById(int id) {
        try {
            session = connection.beginTransaction();

            String hql = "from Artist where id = :id";
            Query<Artist> query = session.createQuery(hql, Artist.class);
            query.setParameter("id", id);
            Artist artist = query.uniqueResult();

            connection.commitTransaction(session);
            return artist;

        } catch (Exception e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error listing artists", e);
        }
    }

    public List<Artist> getAllArtists() {
        try {
            session = connection.beginTransaction();

            String hql = "from Artist";
            List<Artist> artistsList = session.createQuery(hql, Artist.class).list();
            connection.commitTransaction(session);
            return artistsList;

        } catch (Exception e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error listing artists", e);
        }
    }

    public void updateArtist(Artist artist) {
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

    public void deleteArtist(int id) {
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

    public  List<Artist> getSoloArtists() {
        try {
            session = connection.beginTransaction();
            String hql = "from Artist where type = 'Solo'";
            List<Artist> soloArtists =  session.createQuery(hql, Artist.class).list();

            if (soloArtists.isEmpty()) {
                connection.commitTransaction(session);
                return null;
            } else {
                connection.commitTransaction(session);
                return soloArtists;
            }
        } catch (HibernateException e) {
            connection.rollbackTransaction(session);
            throw new RuntimeException("Error displaying solo artist: " + e);
        }
    }

    public List<Artist> getArtistsAfterYear(int year) {
      try{
          session = connection.beginTransaction();
          String hql = "from Artist WHERE launchYear > :year";
          List<Artist> artistsFilteredByYear = session.createQuery(hql, Artist.class).setParameter("year", year).list();
          connection.commitTransaction(session);
            if (artistsFilteredByYear.isEmpty()) {
                return Collections.emptyList();
            } else {
                return artistsFilteredByYear;
            }
        } catch (HibernateException e) {
          connection.rollbackTransaction(session);
          throw new RuntimeException("Error displaying solo artist: " + e.getMessage());
      }
    }


}
