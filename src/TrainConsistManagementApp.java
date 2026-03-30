import java.util.LinkedList;
import java.util.Queue;

/**
 * Train Consist / Booking Management Application
 *
 * UC5: Handle booking requests using Queue (FIFO)
 * Demonstrates fair request handling.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Booking Request Queue System");
        System.out.println("======================================");

        // Create Queue for booking requests
        Queue<String> bookingQueue = new LinkedList<>();

        // Guest booking requests (arrival order)
        bookingQueue.add("Request 1 - Alice");
        bookingQueue.add("Request 2 - Bob");
        bookingQueue.add("Request 3 - Charlie");

        // Display queue
        System.out.println("\nBooking Requests in Queue:");
        System.out.println(bookingQueue);

        // Peek (next request to be processed)
        System.out.println("\nNext Request to Process: " + bookingQueue.peek());

        // No processing/removal yet (as per requirement)

        // Program continues...
    }
}