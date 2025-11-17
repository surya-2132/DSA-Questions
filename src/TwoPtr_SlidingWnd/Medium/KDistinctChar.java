package TwoPtr_SlidingWnd.Medium;

import java.util.HashMap;

public class KDistinctChar {
    public static void main(String[] args) {
        System.out.println(kDistinctChar("aababbcaacc", 2));
    }

    //Longest Substring With At Most K Distinct Characters
    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
    //Exactly same qus like fruits in baskets, just modify code according to string
    public static int kDistinctChar(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = s.length();
        //Map to track the count of each fruit type in the current window
        HashMap<Character, Integer> map = new HashMap<>();

        while(right < n){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            //If the number of distinct char exceeds k, shrink the window from the left
            if(map.size() > k){
                //while(map.size() > k){ // -> to make it optimal remove loop
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) -1);

                //if that left elem freq is 0, remove that elem from the map
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
                //}

            }

            //Again if number of distinct char is at most k, update maxLen
            if(map.size() <= k){
                int currLen = right - left + 1;
                maxLen = Math.max(maxLen, currLen);
            }

            right++;
        }

        return maxLen;
    }
}
