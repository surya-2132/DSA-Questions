package CyclicSortQus;

import Utility.Operations;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println("First Missing positive: " + firstMissingPositive(new int[]{4, 3, 1, -1}));
    }


    // Leetcode: 41 First Missing Positive
    // Given an unsorted integer array nums.
    // Return the smallest positive integer that is not present in nums
    public static int firstMissingPositive(int[] nums){
        // Notes:
        // i)  ignore negative values --- (nums[i] > 0) and integers > N ---(nums[i] <= nums.length)
        // ii) start checking from 1 to N,
        // iii) apply cyclic sort.

        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                Operations.swap(nums, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < nums.length; index++) {
            if (index + 1 != nums[index]) {
                return index + 1;
            }
        }

        // case 2
        return nums.length + 1; //if 1,2,3,4 is present 5th elem is our ans
    }
}
