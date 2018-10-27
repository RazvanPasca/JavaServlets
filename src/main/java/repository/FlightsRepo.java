package repository;

import entities.FlightEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@AllArgsConstructor
public class FlightsRepo {

    private SessionFactory factory;


    public List<FlightEntity> findAllFlights() {
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        List flights = session.createQuery("FROM FlightEntity").list();
        List<FlightEntity> flightsEntities = (List<FlightEntity>) flights;
        tx.commit();

        return flightsEntities;
    }


}
