package Recursion.SubSetAndCombinationSums;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(checkSubsequenceSum(nums, 8));

        System.out.println(countSubsequenceWithTargetSum(nums, 8));

        System.out.println(printAllSubsequenceWithK(nums, 8));
    }


    //QUS 1: Check if there exists a subsequence with sum K
    public static boolean checkSubsequenceSum(int[] nums, int sum) {
        return recSubSeqSumExist(0, sum, nums, nums.length);
    }
    private static boolean recSubSeqSumExist(int index, int sum, int[] nums, int n){
        // If sum is zero, a valid subsequence exists
        if (sum == 0) return true;
        // If all elements are processed and the sum is not zero
        // And, If the current sum becomes negative, we cannot continue
        if (sum < 0 || index == n) return false;


        // Take - Recur by including the current element in the subsequence
        boolean path1 = recSubSeqSumExist(index + 1, sum - nums[index], nums, n);

        // Not Take - Recur by excluding the current element from the subsequence
        boolean path2 = recSubSeqSumExist(index + 1, sum , nums, n);

        return path1 || path2;
    }



    //Qus 2: Count all subsequences with sum K
    public static int countSubsequenceWithTargetSum(int[] nums, int sum) {
        return recSubSeqSumCount(0, sum, nums, nums.length);
    }
    private static int recSubSeqSumCount(int index, int sum, int[] nums, int n){
        if(sum == 0){
            return 1;
        }

        if(sum < 0 || index == n){
            return 0;
        }

        int path1 = recSubSeqSumCount(index + 1, sum - nums[index], nums, n);
        int path2 = recSubSeqSumCount(index + 1, sum, nums, n);

        return path1 + path2;
    }



    //Qus 3: Print all subsequences with targeted sum
    public static List<List<Integer>> printAllSubsequenceWithK(int[] nums, int sum){
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        recPrintAllSubSeqWithSumK(0, sum, currentList, ansList, nums, nums.length);
        return ansList;
    }
    private static void recPrintAllSubSeqWithSumK(int index, int sum, List<Integer> list, List<List<Integer>> ansList, int[]nums, int n){
        if(sum == 0){
            ansList.add(new ArrayList<>(list)); // Add a copy of the current list
            return;
        }

        // No valid subsequence found
        if(sum < 0 || index == n){
            return;
        }

        // Include the current element
        list.add(nums[index]);
        recPrintAllSubSeqWithSumK(index + 1, sum - nums[index], list, ansList, nums, n);

        // Backtrack to explore the path where the current element is not included
        list.remove(list.size() - 1);
        recPrintAllSubSeqWithSumK(index + 1, sum, list, ansList, nums, n);

    }

}
