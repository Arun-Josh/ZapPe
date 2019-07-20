import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {
    static Connection con;
    static PreparedStatement ps;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ZAPPE","root","root");
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    static final boolean authLogin(String mail, String pass)throws Exception{
        ps = con.prepareStatement("SELECT * FROM USERS WHERE MAILID = ? AND PASSWORD = ?");
        ps.setString(1,mail);
        ps.setString(2,pass);
        ResultSet rs =  ps.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
    }
}
