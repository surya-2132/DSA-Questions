package Recursion.SubSetAndCombinationSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Take and Not take approach - index + 1 is taking
public class SubSet_0_1_2 {
    public static void main(String[] args) {

        System.out.println("Subset 0: "+subSet0_PowerSet(new int[]{1,2,3}));

        System.out.println("Subset 1: "+subset1_AllSums(new int[]{5,2,1}));

        System.out.println("Subset 2: "+subsets2_WithDup(new int[]{1,1,2,2,2,3,3}));

    }



    //Qus 1: SubSet 0 AKA power set - Generate all subsequences even duplicates
    public static List<List<Integer>> subSet0_PowerSet(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recSubSet0(0, list, ansList, nums, nums.length);
        return ansList;
    }
    private static void recSubSet0(int index, List<Integer> list, List<List<Integer>> ansList, int[] nums, int n){
        if(index == n){
            ansList.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        recSubSet0(index + 1, list, ansList, nums, n);

        list.removeLast();
        recSubSet0(index + 1, list, ansList, nums, n);
    }




    //QUS 2: SubSet 1 - Get the sum of all generated subsequences
    public static List<Integer> subset1_AllSums(int[] nums) {
        // Start the recursion with index 0 and initial sum 0
        List<Integer> list = new ArrayList<>();
        recSubSet1(0, 0, list, nums, nums.length);
        return list;
    }
    private static void recSubSet1(int index, int sum, List<Integer> list, int[] nums, int n){
        // Base case: if the index reaches the end of the nums array,
        // Add the current subset 'SUM' to the answer list
        if(index == n){
            list.add(sum);
            return;
        }

        // Left rec tree DO sum, Recursively "include" the current element in the sum
        recSubSet1(index + 1, sum + nums[index], list, nums, n);

        // Right rec tree NO sum, Recursively "exclude" the current element from the sum
        recSubSet1(index + 1, sum, list, nums, n);
    }




    //QUS 3: Subset 2 - Generate all subsequences WITHOUT duplicates
    public static List<List<Integer>> subsets2_WithDup(int[] nums) {
        //Make sure to sort the array for avoid duplicate questions
        //pass the sorted array to easily skip adjacent duplicates
        Arrays.sort(nums);

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recSubSet2(0, list, ansList, nums, nums.length);
        return ansList;
    }
    private static void recSubSet2(int index, List<Integer> list, List<List<Integer>> ansList, int[] nums, int n){
        if(index == n){
            ansList.add(new ArrayList<>(list));
            return;
        }

        // Add current number to the combination
        list.add(nums[index]);
        recSubSet2(index + 1, list, ansList, nums, n);

        list.remove(list.size()-1);//Backtracking process
        // Skip duplicates to avoid redundant combinations, can use Binary search upper bound code too.
        for(int j = index; j < nums.length; j++){
            if(nums[index] != nums[j]){
                recSubSet2(j, list, ansList, nums, n);
                return;
            }
        }

        // Ensure the function finishes when no more unique elements are left
        recSubSet2(nums.length, list, ansList, nums, n);
    }

}
