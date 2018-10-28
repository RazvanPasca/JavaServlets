package repository;

import entities.FlightEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class FlightsRepo {

    private SessionFactory factory;
    private static boolean wasDbChanged;

    public FlightsRepo(SessionFactory factory) {
        this.factory = factory;
    }

    public List<FlightEntity> findAllFlights() {
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        List flights = session.createQuery("FROM FlightEntity").list();
        List<FlightEntity> flightsEntities = (List<FlightEntity>) flights;
        tx.commit();
        setDbUnchanged();

        return flightsEntities;
    }

    public void saveFlight(FlightEntity flightEntity) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(flightEntity);
        tx.commit();
        setDbChanged();
    }

    public void updateFlight(FlightEntity flightEntity){
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(flightEntity);
        tx.commit();
        setDbChanged();
    }


    public void deleteFlight(int flightId) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.createQuery("delete from FlightEntity where id = :id").setParameter("id", flightId).executeUpdate();
        tx.commit();
        setDbChanged();
    }

    private void setDbChanged() {
        wasDbChanged = true;
    }

    public void setDbUnchanged() {
        wasDbChanged = false;
    }

    public boolean wasDbChanged() {
        return wasDbChanged;
    }
}
