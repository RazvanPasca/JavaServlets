package repository;

import entities.CityEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CityRepo {

    SessionFactory sessionFactory;

    public CityRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CityEntity> findAllCities() {
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        List flights = session.createQuery("FROM CityEntity ").list();
        List<CityEntity> cityEntities = (List<CityEntity>) flights;
        tx.commit();

        return cityEntities;
    }

    public void saveCity(CityEntity cityEntity) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(cityEntity);
        tx.commit();
    }

    public List<CityEntity> findCitiesByName(String cityName) {
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        List cities = session.createQuery("FROM CityEntity where name =:name").setParameter("name", cityName).list();
        List<CityEntity> cityEntities = (List<CityEntity>) cities;
        tx.commit();

        return cityEntities;
    }

}
