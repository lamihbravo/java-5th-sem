class TicketBooking {

    int tickets = 5;

    synchronized void bookTicket(String name, int count) {

        if (tickets >= count) {

            System.out.println(name +
                    " booked " + count + " tickets.");

            tickets = tickets - count;

            System.out.println(
                    "Remaining tickets: " + tickets);

        } else {

            System.out.println(name +
                    " - Not enough tickets.");
        }
    }
}

class Customer extends Thread {

    TicketBooking booking;
    int count;

    Customer(TicketBooking booking, int count) {
        this.booking = booking;
        this.count = count;
    }

    public void run() {
        booking.bookTicket(
                Thread.currentThread().getName(), count);
    }
}

public class Threads5 {

    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        Customer c1 = new Customer(booking, 2);
        Customer c2 = new Customer(booking, 2);
        Customer c3 = new Customer(booking, 2);

        c1.setName("Alice");
        c2.setName("Bob");
        c3.setName("John");

        c1.start();
        c2.start();
        c3.start();
    }
}