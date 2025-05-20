package repository;

import connection.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AlbumRepository {
    private Session session;

    public AlbumRepository() {
        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
        }catch(HibernateException e) {
            e.printStackTrace();
        }
    }
}
