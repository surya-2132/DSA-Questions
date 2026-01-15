package TwoPtr_SlidingWnd.LongestWindowQus;

import java.util.HashMap;

public class Q1_LongestSubStrWORepeatingChar {
    public static void main(String[] args) {
        System.out.println("Maximum length: "+lengthOfLongestSubstring("abcabcbb"));
    }

    //abcabcbb
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            // If this character was seen before
            // && its last index is inside the current window,
            //we must move 'left' to exclude the previous occurrence to avoid duplicates.
            if (map.containsKey(ch) && left <= map.get(ch)) { //appeared after currLeft
                left = map.get(ch) + 1;
            }

            //else insert current right into the map
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}