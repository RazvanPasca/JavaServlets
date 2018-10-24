package repository;

import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserRepo {

    private static SessionFactory factory;


    public List<UserEntity> findUsersByUsername(String username) {

        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = null;

        tx = session.beginTransaction();
        List users = session.createQuery("FROM UserEntity where name = :name").
                setParameter("name", username).list();
        List<UserEntity> userEntities = (List<UserEntity>) (Object) users;
        tx.commit();

        return userEntities;
    }
}
