package servlet;


import repository.CityRepo;
import repository.FlightsRepo;
import repository.SessionFactoryProvider;
import service.CityService;
import service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet {

    private FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory()), new CityService(new CityRepo(SessionFactoryProvider.getSessionFactory())));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int flightId = Integer.parseInt(req.getParameter("flightId"));
        String airplaneType = req.getParameter("airplane");
        String departureCity = req.getParameter("departureCity");
        LocalDateTime departureDate = LocalDate.parse(req.getParameter("departureTime"), format).atStartOfDay();
        String arrivalCity = req.getParameter("arrivalCity");
        LocalDateTime arrivalDate = LocalDate.parse(req.getParameter("arrivalTime"), format).atStartOfDay();

        if (flightId == 0)
            flightsService.saveFlight(airplaneType, departureCity, departureDate, arrivalCity, arrivalDate);
        else
            flightsService.updateFlight(airplaneType, departureCity, departureDate, arrivalCity, arrivalDate, flightId);
        resp.sendRedirect("/getFlights");
    }
}
