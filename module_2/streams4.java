import java.io.*;

public class streams4 {

    public static void main(String[] args) {

        try {

            BufferedInputStream in =
                    new BufferedInputStream(
                            new FileInputStream("input.txt"));

            BufferedOutputStream out =
                    new BufferedOutputStream(
                            new FileOutputStream("copy.txt"));

            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

            in.close();
            out.close();

            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}