import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static String url = "jdbc:mysql://localhost:3306/randomdatadb";
    static String user = "root";
    static String pass = "1234";
    static Connection connection;

    static void getConnection(){
        try {
            connection = DriverManager.getConnection(url, user, pass);

            if(connection != null){
                System.out.println("ok");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
