import java.io.*;

public class streams3 {

    public static void main(String[] args) {

        try {

            DataOutputStream out =
                    new DataOutputStream(
                            new FileOutputStream("student.dat"));

            out.writeInt(101);
            out.writeUTF("Rahul");
            out.writeDouble(85.5);

            out.close();

            DataInputStream in =
                    new DataInputStream(
                            new FileInputStream("student.dat"));

            int roll = in.readInt();
            String name = in.readUTF();
            double marks = in.readDouble();

            System.out.println("Roll No: " + roll);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);

            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}