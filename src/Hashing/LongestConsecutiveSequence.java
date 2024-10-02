package Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequenceOptimal(nums));
    }

    //TC -> O(N log N) + O(N)
    //SC -> O(1)
    public static int longestConsecutiveSequenceBetter(int[] nums){
        int currentConsecutive = 1;
        int maxConsecutive = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i]+1 == nums[i+1]){
                currentConsecutive++;
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
            }else{
                currentConsecutive = 1;
            }
        }
        return maxConsecutive;
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
