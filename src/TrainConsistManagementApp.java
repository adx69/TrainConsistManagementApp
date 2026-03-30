import java.util.LinkedList;

/**
 * Train Consist Management Application
 *
 * UC4: Maintain ordered bogie consist using LinkedList
 * Demonstrates insertion, deletion, and order preservation.
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

        // Create LinkedList for train consist
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2 (index 1)
        train.add(1, "Pantry Car");

        System.out.println("\nAfter adding Pantry Car:");
        System.out.println(train);

        // Remove first and last bogie
        train.removeFirst(); // removes Engine
        train.removeLast();  // removes Guard

        // Final consist
        System.out.println("\nFinal Train Consist:");
        System.out.println(train);

        // Program continues...
    }
}