import javax.swing.*;
import java.awt.*;

public class swing3 {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Student Mark List");

        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        JTextField name =
                new JTextField(15);

        JTextField regno =
                new JTextField(15);

        JTextField m1 =
                new JTextField(10);

        JTextField m2 =
                new JTextField(10);

        JTextField m3 =
                new JTextField(10);

        JButton calculate =
                new JButton("Calculate");

        JButton clear =
                new JButton("Clear");

        JButton exit =
                new JButton("Exit");

        JTextArea result =
                new JTextArea(8, 30);

        frame.add(new JLabel("Name"));
        frame.add(name);

        frame.add(new JLabel("Register No"));
        frame.add(regno);

        frame.add(new JLabel("Mark 1"));
        frame.add(m1);

        frame.add(new JLabel("Mark 2"));
        frame.add(m2);

        frame.add(new JLabel("Mark 3"));
        frame.add(m3);

        frame.add(calculate);
        frame.add(clear);
        frame.add(exit);

        frame.add(result);

        calculate.addActionListener(e -> {

            try {

                int a = Integer.parseInt(m1.getText());
                int b = Integer.parseInt(m2.getText());
                int c = Integer.parseInt(m3.getText());

                if (a < 0 || a > 100 ||
                    b < 0 || b > 100 ||
                    c < 0 || c > 100) {

                    result.setText(
                            "Marks must be 0-100");
                    return;
                }

                int total = a + b + c;
                double average = total / 3.0;

                String grade;

                if (average >= 90)
                    grade = "A+";
                else if (average >= 80)
                    grade = "A";
                else if (average >= 70)
                    grade = "B";
                else if (average >= 60)
                    grade = "C";
                else
                    grade = "D";

                result.setText(
                    "Name: " + name.getText() +
                    "\nTotal: " + total +
                    "\nAverage: " + average +
                    "\nGrade: " + grade);

            } catch (NumberFormatException ex) {

                result.setText(
                        "Enter valid marks");
            }
        });

        clear.addActionListener(e -> {

            name.setText("");
            regno.setText("");
            m1.setText("");
            m2.setText("");
            m3.setText("");
            result.setText("");
        });

        exit.addActionListener(e ->
                System.exit(0));

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}