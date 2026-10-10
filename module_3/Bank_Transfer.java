```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bank_Transfer {
    private static final String URL =
        "jdbc:mysql://localhost:3306/student_db";
    private static final String DB_USER = "jdbcuser";
    private static final String DB_PASS = "jdbcuser";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                 URL, DB_USER, DB_PASS);
             Scanner sc = new Scanner(System.in);
             Statement stmt = con.createStatement()) {

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS bank_accounts " +
                "(account_no INT PRIMARY KEY, " +
                "holder_name VARCHAR(50), " +
                "balance DECIMAL(10, 2) NOT NULL)"
            );

            stmt.executeUpdate(
                "INSERT INTO bank_accounts VALUES " +
                "(2001, 'Rahul', 8000.00), " +
                "(2002, 'Neha', 4500.00) " +
                "ON DUPLICATE KEY UPDATE " +
                "account_no = VALUES(account_no)"
            );

            System.out.print("Enter debit account number: ");
            int fromAccount = Integer.parseInt(sc.nextLine());

            System.out.print("Enter credit account number: ");
            int toAccount = Integer.parseInt(sc.nextLine());

            System.out.print("Enter transfer amount: ");
            double transferAmount =
                Double.parseDouble(sc.nextLine());

            if (transferAmount <= 0) {
                System.out.println(
                    "Please enter a valid positive amount."
                );
                return;
            }

            con.setAutoCommit(false);

            try {
                if (getBalance(con, fromAccount) < transferAmount) {
                    throw new SQLException(
                        "Insufficient funds in the sender account."
                    );
                }

                try (PreparedStatement debitStmt =
                         con.prepareStatement(
                             "UPDATE bank_accounts " +
                             "SET balance = balance - ? " +
                             "WHERE account_no = ?");
                     PreparedStatement creditStmt =
                         con.prepareStatement(
                             "UPDATE bank_accounts " +
                             "SET balance = balance + ? " +
                             "WHERE account_no = ?")) {

                    debitStmt.setDouble(1, transferAmount);
                    debitStmt.setInt(2, fromAccount);

                    if (debitStmt.executeUpdate() != 1) {
                        throw new SQLException(
                            "Debit account does not exist."
                        );
                    }

                    creditStmt.setDouble(1, transferAmount);
                    creditStmt.setInt(2, toAccount);

                    if (creditStmt.executeUpdate() != 1) {
                        throw new SQLException(
                            "Credit account does not exist."
                        );
                    }
                }

                con.commit();
                System.out.println(
                    "Money transfer completed successfully. " +
                    "Transaction committed."
                );

            } catch (SQLException ex) {
                con.rollback();
                System.out.println(
                    "Transaction unsuccessful. All changes " +
                    "have been rolled back: " + ex.getMessage()
                );

            } finally {
                con.setAutoCommit(true);
            }

        } catch (NumberFormatException ex) {
            System.out.println(
                "Please enter numeric account numbers and amount."
            );

        } catch (SQLException ex) {
            System.out.println(
                "Unable to perform database operation: " +
                ex.getMessage()
            );
        }
    }

    private static double getBalance(
            Connection con, int accountNumber)
            throws SQLException {

        try (PreparedStatement ps = con.prepareStatement(
                 "SELECT balance FROM bank_accounts " +
                 "WHERE account_no = ?")) {

            ps.setInt(1, accountNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                }

                throw new SQLException(
                    "Sender account was not found."
                );
            }
        }
    }
}
```