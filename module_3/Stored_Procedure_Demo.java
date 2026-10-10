```java
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stored_Procedure_Demo {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, DB_USER, DB_PASS);
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS course_info (" +
                "student_id INT PRIMARY KEY, " +
                "student_name VARCHAR(50), " +
                "department VARCHAR(50))"
            );

            stmt.executeUpdate(
                "INSERT INTO course_info VALUES " +
                "(501, 'Akhil', 'BSc') " +
                "ON DUPLICATE KEY UPDATE " +
                "student_name = 'Akhil', department = 'BSc'"
            );

            stmt.executeUpdate(
                "DROP PROCEDURE IF EXISTS find_student"
            );

            stmt.executeUpdate(
                "CREATE PROCEDURE find_student(IN input_id INT) " +
                "SELECT student_id, student_name, department " +
                "FROM course_info WHERE student_id = input_id"
            );

            try (CallableStatement cs =
                     con.prepareCall("{call find_student(?)}")) {

                cs.setInt(1, 501);

                try (ResultSet rs = cs.executeQuery()) {
                    if (rs.next()) {
                        System.out.println(
                            "Student ID: " + rs.getInt("student_id")
                        );
                        System.out.println(
                            "Student name: " +
                            rs.getString("student_name")
                        );
                        System.out.println(
                            "Department: " +
                            rs.getString("department")
                        );
                    } else {
                        System.out.println(
                            "No matching student record available."
                        );
                    }
                }
            }

        } catch (SQLException ex) {
            System.out.println(
                "Error executing stored procedure: " +
                ex.getMessage()
            );
        }
    }
}
```