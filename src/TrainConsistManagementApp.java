import java.util.HashMap;
import java.util.Map;

/**
 * Train Consist Management Application
 *
 * UC6: Map bogies to their seating/load capacity using HashMap
 * Demonstrates key–value data modeling.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Create HashMap for bogie-capacity mapping
        Map<String, Integer> bogieCapacity = new HashMap<>();

        // Insert bogie capacities
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 60);
        bogieCapacity.put("First Class", 24);

        // Display mapping
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
        }

        // Program continues...
    }
}