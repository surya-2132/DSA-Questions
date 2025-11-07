package SlidingWindow.WindowProblems;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        String str = "BAABAABBBAAA";
        System.out.println(characterReplacementBrute(str, 2));
    }


    //Brute Approach using for loop nested-ly + HashMap
    //Calculate freq on each jth window using -> changes = currWindowLen - maxFreqOfCurrSubStr;
    public static int characterReplacementBrute(String s, int k) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){

            int maxFreqOfCurrSubStr = 0; // Tracks the highest frequency of any character in the current window
//            int[] hash = new int[26];
//            Arrays.fill(hash, 0);
            HashMap<Character, Integer> map = new HashMap<>();

            // Inner loop to expand the window and calculate max length of valid substring
            for(int j = i; j < s.length(); j++){

                // i = 0, j = 0: hash = [1, 0, 0, ..., 0] -> maxFreq = 1, changes = 0 (valid)
                // maxLen = 1 (max(0, 1))

                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);//hash[s.charAt(j) - 'A']++;  // Increment frequency of the current character

                // Update max frequency of any character in the current window
                maxFreqOfCurrSubStr = Math.max(maxFreqOfCurrSubStr, map.get(s.charAt(j))); //hash[s.charAt(j) - 'A'] instead of map

                // Calculate how many changes are required to make the entire window valid
                int changes = (j - i + 1) - maxFreqOfCurrSubStr;

                // If the number of changes needed is within k, update maxLen
                if(changes <= k){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else {
                    // If changes exceed k, further expanding the window will not help, so break
                    break;
                }
            }
        }
        return maxLen; // Return the maximum length of a valid substring
    }
}
