import java.applet.Applet;
import java.awt.Graphics;

public class applets2 extends Applet {

    String name, regno, course, semester;

    public void init() {

        name = getParameter("name");
        regno = getParameter("regno");
        course = getParameter("course");
        semester = getParameter("semester");
    }

    public void paint(Graphics g) {

        g.drawString("Student Name: " + name, 50, 50);
        g.drawString("Register No: " + regno, 50, 80);
        g.drawString("Course: " + course, 50, 110);
        g.drawString("Semester: " + semester, 50, 140);
    }
}