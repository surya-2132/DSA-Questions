package Recursion.SubSetAndCombinationSums;

import java.util.ArrayList;
import java.util.List;

public class Subset0_CombinationSum1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(powerSet(nums));
    }

    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recSet(0, list, ansList, nums, nums.length);
        return ansList;
    }

    public static void recSet(int index, List<Integer> list, List<List<Integer>> ansList, int[] nums, int numsLength){

        if(index == numsLength){
            ansList.add(new ArrayList<>(list));
            return;
        }

        recSet(index + 1, list, ansList, nums, numsLength);
        list.add(nums[index]);

        recSet(index + 1, list, ansList, nums, numsLength);
        list.removeLast();

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //your code goes here
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recCombination(0, list, ansList, target, candidates.length, candidates);
        return ansList;
    }

    public void recCombination(int index, List<Integer> list,
                               List<List<Integer>> ansList,
                               int sum, int n, int[] nums){
        if(sum == 0){
            ansList.add(new ArrayList<>(list));
            return;
        }

        if(sum < 0 || index == n){
            return;
        }


        recCombination(index, list, ansList, sum - nums[index], n, nums);
        list.add(nums[index]);

        list.removeLast();
        recCombination(index + 1, list, ansList, sum, n, nums);
        return;
    }
}
