package Arrays.Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 9, 3, 10, 3, 6};
        System.out.println("Two sum better: " + Arrays.toString(twoSumBetter(nums, 7)));
    }

    // Nested-ly iterate
    public static int[] twoSumBrute(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    // Using Hashmap to find its compliment
    public static int[] twoSumBetter(int[] nums, int target){

        //1, 9, 3, 10, 3, 6 --- target = 7
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(!map.containsKey(complement)){
                map.put(nums[i], i);
            }
            else{
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{-1, -1};
    }


    // Optimal in terms of Space
    // Greedy - Sort and use two pointers of low and high
    // To fetch the index, we have to store the elem and index in 2D array of (elem, index)
    public static int[] twoSumOptimal(int[] nums, int target){

        int n = nums.length;
        int[][] elemIdx = new int[n][2];

        for(int i = 0; i < nums.length; i++){
            elemIdx[i][0] = nums[i];
            elemIdx[i][1] = i;
        }

        Arrays.sort(elemIdx, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = n-1;

        while(left <= right){

            int sum = elemIdx[left][0] + elemIdx[right][0];

            if(sum < target){
                left++;
            }
            else if(sum > target){
                right--;
            }
            else{
                return new int[]{elemIdx[left][1], elemIdx[right][1]};
            }
        }

        return new int[]{-1, -1};
    }
}
