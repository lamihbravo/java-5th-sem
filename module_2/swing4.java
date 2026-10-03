import javax.swing.*;
import java.awt.*;

public class swing4 {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("Login");

        frame.setSize(350, 250);
        frame.setLayout(new FlowLayout());

        JLabel userLabel =
                new JLabel("Username:");

        JTextField username =
                new JTextField(15);

        JLabel passLabel =
                new JLabel("Password:");

        JPasswordField password =
                new JPasswordField(15);

        JButton login =
                new JButton("Login");

        JButton reset =
                new JButton("Reset");

        JButton exit =
                new JButton("Exit");

        frame.add(userLabel);
        frame.add(username);

        frame.add(passLabel);
        frame.add(password);

        frame.add(login);
        frame.add(reset);
        frame.add(exit);

        login.addActionListener(e -> {

            String user = username.getText();

            String pass =
                    new String(password.getPassword());

            if (user.equals("admin") &&
                pass.equals("1234")) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Login Successful");

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Username or Password");
            }
        });

        reset.addActionListener(e -> {

            username.setText("");
            password.setText("");
        });

        exit.addActionListener(e ->
                System.exit(0));

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}