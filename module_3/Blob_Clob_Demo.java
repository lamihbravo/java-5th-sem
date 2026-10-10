```java
import java.io.*;
import java.sql.*;

public class Blob_Clob_Demo {
    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db",
            "jdbcuser", "jdbcuser"
        );

        Statement stmt = con.createStatement();

        stmt.executeUpdate(
            "CREATE TABLE IF NOT EXISTS media_files (" +
            "file_id INT PRIMARY KEY, " +
            "photo_data LONGBLOB, " +
            "report_text LONGTEXT)"
        );

        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO media_files VALUES (2, ?, ?) " +
            "ON DUPLICATE KEY UPDATE " +
            "photo_data=?, report_text=?"
        );

        FileInputStream photo = new FileInputStream("image.jpg");
        FileReader document = new FileReader("document.txt");

        pstmt.setBinaryStream(1, photo);
        pstmt.setCharacterStream(2, document);
        pstmt.setBinaryStream(3, new FileInputStream("image.jpg"));
        pstmt.setCharacterStream(4, new FileReader("document.txt"));

        pstmt.executeUpdate();

        photo.close();
        document.close();

        ResultSet result = stmt.executeQuery(
            "SELECT photo_data, report_text " +
            "FROM media_files WHERE file_id=2"
        );

        if (result.next()) {

            FileOutputStream savedPhoto =
                new FileOutputStream("retrieved.jpg");

            InputStream photoInput =
                result.getBinaryStream("photo_data");

            photoInput.transferTo(savedPhoto);

            savedPhoto.close();
            photoInput.close();

            FileWriter savedDocument =
                new FileWriter("retrieved.txt");

            Reader documentInput =
                result.getCharacterStream("report_text");

            documentInput.transferTo(savedDocument);

            savedDocument.close();
            documentInput.close();

            System.out.println(
                "Photo and text document retrieved successfully."
            );
        }

        result.close();
        pstmt.close();
        stmt.close();
        con.close();
    }
}
```