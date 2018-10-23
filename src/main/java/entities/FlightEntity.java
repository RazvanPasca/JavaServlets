package entities;

import lombok.Builder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "flights", schema = "assignment-one")
@Builder
public class FlightEntity {
    private int id;
    private String airplaneType;
    private Timestamp arrivalTime;
    private Timestamp departureTime;
    private int flightNr;

    @ManyToOne
    @JoinColumn(name = "departure_city_id")
    private CityEntity departureCity;

    @ManyToOne
    @JoinColumn(name = "arrival_city_id")
    private CityEntity arrivalCity;

    public FlightEntity() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "flight_nr")
    public int getFlightNr() {
        return flightNr;
    }

    public void setFlightNr(int flightNr) {
        this.flightNr = flightNr;
    }


    @Basic
    @Column(name = "airplane_type")
    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    @Basic
    @Column(name = "arrival_time")
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "departure_time")
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return id == that.id &&
                Objects.equals(airplaneType, that.airplaneType) &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, airplaneType, arrivalTime, departureTime);
    }
}
