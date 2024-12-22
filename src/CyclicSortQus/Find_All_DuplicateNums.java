package CyclicSortQus;

import java.util.ArrayList;
import java.util.List;

public class Find_All_DuplicateNums {
    public static void main(String[] args) {

        System.out.println("Duplicate Number: " + findDuplicateNumber(new int[]{1,3,4,2,2}));
        System.out.println("Duplicate Number: " + findAllDuplicateNums(new int[]{4,3,2,7,8,2,3,1}));
    }


    // Leetcode: 287 Find the Duplicate Number
    // Given an array of integers nums from [1, n] inclusive.
    // There is only one repeated number in nums, return this repeated number.
    public static int findDuplicateNumber(int[] nums){

        CyclicSort.cyclicSort(nums);    //Given range itself [1, n] so use existing cyclic sort code

        for(int index = 0; index < nums.length; index++){
            if(index + 1 != nums[index]){
                return nums[index]; //since they asked for duplicate number return number itself
            }
        }
        return -1;
    }


    // Leetcode: 442 Find All Duplicates in an Array
    // Given an array of integers nums from [1, n] inclusive.
    // Each integer appears at most twice, return an array of all the integers that appears twice.
    public static List<Integer> findAllDuplicateNums(int[] nums){

        CyclicSort.cyclicSort(nums);    //Given range itself [1, n] so use existing cyclic sort code

        List<Integer> list = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(index + 1 != nums[index]){
                list.add(nums[index]);
            }
        }
        return list;
    }
}