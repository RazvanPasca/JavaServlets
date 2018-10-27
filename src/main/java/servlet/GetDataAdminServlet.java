package servlet;

import entities.FlightEntity;
import entities.UserEntity;
import repository.FlightsRepo;
import repository.SessionFactoryProvider;
import repository.UserRepo;
import service.FlightsService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getDataAdmin")
public class GetDataAdminServlet extends HttpServlet {

    private FlightsService flightsService = new FlightsService(new FlightsRepo(SessionFactoryProvider
            .getSessionFactory()));
    private UserService userService = new UserService(new UserRepo(SessionFactoryProvider.getSessionFactory()));


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FlightEntity> airplanes = flightsService.findAllFlights();
        List<UserEntity> users = userService.findAllUsers();

        req.getSession().setAttribute("flights", airplanes);
        req.getSession().setAttribute("users", users);

        resp.sendRedirect("views/admin/admin.jsp");
    }
}