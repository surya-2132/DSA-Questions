package ZOOPS;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Collection_Interface_Demo {
    /**
    -------------------------------------------------------------------------
    COLLECTION INTERFACE vs COLLECTIONS CLASS
    -------------------------------------------------------------------------
    1. Collection (Interface)
       - It is the root interface of the Java Collection Framework.
       - Represents a group of individual objects as a single unit.
       - Extended by List, Set, Queue, Deque, etc.
       - Defines basic operations: add(), remove(), size(), iterator(), etc.
       - Does NOT contain static utility methods.
       - Located in: java.util.Collection

    2. Collections (Utility Class)
       - A final class that contains static helper methods for working with
         Collection objects.
       - Provides algorithms such as sort(), reverse(), shuffle(),
         max(), min(), frequency(), etc.
       - Provides methods to create synchronized or unmodifiable collections.
       - Does NOT represent a data structure; it only operates on them.
       - Located in: java.util.Collections

    Summary:
       - Collection → Interface that defines behaviors of collection types.
       - Collections → Utility class providing static methods to operate on
                      instances of Collection and its subtypes.

     List (ArrayList, LinkedList, Vector, Stack)
     Set (HashSet, LinkedHashSet, TreeSet)
     Queue / Deque (ArrayDeque, PriorityQueue, LinkedList as Queue/Deque)
     Map (HashMap, LinkedHashMap, TreeMap, Hashtable, ConcurrentHashMap)
     Misc (Collections utility, synchronized wrappers, etc.)
    -------------------------------------------------------------------------
    **/


    public static void collectionInterfaceDemo() {

        // ---------------------------
        // 1. LIST IMPLEMENTATIONS -> List is an interface(Left), classes which implements List interface on (Right)
        // ---------------------------
        List<String> arrayList       = new ArrayList<>();
        List<String> linkedList      = new LinkedList<>();
        List<String> vector          = new Vector<>();
        Stack<String> stack          = new Stack<>();  // subclass of Vector

        // ---------------------------
        // 2. SET IMPLEMENTATIONS -> Set is an interface(Left), classes which implements Set interface on (Right)
        // ---------------------------
        Set<String> hashSet          = new HashSet<>();
        Set<String> linkedHashSet    = new LinkedHashSet<>();
        Set<String> treeSet          = new TreeSet<>();

        // ---------------------------
        // 3. QUEUE / DEQUE IMPLEMENTATIONS -> Queue is an interface(Left), classes which implements Queue interface on (Right)
        // ---------------------------
        Queue<String> priorityQueue  = new PriorityQueue<>();
        Queue<String> linkedListQ    = new LinkedList<>();  // LinkedList implements Queue
        Deque<String> arrayDeque     = new ArrayDeque<>();
        Deque<String> linkedListD    = new LinkedList<>();  // LinkedList implements Deque

        // ---------------------------
        // 4. MAP IMPLEMENTATIONS -> Map is an interface(Left), classes which implements Map interface on (Right)
        // ---------------------------
        Map<String, Integer> hashMap             = new HashMap<>();
        Map<String, Integer> linkedHashMap       = new LinkedHashMap<>();
        Map<String, Integer> treeMap             = new TreeMap<>();
        Map<String, Integer> hashtable           = new Hashtable<>();
        Map<String, Integer> concurrentHashMap   = new ConcurrentHashMap<>();

        // ---------------------------
        // 5. COLLECTION UTILITY WRAPPERS
        // ---------------------------
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        Set<String> syncSet   = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

        // ---------------------------
        // 6. OPTIONAL: IMMUTABLE COLLECTIONS (Java 9+)
        // ---------------------------
        List<String> immutableList = List.of("A", "B", "C");
        Set<String> immutableSet   = Set.of("A", "B", "C");
        Map<String, Integer> immutableMap = Map.of("A", 1, "B", 2);

        // ---------------------------
        // PRINT CONFIRMATION
        // ---------------------------
        System.out.println("All major Collection API classes initialized successfully!");
    }

}
