```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_MetaData {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, DB_USER, DB_PASS);
             Statement setupStmt = con.createStatement()) {

            setupStmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS course_info " +
                "(student_id INT PRIMARY KEY, " +
                "student_name VARCHAR(50), " +
                "department VARCHAR(50))"
            );

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                     "SELECT * FROM course_info")) {

                ResultSetMetaData rsMeta = rs.getMetaData();
                int count = rsMeta.getColumnCount();

                System.out.println("Total number of columns: " + count);

                for (int i = 1; i <= count; i++) {
                    System.out.println("Column details " + i + ":");

                    System.out.println(
                        "  Column name: " + rsMeta.getColumnName(i)
                    );

                    System.out.println(
                        "  Data type: " + rsMeta.getColumnTypeName(i)
                    );

                    System.out.println(
                        "  Allows NULL: " +
                        (rsMeta.isNullable(i) ==
                         ResultSetMetaData.columnNullable
                         ? "Yes" : "No")
                    );

                    System.out.println(
                        "  Maximum display size: " +
                        rsMeta.getColumnDisplaySize(i)
                    );
                }
            }

        } catch (SQLException ex) {
            System.out.println(
                "Unable to retrieve column information: " +
                ex.getMessage()
            );
        }
    }
}
```