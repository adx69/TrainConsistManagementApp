import java.util.*;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 *
 * UC9: Group bogies by type using Stream API
 * Demonstrates data aggregation and grouping.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    // Bogie class with type
    static class Bogie {
        String name;
        String type;
        int capacity;

        Bogie(String name, String type, int capacity) {
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + ")";
        }
    }

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("S1", "Sleeper", 72));
        bogies.add(new Bogie("S2", "Sleeper", 72));
        bogies.add(new Bogie("AC1", "AC", 60));
        bogies.add(new Bogie("AC2", "AC", 60));
        bogies.add(new Bogie("FC1", "First Class", 24));

        // Group bogies by type
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // Display grouped result
        System.out.println("\nGrouped Bogies by Type:");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
        }

        // Program continues...
    }
}