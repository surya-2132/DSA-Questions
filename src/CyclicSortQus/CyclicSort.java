package CyclicSortQus;

import Utility.Operations;
import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {5,4,2,6,1,3};
        System.out.println(Arrays.toString(cyclicSort(nums)));
    }

    // This sorting algorithm can sort an array in Time complexity of
    // BestCase -> O(n) with SC-> O(1)
    // WorstCase -> O(2n-1) with SC-> O(1) which is almost O(N)
    // But limitation is array should have range from (1 to N) or (0 to N) contiguously.
    public static int[] cyclicSort(int[] nums){
        int i = 0;
        while (i < nums.length) {
            int value = nums[i];
            int correctIndex = value - 1;   //Range 1 to N
            if (nums[i] != nums[correctIndex]) {
                Operations.swap(nums, i , correctIndex);
            } else {
                i++;
            }
        }
        return nums;
    }
}
