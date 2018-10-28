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

@WebServlet("/deleteFlight")
public class DeleteFlightServlet extends HttpServlet {

    private FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory()), new CityService(new CityRepo(SessionFactoryProvider.getSessionFactory())));


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flightId = Integer.parseInt(req.getParameter("flightId"));

        flightsService.deleteFlight(flightId);
        resp.sendRedirect("/getFlights");
    }
}
