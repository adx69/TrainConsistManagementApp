import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Train Consist Management Application
 *
 * UC7: Sort bogies based on capacity using Comparator
 * Demonstrates custom sorting with objects.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainApp {

    // Bogie class (custom object)
    static class Bogie {
        String name;
        int capacity;

        // Constructor
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        // toString for display
        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Display before sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // Display after sorting
        System.out.println("\nAfter Sorting (by Capacity):");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Program continues...
    }
}