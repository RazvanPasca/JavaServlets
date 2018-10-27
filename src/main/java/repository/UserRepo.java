package repository;

import entities.UserEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
public class UserRepo {

    private SessionFactory factory;

    public List<UserEntity> findUsersByUsername(String username) {

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        List users = session.createQuery("FROM UserEntity where name = :name").
                setParameter("name", username).list();
        List<UserEntity> userEntities = (List<UserEntity>) users;
        tx.commit();

        return userEntities;
    }

    public List<UserEntity> findAllUsers() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List users = session.createQuery("FROM UserEntity").list();
        List<UserEntity> userEntities = (List<UserEntity>) users;
        tx.commit();
        return userEntities;
    }
}
