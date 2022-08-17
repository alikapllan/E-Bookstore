import java.sql.*;

public class postresql_db_connection {
    private final String url = "jdbc:postgresql://localhost/ebuecherei";
    private final String user = "postgres";
    private final String password = "password";
    
    public Connection connect(){
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to PostreSQL Server successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {
        postresql_db_connection pSQL_db_connection = new postresql_db_connection();
        pSQL_db_connection.connect();
    }
}
