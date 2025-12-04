package Arrays.Easy;

import Utility.Operations;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {0,3,4,2,1,6};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberMethod1(nums));
    }


    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; //formula to find the sum of n numbers from 0 to n
        int actualSum = 0;

        for(int num : nums){
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static int missingNumberMethod1(int[] nums){
        cycleSort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i) return i;
        }

        return nums.length;
    }

    public static void cycleSort(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){
                Operations.swap(nums, i, correctIndex);
            }
            else{
                i++;
            }
        }
    }
}