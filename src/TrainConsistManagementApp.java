import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 *
 * Covers UC1–UC18:
 * Collections, Streams, Regex, Validation, Performance,
 * Exceptions, Sorting, Searching
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

    // ================= UC15 =================
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
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

    // ================= UC15 Method =================
    static void assignCargo(GoodsBogie bogie, String cargo) {
        try {
            System.out.println("\nAssigning " + cargo + " to " + bogie.type);

            if (bogie.type.equals("Box") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe: Box cannot carry Petroleum");
            }

            bogie.cargo = cargo;
            System.out.println("Cargo assigned successfully ✅");

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Assignment attempt completed.");
        }
    }

    // ================= UC16 Bubble Sort =================
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ================= UC18 Linear Search =================
    static boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true; // found
            }
        }
        return false; // not found
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
        System.out.println("Bogies after CRUD: " + simpleBogies);

        // ================= UC3 =================
        Set<String> uniqueIds = new HashSet<>();
        uniqueIds.add("B1");
        uniqueIds.add("B2");
        uniqueIds.add("B2");
        System.out.println("\nUnique IDs: " + uniqueIds);

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
        capacityMap.forEach((k, v) -> System.out.println(k + " → " + v));

        // ================= UC7–UC10 =================
        List<Bogie> bogies = new ArrayList<>();

        try {
            bogies.add(new Bogie("S1", "Sleeper", 72));
            bogies.add(new Bogie("AC1", "AC", 60));
            bogies.add(new Bogie("FC1", "First Class", 24));
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.type));

        int total = bogies.stream().mapToInt(b -> b.capacity).sum();

        System.out.println("\nSorted: " + bogies);
        System.out.println("Filtered (>50): " + filtered);
        System.out.println("Grouped: " + grouped);
        System.out.println("Total Capacity: " + total);

        // ================= UC11 =================
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Train ID (TRN-1234): ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code (PET-AB): ");
        String cargoCode = sc.nextLine();

        System.out.println("Train ID Valid: " + trainId.matches("TRN-\\d{4}"));
        System.out.println("Cargo Code Valid: " + cargoCode.matches("PET-[A-Z]{2}"));

        // ================= UC12 =================
        List<GoodsBogie> goods = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal")
        );

        boolean isSafe = goods.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nSafety Status: " + (isSafe ? "SAFE" : "NOT SAFE"));

        // ================= UC13 =================
        List<Bogie> bigList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            try {
                bigList.add(new Bogie("B" + i, "Test", (i % 100) + 1));
            } catch (Exception ignored) {}
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopRes = new ArrayList<>();
        for (Bogie b : bigList) {
            if (b.capacity > 60) loopRes.add(b);
        }
        long loopTime = System.nanoTime() - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamRes = bigList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long streamTime = System.nanoTime() - startStream;

        System.out.println("\nLoop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");

        // ================= UC15 =================
        System.out.println("\n=== Safe Cargo Assignment ===");

        GoodsBogie g1 = new GoodsBogie("Box", "Coal");
        GoodsBogie g2 = new GoodsBogie("Cylindrical", "Petroleum");

        assignCargo(g2, "Petroleum");
        assignCargo(g1, "Petroleum");

        System.out.println("\nProgram continues safely ✅");

        // ================= UC16 =================
        System.out.println("\n=== UC16: Bubble Sort ===");

        int[] capacities = {72, 60, 24, 90, 50};

        System.out.println("Before Sorting: " + Arrays.toString(capacities));
        bubbleSort(capacities);
        System.out.println("After Sorting:  " + Arrays.toString(capacities));

        // ================= UC17 =================
        System.out.println("\n=== UC17: Arrays.sort ===");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Pantry"};

        System.out.println("Before Sorting: " + Arrays.toString(bogieNames));
        Arrays.sort(bogieNames);
        System.out.println("After Sorting:  " + Arrays.toString(bogieNames));

        // ================= UC18 =================
        System.out.println("\n=== UC18: Linear Search ===");

        String[] bogieIds = {"B1", "B2", "B3", "B4", "B5"};

        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID FOUND ✅");
        } else {
            System.out.println("Bogie ID NOT FOUND ❌");
        }

        sc.close();
    }
}