package Strings.Basics;

import java.util.*;

public class IsomorphicString {
    public static void main(String[] args) {
        String s = "add";
        String t = "egg";
        System.out.println(isomorphicString(s, t));
        String str = "abcde";
        reverse(str, 0, str.length()-1);

    }
    public static void reverse(String str, int start, int end){
        char[] chars = str.toCharArray();

        while (start < end) {
            // Swap characters at the start and end pointers
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            // Move the pointers towards the center
            start++;
            end--;
        }
        System.out.println(str);
    }

    public static boolean isomorphicString(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        // Populate frequency map for string 's'
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Populate frequency map for string 't'
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Sort both maps by value in descending order
        List<Map.Entry<Character, Integer>> sortedSMap = new ArrayList<>(sMap.entrySet());
        List<Map.Entry<Character, Integer>> sortedTMap = new ArrayList<>(tMap.entrySet());

        // Comparator to sort by value in descending order
        Comparator<Map.Entry<Character, Integer>> valueComparator = (a, b) -> b.getValue() - a.getValue();

        // // Sorting both lists -> this again sorting in asc
        sortedSMap.sort(valueComparator);
        sortedTMap.sort(valueComparator);

        // Compare the sorted frequency values of sMap and tMap
        if (sortedSMap.size() != sortedTMap.size()) {
            return false;  // If the size of sorted lists differs, they can't be isomorphic
        }

        for (int i = 0; i < sortedSMap.size(); i++) {
            if (!sortedSMap.get(i).getValue().equals(sortedTMap.get(i).getValue())) {
                return false;  // If any frequency value doesn't match, return false
            }
        }

        return true;  // Return true if all the frequency values match
    }
}
