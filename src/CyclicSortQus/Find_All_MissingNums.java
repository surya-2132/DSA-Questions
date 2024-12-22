package CyclicSortQus;

import Utility.Operations;

import java.util.ArrayList;
import java.util.List;

public class Find_All_MissingNums {

    public static void main(String[] args) {

        System.out.println("Missing Number: " + missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println("ALl Missing Nums: " + findAllMissingNums(new int[]{4,3,2,7,8,2,3,1}));
    }


    // Leetcode: 268 Missing Number
    // Given an array nums containing n distinct numbers in the range [0, n],
    // return the only number in the range that is missing from the array.
    public static int missingNumber(int[] nums){
        //9,6,4,2,3,5,7,0,1 -> here 8 is missing
        //index: 0, 1, 2, 3, 4, 5, 6, 7, 8
        //elems: 9, 6, 4, 2, 3, 5, 7, 0, 1

        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i];
            if(nums[i] < nums.length && i != nums[i]){   // 9 < 9, swap elem
                Operations.swap(nums, i, correctIndex);
            }
            else{
                i++;
            }
        }

        //After sorting:
        //index : 0, 1, 2, 3, 4, 5, 6, 7, 8
        //elems : 0, 1, 2, 3, 4, 5, 6, 7, 9
        for(int index = 0; index < nums.length; index++){
            if(index != nums[index]){   // since range itself 0 to n no need of idx + 1
                return index;   //index has the elem which is missing
            }
        }
        return nums.length;
    }


    // Leetcode: 448 Find All Numbers Disappeared in an Array
    // Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not appear in nums.
    public static List<Integer> findAllMissingNums(int[] nums) {
        //Exactly the same logic as above, instead return the list of nums
        //Index will have the missing nums.
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                Operations.swap(nums, i, correctIndex);
            }
            else{
                i++;
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(index + 1 != nums[index]){
                list.add(index + 1);
            }
        }
        return list;
    }
}
