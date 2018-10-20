import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect")
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "user",
                        "admin"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "user",
                        "admin"
                })
        })
public class RedirectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.isUserInRole("admin"))
            response.sendRedirect("views/admin.jsp");
        else if (request.isUserInRole("user"))
            response.sendRedirect("views/user.jsp");
    }
}
