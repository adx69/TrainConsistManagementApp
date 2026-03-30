import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management Application
 *
 * This class initializes the train consist and displays
 * the initial state of the train.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    /**
     * Entry point of the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Initialize train consist using List interface and ArrayList
        List<String> bogies = new ArrayList<>();

        // Display initial bogie count
        System.out.println("Train initialized successfully.");
        System.out.println("Initial Bogie Count: " + bogies.size());

        // Program continues...
    }
}