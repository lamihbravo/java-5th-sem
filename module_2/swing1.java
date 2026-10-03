import javax.swing.*;
import java.awt.*;

public class swing1 {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration");

        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField name = new JTextField(15);

        JLabel regLabel = new JLabel("Register No:");
        JTextField regno = new JTextField(15);

        JRadioButton male =
                new JRadioButton("Male");

        JRadioButton female =
                new JRadioButton("Female");

        ButtonGroup gender = new ButtonGroup();

        gender.add(male);
        gender.add(female);

        JComboBox<String> course =
                new JComboBox<>();

        course.addItem("BSc Computer Science");
        course.addItem("BCA");
        course.addItem("BCom");

        JCheckBox coding =
                new JCheckBox("Coding");

        JCheckBox gaming =
                new JCheckBox("Gaming");

        JButton submit =
                new JButton("Submit");

        JButton clear =
                new JButton("Clear");

        JTextArea result =
                new JTextArea(5, 30);

        frame.add(nameLabel);
        frame.add(name);

        frame.add(regLabel);
        frame.add(regno);

        frame.add(male);
        frame.add(female);

        frame.add(course);

        frame.add(coding);
        frame.add(gaming);

        frame.add(submit);
        frame.add(clear);

        frame.add(result);

        submit.addActionListener(e -> {

            result.setText(
                "Name: " + name.getText() +
                "\nRegister No: " + regno.getText() +
                "\nCourse: " + course.getSelectedItem());
        });

        clear.addActionListener(e -> {

            name.setText("");
            regno.setText("");
            result.setText("");
            gender.clearSelection();
        });

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}