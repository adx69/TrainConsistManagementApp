import java.util.*;
import java.util.stream.*;

/**
 * Train Consist Management Application
 *
 * UC13: Compare performance of loops vs streams
 * Demonstrates benchmarking using System.nanoTime()
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // Create large dataset for meaningful comparison
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            bogies.add(new Bogie("B" + i, (i % 100) + 20));
        }

        // ===== LOOP-BASED FILTERING =====
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ===== STREAM-BASED FILTERING =====
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ===== RESULTS =====
        System.out.println("\nLoop Filtering Time: " + loopTime + " ns");
        System.out.println("Stream Filtering Time: " + streamTime + " ns");

        // Optional comparison
        if (loopTime < streamTime) {
            System.out.println("\nLoop is faster in this run ⚡");
        } else {
            System.out.println("\nStream is faster in this run ⚡");
        }

        // Program continues...
    }
}