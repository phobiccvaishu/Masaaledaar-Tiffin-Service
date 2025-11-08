import java.io.*;
import java.net.*;
import java.sql.*;
import org.json.*;

public class MasaledarServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("🚀 Masaledar Server running on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream()
        ) {
            StringBuilder request = new StringBuilder();
            String line;
            while (!(line = in.readLine()).isEmpty()) {
                request.append(line).append("\r\n");
            }

            // Read POST body (email + password)
            char[] body = new char[1024];
            in.read(body);
            String bodyData = new String(body).trim();

            JSONObject json = new JSONObject(bodyData);
            String email = json.getString("email");
            String password = json.getString("password");

            // JDBC connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/masaledar", "root", "yourpassword");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            JSONObject response = new JSONObject();
            if (rs.next()) {
                response.put("status", "success");
                response.put("name", rs.getString("name"));
            } else {
                response.put("status", "fail");
            }

            String httpResponse =
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: application/json\r\n" +
                "Access-Control-Allow-Origin: *\r\n" +
                "Connection: close\r\n\r\n" +
                response.toString();

            out.write(httpResponse.getBytes());
            out.flush();

            conn.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
