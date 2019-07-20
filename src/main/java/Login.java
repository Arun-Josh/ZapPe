import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        System.out.println("mail : "+ mail+" pass : "+pass);

        BlockChain.startPoint();

        if (mail.equals("user@zappe.com") && pass.equals("qwertyuiop")){
            //Sessions
                session.setAttribute("mail",mail);
                response.getWriter().print("OK");
        }
        else {
            response.getWriter().print("NO");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
