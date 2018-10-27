package repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

        } catch (Exception e) {
            throw new RuntimeException("Exception when creating sessionFactory");
        }
    }

    private SessionFactoryProvider() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
