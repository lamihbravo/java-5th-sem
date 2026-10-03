import javax.swing.*;
import java.awt.*;

public class swing2 {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Calculator");

        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JTextField n1 =
                new JTextField(10);

        JTextField n2 =
                new JTextField(10);

        JTextField result =
                new JTextField(15);

        JButton add =
                new JButton("+");

        JButton sub =
                new JButton("-");

        JButton mul =
                new JButton("*");

        JButton div =
                new JButton("/");

        frame.add(n1);
        frame.add(n2);

        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);

        frame.add(result);

        add.addActionListener(e ->
                calculate(n1, n2, result, '+'));

        sub.addActionListener(e ->
                calculate(n1, n2, result, '-'));

        mul.addActionListener(e ->
                calculate(n1, n2, result, '*'));

        div.addActionListener(e ->
                calculate(n1, n2, result, '/'));

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    static void calculate(
            JTextField n1,
            JTextField n2,
            JTextField result,
            char op) {

        try {

            double a =
                    Double.parseDouble(n1.getText());

            double b =
                    Double.parseDouble(n2.getText());

            if (op == '/' && b == 0) {

                result.setText(
                        "Cannot divide by zero");
                return;
            }

            double ans = 0;

            if (op == '+')
                ans = a + b;

            else if (op == '-')
                ans = a - b;

            else if (op == '*')
                ans = a * b;

            else if (op == '/')
                ans = a / b;

            result.setText(
                    String.valueOf(ans));

        } catch (NumberFormatException e) {

            result.setText("Invalid input");
        }
    }
}