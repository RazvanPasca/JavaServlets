package servlet;


import repository.CityRepo;
import repository.FlightsRepo;
import repository.SessionFactoryProvider;
import service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/addFlight")
public class AddFlightServlet extends HttpServlet {

    private FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory()));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String airplaneType = req.getParameter("airplane");
        String departureCity = req.getParameter("departureCity");
        LocalDateTime departureDate = LocalDateTime.parse(req.getParameter("departureTime"));
        String arrivalCity = req.getParameter("arrivalCity");
        LocalDateTime arrivalDate = LocalDateTime.parse(req.getParameter("arrivalTime"));

        flightsService.setCityRepo(new CityRepo(SessionFactoryProvider.getSessionFactory()));

        flightsService.saveFlight(airplaneType,departureCity,departureDate,arrivalCity,arrivalDate);
        resp.sendRedirect("/views/admin/admin.jsp");

    }
}
