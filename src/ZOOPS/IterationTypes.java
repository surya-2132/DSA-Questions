package ZOOPS;

import java.util.*;

public class IterationTypes {

    public static void main(String[] args) {
        listAndSetAndQueueIterationTypes();
        mapIterationTypes();
    }

    // These iteration techniques work for all classes implementing Iterable:
    // List: ArrayList, LinkedList, Vector, Stack
    // Set: HashSet, LinkedHashSet, TreeSet
    // Queue/Deque: PriorityQueue, ArrayDeque
    public static void listAndSetAndQueueIterationTypes() {

        // Create a Set and add 10 numbers (1 to 10)
        Set<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("=== Enhanced For Loop ===");
        for (Integer num : numbers) {
            System.out.println(num);
        }

        System.out.println("\n=== Iterator (while loop) ===");
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n=== Iterator (for loop) ===");
        for (Iterator<Integer> it = numbers.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        System.out.println("\n=== JDK 8 forEach (Lambda) ===");
        numbers.forEach(n -> System.out.println(n));

        System.out.println("\n=== JDK 8 Stream (filter even numbers) ===");
        numbers.stream()
                .filter(n -> n % 2 == 0) //used method reference below
                .forEach(System.out::println); // Replacement for .forEach(n -> System.out.println(n));
    }

    // Map iteration methods applicable to:
    // HashMap, LinkedHashMap, TreeMap, ConcurrentHashMap
    public static void mapIterationTypes() {

        Map<String, Integer> map = new HashMap<>();
        map.put("Java", 1);
        map.put("Javascript", 2);
        map.put("C++", 3);
        map.put("GoLang", 4);
        map.put("C#", 5);

        System.out.println("\n=== Map Iteration: EntrySet (foreach) ===");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key -> " + entry.getKey() + " | Value -> " + entry.getValue());
        }

        System.out.println("\n=== Map Iteration: forEach (Lambda) ===");
        map.forEach((key, value) ->
                System.out.println("Key -> " + key + " | Value -> " + value));

        System.out.println("\n=== Map Iteration: Iterator (EntrySet) ===");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key -> " + entry.getKey() + " | Value -> " + entry.getValue());
        }
    }
}
