```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_Navigation {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    private static void display(ResultSet rs) throws SQLException {
        System.out.println(
            rs.getInt("student_id") + "  " +
            rs.getString("student_name") + "  " +
            rs.getString("department")
        );
    }

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, DB_USER, DB_PASS);
             Statement setupStmt = con.createStatement()) {

            setupStmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS course_info (" +
                "student_id INT PRIMARY KEY, " +
                "student_name VARCHAR(50), " +
                "department VARCHAR(50))"
            );

            setupStmt.executeUpdate(
                "INSERT INTO course_info VALUES " +
                "(401, 'Rahul', 'BCA'), " +
                "(402, 'Anjali', 'BSc'), " +
                "(403, 'Kiran', 'BCom') " +
                "ON DUPLICATE KEY UPDATE " +
                "student_name = VALUES(student_name), " +
                "department = VALUES(department)"
            );

            try (Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                 ResultSet rs = stmt.executeQuery(
                    "SELECT student_id, student_name, department " +
                    "FROM course_info ORDER BY student_id")) {

                System.out.println("Using first():");
                if (rs.first()) {
                    display(rs);
                }

                System.out.println("Using next():");
                if (rs.next()) {
                    display(rs);
                }

                System.out.println("Using previous():");
                if (rs.previous()) {
                    display(rs);
                }

                System.out.println("Using last():");
                if (rs.last()) {
                    display(rs);
                }

                System.out.println("Using absolute(2):");
                if (rs.absolute(2)) {
                    display(rs);
                }
            }

        } catch (SQLException ex) {
            System.out.println(
                "ResultSet navigation failed: " + ex.getMessage()
            );
        }
    }
}
```