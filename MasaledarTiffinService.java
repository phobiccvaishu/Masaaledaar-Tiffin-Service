import java.sql.*;

public class MasaledarTiffinService {
    public static boolean validateLogin(String email, String password) {
        boolean isValid = false;
        try {
            Connection con = MasaledarJDBC.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            isValid = rs.next();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
