package CyclicSortQus;

import java.util.Arrays;

public class SetMissMatch {
    public static void main(String[] args) {
        System.out.println("Set Mismatch: " + Arrays.toString(findErrorNums(new int[]{1,4,2,2,7,6,5,9,8})));
    }

    // Leetcode: 645 Set Mismatch
    // Find the number that occurs twice and the number that is missing. Return[occurred, missing]
    public static int[] findErrorNums(int[] nums) {
        CyclicSort.cyclicSort(nums);

        for(int index = 0; index < nums.length; index++){
            if(index + 1 != nums[index]){
                return new int[]{nums[index], index + 1};
            }
        }

        return new int[]{};
    }
}
