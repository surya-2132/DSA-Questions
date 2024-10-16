package Recursion.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(letterCombinations("34"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        // Step 1: Create a map for digit-to-letter mapping
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // Step 2: Initialize result list and call recursive function
        List<String> result = new ArrayList<>();
        recCombinations(0, result, map, digits, new StringBuilder());
        return result;
    }

    // Recursive function to generate combinations
    private static void recCombinations(int index, List<String> result, HashMap<Character, String> map, String digits, StringBuilder current) {
        // Base case: If we've processed all digits, add the current combination to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Step 3: Get the letters mapped to the current digit
        String letters = map.get(digits.charAt(index));

        // Step 4: Loop through the letters and recurse for the next digit
        // for "34" current will hold "d e f" and letters will hold "g h i" and append current with letters each time
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));  // Add the letter
            recCombinations(index + 1, result, map, digits, current);  // Recurse for the next digit
            current.deleteCharAt(current.length() - 1);  // Backtrack and remove the last added letter - will remove d with ghi on each iteration
        }
    }
}

