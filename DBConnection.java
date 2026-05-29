import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection getConnection() {

        try {

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hotel_db",
                    "root",
                    "root");

            System.out.println("Database Connected");

        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }
}