class Numbers extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println("Number: " + i);
    }
}

class Characters extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'E'; c++)
            System.out.println("Character: " + c);
    }
}

class Message extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println("Hello from Thread");
    }
}

public class Threads {
    public static void main(String[] args) {

        Numbers t1 = new Numbers();
        Characters t2 = new Characters();
        Message t3 = new Message();

        t1.start();
        t2.start();
        t3.start();
    }
}