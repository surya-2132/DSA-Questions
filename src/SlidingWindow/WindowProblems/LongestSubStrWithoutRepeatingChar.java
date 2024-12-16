package SlidingWindow.WindowProblems;

import java.util.Arrays;

public class LongestSubStrWithoutRepeatingChar {

    public static void main(String[] args) {
        System.out.println(longestNonRepeatingSubstringOptimal("abcddabac"));
    }

    public static int longestNonRepeatingSubstringBrute(String s) {
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            // Creating hash here for the current substring being evaluated.
            // It starts from index i and goes to j.
            int[] hash = new int[256];
            Arrays.fill(hash, 0);

            for(int j = i; j < s.length(); j++){
                //If s.charAt(j) is already in the current substring window
                if(hash[s.charAt(j)] == 1){
                    break;
                }

                hash[s.charAt(j)] = 1; //mark curr char is already visited
                int currNonRepeatingLen = j - i +1;
                max = Math.max(max, currNonRepeatingLen);
            }
        }
        return max;
    }

    public static int longestNonRepeatingSubstringOptimal(String s) {
        int hashLength = 256;
        int[] hash = new int[hashLength];
        Arrays.fill(hash, -1);
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int n = s.length();

        while(right < n){
            char ch = s.charAt(right);  //get current char

            //if present
            if(hash[ch] != -1){
                if(left <= hash[ch]){
                    left = hash[ch] + 1; //move one step ahead of the last occurrence of the current character
                }
            }

            // If its new char, calc local length and update max length
            int currLen = right - left + 1;
            maxLength = Math.max(maxLength, currLen);
            hash[ch] = right;   //put the new char in new right index
            right++;    //move right to the next step
        }

        return maxLength;
    }
}
