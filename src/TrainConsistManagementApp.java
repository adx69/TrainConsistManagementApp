import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Train Consist Management Application
 *
 * Covers UC1–UC20:
 * Collections, Streams, Regex, Validation, Performance,
 * Exceptions, Sorting, Searching, Defensive Programming
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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
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
                return true;
            }
        }
        return false;
    }

    // ================= UC19 Binary Search =================
    static boolean binarySearch(String[] arr, String key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);

            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    // ================= UC20 Defensive Search =================
    static boolean safeSearch(String[] arr, String key) {
        if (arr.length == 0) {
            throw new IllegalStateException("Cannot perform search: Train has no bogies!");
        }
        return linearSearch(arr, key);
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
        int total = bogies.stream().mapToInt(b -> b.capacity).sum();

        System.out.println("\nSorted Bogies: " + bogies);
        System.out.println("Total Capacity: " + total);

        // ================= UC11 =================
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Train ID (TRN-1234): ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code (PET-AB): ");
        String cargoCode = sc.nextLine();

        System.out.println("Train ID Valid: " + trainId.matches("TRN-\\d{4}"));
        System.out.println("Cargo Code Valid: " + cargoCode.matches("PET-[A-Z]{2}"));

        // ================= UC15 =================
        System.out.println("\n=== Safe Cargo Assignment ===");
        assignCargo(new GoodsBogie("Box", "Coal"), "Petroleum");

        // ================= UC16 =================
        int[] capacities = {72, 60, 24, 90, 50};
        bubbleSort(capacities);

        // ================= UC17 =================
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class"};
        Arrays.sort(bogieNames);

        // ================= UC18 =================
        String[] bogieIds = {"B1", "B2", "B3"};
        System.out.print("\nEnter Bogie ID to search: ");
        String key = sc.nextLine();
        System.out.println(linearSearch(bogieIds, key) ? "Found" : "Not Found");

        // ================= UC19 =================
        Arrays.sort(bogieIds);
        System.out.println(binarySearch(bogieIds, key) ? "Found (Binary)" : "Not Found (Binary)");

        // ================= UC20 =================
        System.out.println("\n=== UC20: Defensive Search ===");

        String[] emptyTrain = {}; // simulate empty train

        try {
            boolean result = safeSearch(emptyTrain, "B1");
            System.out.println(result ? "Found" : "Not Found");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}