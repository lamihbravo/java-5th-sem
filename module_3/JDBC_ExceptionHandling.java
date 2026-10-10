```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_ExceptionHandling {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    public static void main(String[] args) {
        Connection con;

        try {
            con = DriverManager.getConnection(URL, DB_USER, DB_PASS);
        } catch (SQLException ex) {
            System.out.println(
                "Unable to connect: verify the database server and login details."
            );
            System.out.println(ex.getMessage());
            return;
        }

        try (Connection dbCon = con;
             Scanner sc = new Scanner(System.in)) {

            try (Statement stmt = dbCon.createStatement()) {
                stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS student_records " +
                    "(student_id INT PRIMARY KEY, " +
                    "student_name VARCHAR(50) NOT NULL)"
                );
            }

            System.out.print("Enter student ID: ");
            int id;

            try {
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(
                    "Invalid entry: please enter a numeric student ID."
                );
                return;
            }

            System.out.print("Enter student name: ");
            String studentName = sc.nextLine();

            try (PreparedStatement ps = dbCon.prepareStatement(
                    "INSERT INTO student_records " +
                    "(student_id, student_name) VALUES (?, ?)")) {

                ps.setInt(1, id);
                ps.setString(2, studentName);
                ps.executeUpdate();

                System.out.println("Student record saved successfully.");

            } catch (SQLIntegrityConstraintViolationException ex) {
                System.out.println(
                    "Record already exists: use a different student ID."
                );
            }

            try (Statement stmt = dbCon.createStatement()) {
                stmt.executeQuery(
                    "SELEC * FROM student_records"
                );
            } catch (SQLException ex) {
                System.out.println(
                    "SQL query execution failed: " + ex.getMessage()
                );
            }

        } catch (SQLException ex) {
            System.out.println(
                "A database operation failed: " + ex.getMessage()
            );
        }
    }
}
```