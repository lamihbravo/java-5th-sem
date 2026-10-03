import java.awt.*;
import java.awt.event.*;

public class awt2 extends Frame
        implements ActionListener {

    TextField n1, n2, result;
    Button add, sub, mul, div;

    Calculator() {

        setTitle("Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());

        n1 = new TextField(10);
        n2 = new TextField(10);
        result = new TextField(10);

        add(n1);
        add(n2);

        add = new Button("+");
        sub = new Button("-");
        mul = new Button("*");
        div = new Button("/");

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            double a = Double.parseDouble(n1.getText());
            double b = Double.parseDouble(n2.getText());

            double ans = 0;

            if (e.getSource() == add)
                ans = a + b;

            else if (e.getSource() == sub)
                ans = a - b;

            else if (e.getSource() == mul)
                ans = a * b;

            else if (e.getSource() == div) {

                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }

                ans = a / b;
            }

            result.setText(String.valueOf(ans));

        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}