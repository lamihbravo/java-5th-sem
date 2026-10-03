import java.awt.*;
import java.awt.event.*;

public class awt5 extends Frame {

    TextField name, mark1, mark2, mark3;
    Button calculate;
    Label result;

    StudentPerformance() {

        setTitle("Student Performance");
        setSize(400, 400);
        setLayout(new FlowLayout());

        add(new Label("Name:"));
        name = new TextField(20);
        add(name);

        add(new Label("Mark 1:"));
        mark1 = new TextField(10);
        add(mark1);

        add(new Label("Mark 2:"));
        mark2 = new TextField(10);
        add(mark2);

        add(new Label("Mark 3:"));
        mark3 = new TextField(10);
        add(mark3);

        calculate = new Button("Calculate");
        add(calculate);

        result = new Label();
        add(result);

        calculate.addActionListener(e -> {

            try {

                int m1 = Integer.parseInt(mark1.getText());
                int m2 = Integer.parseInt(mark2.getText());
                int m3 = Integer.parseInt(mark3.getText());

                int total = m1 + m2 + m3;

                double average = total / 3.0;

                result.setText(
                    "Total = " + total +
                    " Average = " + average);

            } catch (NumberFormatException ex) {

                result.setText("Enter valid marks");
            }
        });

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentPerformance();
    }
}