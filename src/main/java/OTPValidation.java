import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/otp")
public class OTPValidation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

//        HttpSession session = request.getSession();
        String mail = request.getParameter("mail");
        String mobile = request.getParameter("mobile");
        System.out.println("mail : "+ mail+" pass : "+mobile);

//        BlockChain.startPoint();

        if (mail.equals("12345") && mobile.equals("54321")){
            //Sessions
//            session.setAttribute("mail",mail);
            System.out.println("OTP sucess");
            response.getWriter().print("OK");
        }
        else {
            System.out.println("OTP Failed");
            response.getWriter().print("NO");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
