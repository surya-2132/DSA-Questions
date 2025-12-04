package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPermutations {


    /*Wrap our nextPermutation in an outer loop that:
    stores the starting permutation, repeatedly:
    1) Saves the current state to ans,
    2) Calls nextPermutation,
    3)stops when you’re back at the starting permutation.*/
    private static  int totalPermutations = 0;

    public static void main(String[] args) {
        int[] nums = {2,1,5,4,3,0,0};
        System.out.println(permute(nums));
        System.err.println(totalPermutations);
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Make a working copy we will mutate using nextPermutation()
        int[] current = nums.clone();

        // Save the starting permutation so we know when the cycle ends
        int[] firstPermutation = current.clone();

        // Generate all permutations until we return to the start
        do {
            totalPermutations++;
            result.add(addToList(current));  // record current permutation
            nextPermutation(current);      // mutate to next permutation
        } while (!Arrays.equals(current, firstPermutation));

        return result;
    }


    //Add current (int)array elems into list and return the list
    public static List<Integer> addToList(int[] nums){
        List<Integer> currList = new ArrayList<>(nums.length);
        for(int num : nums){
            currList.add(num);
        }

        return currList;
    }


    // Our prev solution of nextPermutation, but made void + in-place for convenience
    public static void nextPermutation(int[] nums) {

        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > pivot; i--) {   // note: i > breakIdx
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break;
            }
        }

        reverse(nums, pivot + 1, nums.length - 1);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) {
            swap(a, l++, r--);
        }
    }
}