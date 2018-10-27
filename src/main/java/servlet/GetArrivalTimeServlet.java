package servlet;

import repository.FlightsRepo;
import repository.SessionFactoryProvider;
import service.FlightsService;
import service.UtilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getLocalArrival")
public class GetArrivalTimeServlet extends HttpServlet {

    String url = "https://maps.googleapis.com/maps/api/timezone/json?location=%s,%s&timestamp=%s&key=AIzaSyD9BOYiPPJ3hYvpwMd9xzNqNTFMnaUaNbE";

    private UtilityService utilityService = new UtilityService(new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory())), url);

    private FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory()));


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flightId = Integer.parseInt(req.getParameter("flightId"));

        System.out.println(utilityService.getArrivalTime(flightId));
        req.getSession().setAttribute("newArrivalTime", utilityService.getArrivalTime(flightId));
        req.getSession().setAttribute("arrivalCity", flightsService.getFlightById(flightId).getArrivalCity());
        req.getSession().setAttribute("flightId", flightId);
        resp.sendRedirect("/views/user/user.jsp");
    }
}
