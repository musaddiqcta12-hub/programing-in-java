class TicketBooking {
    String passengerName;
    String bookingStatus;

    TicketBooking(String name) {
        this.passengerName = name;
        this.bookingStatus = "Confirmed";
    }

    void display(String threadName, long threadId) {
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Booking Status : " + bookingStatus);
        System.out.println("Thread Name    : " + threadName);
        System.out.println("Thread ID      : " + threadId);
        System.out.println("----------------------------------------");
    }
}

class BookingThread extends Thread {
    TicketBooking booking;

    BookingThread(String passengerName) {
        this.booking = new TicketBooking(passengerName);
    }

    @Override
    public void run() {
        booking.display(Thread.currentThread().getName(), Thread.currentThread().getId());
    }
}

class BookingRunnable implements Runnable {
    TicketBooking booking;

    BookingRunnable(String passengerName) {
        this.booking = new TicketBooking(passengerName);
    }

    @Override
    public void run() {
        booking.display(Thread.currentThread().getName(), Thread.currentThread().getId());
    }
}

public class RailwayReservation {
    public static void main(String[] args) {
        BookingThread t1 = new BookingThread("Rahul");

        BookingRunnable runnable = new BookingRunnable("Priya");
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All passenger booking requests have been processed successfully.");
    }
}
