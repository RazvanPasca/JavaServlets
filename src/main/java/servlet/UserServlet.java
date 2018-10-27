package servlet;

import entities.FlightEntity;
import service.FlightsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getFlights")
public class UserServlet extends HttpServlet {

    private FlightsService flightsService = new FlightsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightEntity> airplanes = flightsService.findAllFlights();
        System.out.println(airplanes);
        req.getSession().setAttribute("flights", airplanes);
        resp.sendRedirect("/views/user/user.jsp");
    }
}
