```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, DB_USER, DB_PASS)) {

            System.out.println(
                "MySQL database connection established successfully."
            );

        } catch (SQLException ex) {
            System.out.println(
                "Database connection failed: " + ex.getMessage()
            );
        }
    }
}
```