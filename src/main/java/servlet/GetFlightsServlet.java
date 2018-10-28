package servlet;

import entities.FlightEntity;
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
import java.util.List;

@WebServlet("/getFlights")
public class GetFlightsServlet extends HttpServlet {

    private FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory()), new CityService(new CityRepo(SessionFactoryProvider.getSessionFactory())));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightEntity> airplanes = flightsService.findAllFlights();
        req.getSession().setAttribute("flights", airplanes);
        resp.sendRedirect("/redirect");
    }
}
