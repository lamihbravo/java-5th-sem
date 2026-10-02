class LifeCycle extends Thread {

    public void run() {
        System.out.println("Thread is Running");

        try {
            System.out.println("Thread is going to sleep...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread completed");
    }

    public static void main(String[] args) throws Exception {

        LifeCycle t = new LifeCycle();

        System.out.println("Thread created - New State");

        t.start();

        System.out.println("Thread started - Runnable/Running State");

        t.join();

        System.out.println("Thread Terminated");
    }
}