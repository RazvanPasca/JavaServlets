package repository;

import entities.FlightEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FlightsRepo {

    private static SessionFactory factory;


    public List<FlightEntity> findAllFlights() {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        List flights = session.createQuery("FROM FlightEntity").list();
        List<FlightEntity> flightsEntities = (List<FlightEntity>) flights;
        tx.commit();

        return flightsEntities;
    }


}
