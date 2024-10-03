package Hashing;

import java.util.HashMap;

public class CountOfSubArraysWithSumK {

    public static void main(String[] args) {

    }

    public static int subarraySumBrute(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySumOptimal(int[] nums, int k) {

        int sum = 0;
        int count = 0;
        //The map stores the count of each prefix sum encountered so far.
        //The key is the prefix sum value,
        //and the value is the count of how many times that sum has occurred.
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];  //current running sum
            if(sum == k){
                count++;
            }

            int rem = sum - k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            //If rem exists in the map, it means there are subarrays that sum to k.
            // Increment count by the number of occurrences of rem.

            // Update the map with the current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
    }
}
