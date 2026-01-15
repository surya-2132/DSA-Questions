package TwoPtr_SlidingWnd.LongestWindowQus;

import java.util.HashMap;

public class Q5_LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        String s = "BAABAABBBAAA";
        System.out.println(characterReplacement(s, 2));
    }


    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < n){
            //first get the rightChar and check the freq. if not present, put it on the map.
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // Update the max frequency of any character in the current window
            maxFreq = Math.max(maxFreq, map.get(rightChar));

            // Current window length
            int currLen = right - left + 1;

            // if not valid : no of changes needed exceeds 'k',
            // move the 'left' pointer by one and shrink the window using left ptr
            if(currLen - maxFreq > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                left++;
            }

            //If valid : if the current window is valid (changes <= k), update maxLen
            if(currLen - maxFreq <= k){
                maxLen = Math.max(maxLen, currLen);
            }

            right++;
        }

        return maxLen;
    }
}