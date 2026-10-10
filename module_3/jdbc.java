
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc1 {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "javauser";
    private static final String PASSWORD = "javauser";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to MySQL database successfully.");
            
        } catch (SQLException exception) {
            System.out.println("Could not connect to the database: " + exception.getMessage());
        }
    }
}