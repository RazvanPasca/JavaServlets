package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "flights", schema = "flights-schema")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightEntity {
    private int id;
    private String airplaneType;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private CityEntity arrivalCity;
    private CityEntity departureCity;

    private int flightNr;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "arrival_city_id")
    public CityEntity getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(CityEntity arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "departure_city_id")
    public CityEntity getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(CityEntity departureCity) {
        this.departureCity = departureCity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "departure_time")
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
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

    @Override
    public String toString() {
        return "FlightEntity{" +
                "id=" + id +
                ", airplaneType='" + airplaneType + '\'' +
                ", arrivalCity=" + arrivalCity +
                ", departureCity=" + departureCity +
                '}';
    }
}
