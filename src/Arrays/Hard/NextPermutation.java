package Arrays.Hard;

import Utility.Operations;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {2,1,5,4,3,0,0};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    //2,1,5,4,3,0,0
    public static int[] nextPermutation(int[] nums){

        // finding break index
        // Find the first index from the end where nums[i] < nums[i+1]
        int pivot = -1;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

         // If no such index exists, array is in descending order So, reverse it to get the smallest permutation
        if(pivot == -1){
            return Operations.reverse(nums, 0, nums.length-1);
        }

        //2,1,5,4,3,0,0 -> after swap -> 2,3,[5,4,1,0,0]
        for(int i = nums.length-1; i >= pivot; i--){
            if(nums[i] > nums[pivot]){
                Operations.swap(nums, i, pivot);
                break;
            }
        }

        // reverse the remaining array to get the next permutation(smallest)
        // Reverse the right half to get the next smallest permutation
        return Operations.reverse(nums, pivot +1, nums.length-1);

    }
}
