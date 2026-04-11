import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 *
 * Covers UC1 to UC14:
 * - Collections (List, Set, Map, Queue)
 * - Streams (filter, sort, group, reduce)
 * - Regex validation
 * - Safety rules
 * - Performance comparison
 * - Custom exception handling
 *
 * @author Lakshmi M
 * @version 1.0
 */
public class TrainConsistManagementApp {

    // ================= UC14 =================
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ================= Bogie Class =================
    static class Bogie {
        String name;
        String type;
        int capacity;

        Bogie(String name, String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Invalid capacity for " + name);
            }
            this.name = name;
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + type + ", " + capacity + ")";
        }
    }

    // ================= Goods Bogie =================
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   Train Consist Management App");
        System.out.println("======================================");

        // ================= UC1 =================
        List<String> simpleBogies = new ArrayList<>();
        System.out.println("\nInitial Bogie Count: " + simpleBogies.size());

        // ================= UC2 =================
        simpleBogies.add("Sleeper");
        simpleBogies.add("AC Chair");
        simpleBogies.add("First Class");
        simpleBogies.remove("AC Chair");
        System.out.println("\nBogies after CRUD: " + simpleBogies);

        // ================= UC3 =================
        Set<String> uniqueIds = new HashSet<>();
        uniqueIds.add("B1");
        uniqueIds.add("B2");
        uniqueIds.add("B2"); // duplicate ignored
        System.out.println("\nUnique Bogie IDs: " + uniqueIds);

        // ================= UC4 =================
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");
        train.add(1, "Pantry");
        train.removeFirst();
        train.removeLast();
        System.out.println("\nTrain Consist: " + train);

        // ================= UC5 =================
        Queue<String> queue = new LinkedList<>();
        queue.add("Req1");
        queue.add("Req2");
        System.out.println("\nNext Booking: " + queue.peek());

        // ================= UC6 =================
        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 24);

        System.out.println("\nCapacity Map:");
        for (Map.Entry<String, Integer> e : capacityMap.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }

        // ================= UC7–UC10 + UC14 =================
        List<Bogie> bogies = new ArrayList<>();

        try {
            bogies.add(new Bogie("S1", "Sleeper", 72));
            bogies.add(new Bogie("AC1", "AC", 60));
            bogies.add(new Bogie("FC1", "First Class", 24));
            // bogies.add(new Bogie("Invalid", "Test", -10)); // test exception
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // UC7 Sorting
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        // UC8 Filtering
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        // UC9 Grouping
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        // UC10 Total Capacity
        int total = bogies.stream()
                .mapToInt(b -> b.capacity)
                .sum();

        System.out.println("\nSorted Bogies: " + bogies);
        System.out.println("\nFiltered Bogies (>50): " + filtered);
        System.out.println("\nGrouped Bogies: " + grouped);
        System.out.println("\nTotal Capacity: " + total);

        // ================= UC11 (Regex Validation) =================
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Train ID (TRN-1234): ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code (PET-AB): ");
        String cargoCode = sc.nextLine();

        boolean validTrain = trainId.matches("TRN-\\d{4}");
        boolean validCargo = cargoCode.matches("PET-[A-Z]{2}");

        System.out.println("Train ID Valid: " + validTrain);
        System.out.println("Cargo Code Valid: " + validCargo);

        // ================= UC12 (Safety Check) =================
        List<GoodsBogie> goods = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal")
        );

        boolean isSafe = goods.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nSafety Status: " + (isSafe ? "SAFE" : "NOT SAFE"));

        // ================= UC13 (Performance) =================
        List<Bogie> bigList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            try {
                bigList.add(new Bogie("B" + i, "Test", (i % 100) + 1));
            } catch (Exception ignored) {}
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bigList) {
            if (b.capacity > 60) loopResult.add(b);
        }
        long loopTime = System.nanoTime() - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamResult = bigList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startStream;

        System.out.println("\nLoop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");

        sc.close();
    }
}