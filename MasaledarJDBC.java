import java.sql.*;

public class MasaledarJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/masaledar_tiffin";
        String user = "root";
        String password = "vaishu@1604";

        try {
       
            Class.forName("com.mysql.cj.jdbc.Driver");

         
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to Masaledar Tiffin Database!");

        
            Statement stmt = con.createStatement();

            
            ResultSet rs = stmt.executeQuery("SELECT * FROM daily_menu");

            System.out.println("\n--- Daily Menu ---");
            while (rs.next()) {
                System.out.println(rs.getString("day_name") + " (" + rs.getString("meal_type") + "): " + rs.getString("items"));
            }

        
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
