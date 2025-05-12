package com.link;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book = null;
        List<Book> booksList = null;
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction(); // start transaction

           /*insert
           book = new Book("Beginning Hibernate", 226);
           session.persist(book); //save object in database
            */

            /*read
            book = session.get(Book.class, 1);
             */

            /*update
            book = session.get(Book.class, 2);
            book.setTitle("Beginning Hibernate 2");
            session.merge(book);
             */

              /*delete
            book = session.get(Book.class, 2);
            session.remove(book);
             */
            
            //read all books
            Query<Book> query = session.createQuery("from Book", Book.class);
            booksList = query.list();


            tx.commit(); //end transaction
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        /* get generated Id if inserted successfully
        if(book != null) {
            System.out.println(book.getId());
        }
         */


        /* read a book if isn't empty
        if (book != null) {
            System.out.println(book);
        }
         */

        //read all books
        if (booksList != null) {
            for (Book b : booksList) {
                System.out.println(b);
            }
        }

    }
}
