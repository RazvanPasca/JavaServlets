package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String role = (String) request.getSession().getAttribute("role");

        if (role.equalsIgnoreCase("admin"))
            response.sendRedirect("views//admin/admin.jsp");
        else if (role.equalsIgnoreCase("user"))
            response.sendRedirect("views/user/user.jsp");
        else
            response.sendRedirect("login.jsp");
    }
}