package com.link;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //  Book book = null;
        //  List<Book> booksList = null;

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

            /*read all books
            Query<Book> query = session.createQuery("from Book", Book.class);
            booksList = query.list();

             */

           /*Create new publisher & book
            Publisher publisher = new Publisher();
            publisher.setName("Apress");
            Book book = new Book("Black house",254);
            book.setPublisher(publisher);
            session.persist(book);

            */

            /*
            //read all books HQL
            String hql = "from Book";
            Query query = session.createQuery(hql);
            List<Book> books = query.list();
            for (Book book : books) {
                System.out.println(book);
            }


            String hql2 = "select b.title from Book as b";
            String hql4 = "from Book b order by b.pageNo asc";

            String hql3 = "from Book b where b.title = 'Madam'";

            query = session.createQuery(hql2);
            List<String> bookTitles = query.list();
            System.out.println("**********************");
            for (String bookTitle : bookTitles) {
                System.out.println(bookTitle);
            }

            query = session.createQuery(hql3);
            List<Book> bookList = query.list();
            System.out.println("**********************");
            for (Book b : bookList) {
                System.out.println(b);
            }

             */

          /* update HQL
            String hql = "update Book books set books.pageNo=175 where books.id=1  ";
            Query query = session.createQuery(hql);
            int number = query.executeUpdate();
            System.out.println(number);

           */

            /*
            //delete HQL
            String hql = "delete Book as b where b.id=8  ";
            Query query = session.createQuery(hql);
            int number = query.executeUpdate();
            System.out.println(number);
             */

            //join HQL
            /*String hql5 = "select books.title as title, publisher.name as publisher "+
                    "from Book as books join  Publisher as publisher"+
                    "inner join books.publisher_id as publisher.id";

             */

            String hql = "select books.title as title, publisher.name as publisher " +
                    "from Book as books " +
                    "inner join books.publisher as publisher_id ";

            Query query = session.createQuery(hql);
            List<Object[]> bookList = query.list();
            for (Object[] books : bookList) {
                for (Object b : books) {
                    System.out.println(b);
                }
            }
            System.out.println("Left join:");
            String hql2 = "select books.title as title, publisher.name as publisher " +
                    "from Book as books " +
                    "left join books.publisher as publisher_id ";
            Query query2 = session.createQuery(hql2);
            List<Object[]> bookList2 = query2.list();
            for (Object[] books2 : bookList2) {
                for (Object b2 : books2) {
                    System.out.println(b2);
                }
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

        /*read all books
        if (booksList != null) {
            for (Book b : booksList) {
                System.out.println(b);
            }
        }
         */

    }
}
