import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/views/admin.jsp")
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "admin"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "admin"
                })
        })
public class AdminServlet extends HttpServlet{


}
