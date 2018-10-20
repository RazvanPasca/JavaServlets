import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/views/user.jsp")
@ServletSecurity(
                value = @HttpConstraint(
                        rolesAllowed = {
                                "user"
                        }),
                httpMethodConstraints = {
                        @HttpMethodConstraint(value = "GET", rolesAllowed = {
                                "user"
                        })
                })
public class UserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello");
    }
}
