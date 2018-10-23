package servlet;

import service.AdminService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();
    AdminService adminService = new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();
        if (userService.isUserValid(username, pass)) {

            session.setAttribute("username", username);
            session.setAttribute("role", "user");
            resp.sendRedirect("/views/user/user.jsp");
        } else if (adminService.isAdminValid(username, pass)) {

            session.setAttribute("username", username);
            session.setAttribute("role", "admin");
            resp.sendRedirect("/getFlights");
        } else {
            session.setAttribute("error", "Invalid credentials");
            resp.sendRedirect("/views/login.jsp");
        }
    }
}
