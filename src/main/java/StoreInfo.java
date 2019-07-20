import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//import static org.bouncycastle.asn1.iana.IANAObjectIdentifiers.mail;

@WebServlet("/storeinfo")
public class StoreInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        System.out.println("Storing Info....");

        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String mobileno = request.getParameter("mobileno");
        String pass = request.getParameter("pass");
        String mail = request.getParameter("mail");
        System.out.println("name : "+ name+" pass : "+pass);

//        BlockChain.startPoint();

//        if (mail.equals("user@zappe.com") && pass.equals("qwertyuiop")){
            //Sessions
//            session.setAttribute("mail",mail);
//            response.getWriter().print("OK");
//        }
//        else {
            response.getWriter().print("OK");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
