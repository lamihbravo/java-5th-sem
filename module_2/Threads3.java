class Task1 implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++)
            System.out.println("Task 1: " + i);
    }
}

class Task2 implements Runnable {

    public void run() {
        for (char c = 'A'; c <= 'E'; c++)
            System.out.println("Task 2: " + c);
    }
}

public class Threads3{
    public static void main(String[] args) {

        Task1 obj1 = new Task1();
        Task2 obj2 = new Task2();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}