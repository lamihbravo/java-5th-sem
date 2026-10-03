import java.applet.Applet;
import java.awt.*;

public class applets5 extends Applet {

    String message;

    public void init() {

        message = getParameter("message");

        String bg = getParameter("background");
        String fg = getParameter("foreground");

        if (bg.equals("red"))
            setBackground(Color.RED);

        if (bg.equals("blue"))
            setBackground(Color.BLUE);

        if (fg.equals("white"))
            setForeground(Color.WHITE);

        if (fg.equals("black"))
            setForeground(Color.BLACK);
    }

    public void paint(Graphics g) {
        g.drawString(message, 50, 50);
    }
}