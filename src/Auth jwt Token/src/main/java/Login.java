import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inide login");
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        System.out.println(name + " "+pass);

        if(name.equals("dragon") && pass.equals("j")){
            AuthToken authToken = new AuthToken();
            String str = authToken.createJWT("MSME",name,pass);
            resp.getWriter().println(str);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
