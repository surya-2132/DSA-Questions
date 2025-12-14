package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 102, 100, 101, 101, 102, 4, 4, 4, 3, 1, 2, 3, 1, 1, 5};
        System.out.println(longestConsecutiveSequenceOptimal(nums));
    }

    //TC -> O(N log N) + O(N)
    //SC -> O(1)
    public static int longestConsecutiveSequenceBetter(int[] nums){
        Arrays.sort(nums); //1, 1, 1, 2, 3, 3, 4, 4, 4, 5, 100, 100, 101, 101, 102, 102
        int currConsec = 0;
        int longestConsec = 0;
        int oneNumLesser = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            //n[3]-1 is 2-1 = 1 and it equals oneNumLesser which is 1 here to inc count
            if(nums[i] - 1 == oneNumLesser){
                currConsec++;
                oneNumLesser = nums[i];
            }
            //condition where 5, 100 -> oneNumLesser should be 99, we don't have so reset variables
            else if(nums[i] != oneNumLesser){
                currConsec = 1;
                oneNumLesser = nums[i];
            }

            longestConsec = Math.max(longestConsec, currConsec);
        }

        return longestConsec;
    }


    //TC -> O(N)
    //SC -> O(N)
    public static int longestConsecutiveSequenceOptimal(int[] nums){
        // Create a HashMap to keep track of each element and if it has been visited
        HashMap<Integer, Boolean> map = new HashMap<>();
        int maxLarge = 1;

        // Mark each element as unvisited initially
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, Boolean.FALSE));
        }

        // Iterate over each element in the array
        for (int i = 0; i < nums.length; i++) {
            int currLarge = 1;

            // Find the next consecutive elements and mark them as visited
            int nextEle = nums[i] + 1;
            while (map.containsKey(nextEle) && map.get(nextEle) == Boolean.FALSE) {
                currLarge++;
                map.put(nextEle, Boolean.TRUE); // Mark the element as visited
                nextEle++;
            }

            // Find the previous consecutive elements and mark them as visited
            int prevEle = nums[i] - 1; // Corrected: prevEle should be nums[i] - 1
            while (map.containsKey(prevEle) && map.get(prevEle) == Boolean.FALSE) {
                currLarge++;
                map.put(prevEle, Boolean.TRUE); // Mark the element as visited
                prevEle--;
            }

            // Update the maximum length of the consecutive sequence found so far
            maxLarge = Math.max(maxLarge, currLarge);
        }

        return maxLarge;
    }

}
