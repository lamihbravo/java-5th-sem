```java
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_Metadata_Demo {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    public static void main(String[] args) {
        try (Connection con =
                 DriverManager.getConnection(URL, DB_USER, DB_PASS);
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS course_details " +
                "(student_id INT PRIMARY KEY, " +
                "student_name VARCHAR(50), " +
                "department VARCHAR(50))"
            );

            DatabaseMetaData dbInfo = con.getMetaData();

            System.out.println(
                "Database name: " + dbInfo.getDatabaseProductName()
            );
            System.out.println(
                "Version of database: " +
                dbInfo.getDatabaseProductVersion()
            );
            System.out.println(
                "JDBC driver name: " + dbInfo.getDriverName()
            );
            System.out.println(
                "JDBC driver version: " + dbInfo.getDriverVersion()
            );
            System.out.println(
                "Transaction support: " +
                dbInfo.supportsTransactions()
            );
            System.out.println(
                "Batch processing support: " +
                dbInfo.supportsBatchUpdates()
            );

            System.out.println("Available tables in database:");

            try (ResultSet tableList = dbInfo.getTables(
                    con.getCatalog(), null, "%",
                    new String[]{"TABLE"})) {

                while (tableList.next()) {
                    System.out.println(
                        " * " + tableList.getString("TABLE_NAME")
                    );
                }
            }

        } catch (SQLException ex) {
            System.out.println(
                "Error retrieving database details: " +
                ex.getMessage()
            );
        }
    }
}
```