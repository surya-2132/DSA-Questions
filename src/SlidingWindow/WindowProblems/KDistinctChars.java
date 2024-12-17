package SlidingWindow.WindowProblems;

import java.util.HashMap;

public class KDistinctChars {
    public static void main(String[] args) {
        String str = "aababbcaacc";
        System.out.println(kDistinctCharOptimal(str, 2));
    }

    //Brute Approach using for loop nested-ly + HashMap
    public static int kDistinctCharBrute(String s, int k) {

        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){

            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++){
                //NOTE: first add the chars into map, then chekc the size of map()
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                //Check if the number of distinct characters is within the limit
                if(map.size() <= k){
                    maxLen = Math.max(maxLen, j - i + 1);
                }else{
                    break;
                }
            }
        }

        return maxLen;
    }



    //Exactly the same qus as fruits in baskets, just modify code according to string
    public static int kDistinctCharOptimal(String s, int k) {
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
