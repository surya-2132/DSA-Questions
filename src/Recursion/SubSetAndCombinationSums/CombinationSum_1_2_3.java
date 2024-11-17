package Recursion.SubSetAndCombinationSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_1_2_3 {
    public static void main(String[] args) {

        System.out.println("Combination Sum 1: " + combinationSum1(new int[]{2, 3, 5, 4}, 7));

        System.out.println("Combination Sum 2: " + combinationSum2(new int[]{2, 1, 2, 7, 6, 1, 5}, 8));

        System.out.println("Combination Sum 3: " + combinationSum3(3, 9));

    }



    // QUS 1: Generate the sum which equal TargetSum
    // Don't take on left rec pass the same index and take on right rec without sum calculation
    public static List<List<Integer>> combinationSum1(int[] nums, int sum) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recCombSum1(0, sum, list, ansList, nums, nums.length);
        return ansList;
    }
    private static void recCombSum1(int index, int sum, List<Integer> list, List<List<Integer>> ansList, int[] nums, int n){
        if(sum == 0){
            ansList.add(new ArrayList<>(list));
            return;
        }

        if(sum < 0 || index == n){
            return;
        }

        // Include the current element in the list
        list.add(nums[index]);
        recCombSum1(index, sum - nums[index], list, ansList, nums, n); // Allow picking the same element again

        list.remove(list.size() - 1);  // Backtrack
        recCombSum1(index + 1, sum, list, ansList, nums, n); // Skip the current element
    }



    //QUS 2: Generate Unique list of sequence equals TargetSum (WITHOUT duplicate)
    public static List<List<Integer>> combinationSum2(int[] nums, int sum) {
        //Sort the list for the unique list and to avoid duplication entries on ansList
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recCombSum2(0, sum, list, ansList, nums, nums.length);
        return ansList;
    }
    private static void recCombSum2(int index, int sum, List<Integer> list, List<List<Integer>> ansList, int[] nums, int n){
        if(sum == 0){
            ansList.add(new ArrayList<>(list));
            return;
        }

        if(sum < 0 || index == n){
            return;
        }

        // Include the current element in the list
        list.add(nums[index]);
        recCombSum2(index + 1, sum - nums[index], list, ansList, nums, n); // Allow picking the same element again

        list.remove(list.size() - 1);  // Backtrack
        for(int i = index; i < nums.length; i++){
            if(nums[index] != nums[i]){
                recCombSum2(i, sum, list, ansList, nums, n);
                return;
            }
        }

        // Ensure the function finishes when no more unique elements are left
        recCombSum2(n, sum, list, ansList, nums, n);
    }



    // QUS 3: Generate TargetSum which should have k size
    // Use number 1 to 9, each number in a ansList should be used only once
    public static  List<List<Integer>> combinationSum3(int kElem, int sum) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recCombSum3(1, kElem, sum, list, ansList);
        return ansList;
    }
    private static void recCombSum3(int currElem, int kElem, int sum, List<Integer> list, List<List<Integer>> ansList){
        // If the sum is zero and the number of elements is k
        if(sum == 0 && list.size() == kElem){
            ansList.add(new ArrayList<>(list));
            return;
        }

        // If the sum is less than or equal to zero or the number of elements exceeds k
        if(sum <= 0 || list.size() > kElem){
            return;
        }

        //element that we will start for each rec
        for(int i = currElem; i <= 9; i++){
            // If the current number is less than or equal to the sum
            if(i <= sum){
                // Add the number to the current combination
                list.add(i);

                // Recursive call with the updated sum and next number
                recCombSum3(i + 1, kElem, sum - i, list, ansList);

                // Remove the last number to backtrack
                list.remove(list.size()-1);
            }
            else {
                // If the number is greater than the sum, break the loop
                break;
            }
        }
    }
}
