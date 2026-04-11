import java.util.*;
import java.util.stream.*;

/**
 * Train Consist Management Application
 *
 * UC12: Safety compliance check using Streams and allMatch()
 * Demonstrates rule-based validation using lambda expressions.
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    // Passenger Bogie (existing)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Goods Bogie (new for UC12)
    static class GoodsBogie {
        String type;   // Cylindrical / Box
        String cargo;  // Petroleum / Coal / etc.

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        // Welcome message
        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // ===== UC10 (existing) =====
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity: " + totalCapacity);

        // ===== UC12 START =====

        // Create goods bogies
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Box", "Coal"));
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Safety validation using allMatch()
        boolean isSafe = goods.stream()
                .allMatch(b ->
                        // Rule: If cylindrical → must carry petroleum
                        !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum")
                );

        // Display result
        System.out.println("\nSafety Compliance Status: " +
                (isSafe ? "SAFE ✅" : "NOT SAFE ❌"));

        // ===== UC12 END =====
    }
}