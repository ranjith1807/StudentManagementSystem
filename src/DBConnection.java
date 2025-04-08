import java.sql.*;

public class DBConnection {
    //private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "root"; //  Change this

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
