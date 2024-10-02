package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        System.out.println(longestSubarrayOptimal(nums, 15));
    }

    public static int longestSubarrayBetter(int[] nums, int k) {
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static int longestSubarrayBrute(int[] nums, int target) {
        int maxLength = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == target) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    public static int longestSubarrayOptimal(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // calculate the prefix sum till index i
            sum += nums[i];

            // if the sum equals k, update maxLen
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e., sum - k
            int rem = sum - k;

            // calculate the length and update maxLen
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // update the map if sum is not already present
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
