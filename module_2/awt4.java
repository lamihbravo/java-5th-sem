import java.awt.*;
import java.awt.event.*;

public class awt4 extends Frame {

    Label label;

    EventDemo() {

        setTitle("Mouse Keyboard Demo");
        setSize(500, 300);
        setLayout(new FlowLayout());

        label = new Label("Perform an action");
        add(label);

        addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                label.setText(
                    "Mouse Clicked: X=" +
                    e.getX() +
                    " Y=" +
                    e.getY());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {

                label.setText(
                    "Mouse: X=" +
                    e.getX() +
                    " Y=" +
                    e.getY());
            }
        });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                label.setText(
                    "Key Pressed: " +
                    e.getKeyChar());
            }
        });

        setFocusable(true);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new EventDemo();
    }
}