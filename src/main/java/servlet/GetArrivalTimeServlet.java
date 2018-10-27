package servlet;

import repository.FlightsRepo;
import repository.SessionFactoryProvider;
import service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getLocalArrival")
public class GetArrivalTimeServlet extends HttpServlet {

    FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider.getSessionFactory()));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request reached servlet");

        int flightId = Integer.parseInt(req.getParameter("flightId"));

        System.out.println(flightsService.getFlightById(flightId));
    }
}
