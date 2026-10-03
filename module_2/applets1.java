import java.applet.Applet;
import java.awt.Graphics;

public class applets1 extends Applet {

    public void init() {
        System.out.println("init() called");
    }

    public void start() {
        System.out.println("start() called");
    }

    public void paint(Graphics g) {
        g.drawString("paint() called", 50, 50);
    }

    public void stop() {
        System.out.println("stop() called");
    }

    public void destroy() {
        System.out.println("destroy() called");
    }
}