package Arrays.Medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("productExceptSelf : " + Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];

        // prefix[i] stores product of all elements from the beginning
        prefix[0] = 1;
        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        // suffix[i] stores product of all elements from the end
        suffix[nums.length-1] = 1;
        for(int i = suffix.length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        //multiplying both the results with head to head (0,0 / 1,1 / 2,2)
        //and storing in ans array
        for(int i = 0; i < nums.length; i++){
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
}