import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management Application
 *
 * UC10: Calculate total seating capacity using Stream reduce()
 * Demonstrates aggregation of numeric data.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Calculate total capacity using stream
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)          // extract capacities
                .reduce(0, Integer::sum);     // sum all values

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);

        // Program continues...
    }
}