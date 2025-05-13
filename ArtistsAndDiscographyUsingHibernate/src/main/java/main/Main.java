package main;

import lib.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction(); // start transaction


            //main logic
            String hql = "from Artist";
            Query query = session.createQuery(hql);
            List<Artist> artists = query.list();
            for (Artist artist : artists) {
                System.out.println(artist);
            }

            tx.commit(); //end transaction
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }


    }
}