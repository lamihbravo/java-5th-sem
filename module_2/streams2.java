import java.io.*;
import java.util.*;

public class streams2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        try {

            FileOutputStream fout =
                    new FileOutputStream("output.txt", true);

            fout.write(text.getBytes());

            fout.write('\n');

            fout.close();

            System.out.println("Data written successfully");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}