import java.awt.*;
import java.awt.event.*;

public class awt3 extends Frame
        implements ActionListener {

    Button red, green, blue;

    ColorApp() {

        setTitle("Color Selection");
        setSize(400, 300);
        setLayout(new FlowLayout());

        red = new Button("Red");
        green = new Button("Green");
        blue = new Button("Blue");

        add(red);
        add(green);
        add(blue);

        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == red)
            setBackground(Color.RED);

        else if (e.getSource() == green)
            setBackground(Color.GREEN);

        else if (e.getSource() == blue)
            setBackground(Color.BLUE);
    }

    public static void main(String[] args) {
        new ColorApp();
    }
}