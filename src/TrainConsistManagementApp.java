import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 *
 * UC8: Filter passenger bogies using Stream API
 * Demonstrates declarative filtering based on capacity.
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

        // Create bogie list (reuse from UC7)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Display all bogies
        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        // Stream filtering (capacity > 60)
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Display filtered bogies
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // Program continues...
    }
}