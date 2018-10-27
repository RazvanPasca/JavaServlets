package servlet;

import entities.UserEntity;
import repository.UserRepo;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService(new UserRepo());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();
        Optional<UserEntity> user = userService.areCredentialsValid(username, pass);

        if (user.get().getRole().equalsIgnoreCase("user")) {
            session.setAttribute("username", username);
            session.setAttribute("role", "user");
            resp.sendRedirect("/getFlights");
        } else if (user.get().getRole().equalsIgnoreCase("admin")) {
            session.setAttribute("username", username);
            session.setAttribute("role", "admin");
            resp.sendRedirect("/getFlights");
        } else {
            session.setAttribute("error", "Invalid credentials");
            resp.sendRedirect("/");
        }
    }
}
