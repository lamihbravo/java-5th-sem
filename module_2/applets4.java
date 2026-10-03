import java.applet.Applet;
import java.awt.*;

public class applets4 extends Applet
        implements Runnable {

    int x = 0;
    Thread t;
    boolean running;

    public void init() {
        setBackground(Color.WHITE);
    }

    public void start() {

        running = true;

        t = new Thread(this);
        t.start();
    }

    public void run() {

        while (running) {

            x = x + 5;

            if (x > getWidth())
                x = 0;

            repaint();

            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    public void stop() {
        running = false;
    }

    public void paint(Graphics g) {
        g.fillOval(x, 100, 40, 40);
    }
}