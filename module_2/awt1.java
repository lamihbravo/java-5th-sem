import java.awt.*;
import java.awt.event.*;

public class awt1 extends Frame {

    TextField name, regno;
    Choice course;
    Checkbox male, female;
    Button submit, clear;
    Label result;

    StudentForm() {

        setTitle("Student Registration");
        setSize(400, 400);
        setLayout(new FlowLayout());

        add(new Label("Name:"));
        name = new TextField(20);
        add(name);

        add(new Label("Register No:"));
        regno = new TextField(20);
        add(regno);

        add(new Label("Course:"));

        course = new Choice();
        course.add("BSc Computer Science");
        course.add("BCA");
        course.add("BCom");

        add(course);

        add(new Label("Gender:"));

        male = new Checkbox("Male");
        female = new Checkbox("Female");

        add(male);
        add(female);

        submit = new Button("Submit");
        clear = new Button("Clear");

        add(submit);
        add(clear);

        result = new Label();
        add(result);

        submit.addActionListener(e -> {

            result.setText(
                "Name: " + name.getText() +
                " Reg: " + regno.getText());
        });

        clear.addActionListener(e -> {

            name.setText("");
            regno.setText("");
            result.setText("");
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}