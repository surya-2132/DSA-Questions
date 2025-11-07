package SlidingWindow.CountingSubsProblem;

import Hashing.CountOfSubArraysWithSumK;

public class BinarySubArraySumEqualsK {
    public static void main(String[] args) {

    }

    //Brute: Using 2 for loop (nested-ly)
    public static int binaryNumSubArraysWithSumBrute(int[] nums, int goal) {
        //Check Hashing Qus
        return CountOfSubArraysWithSumK.subarraySumBrute(nums, goal);
    }


//    //Qus 1: Optimal using a reverse window
//    public static int binaryNumSubArraysWithSumOptimal(int[] nums, int goal){
//
//    }
//
//
//    //Qus 1: Optimal using a reverse window with (% 2) operator
//    public static int niceSubArrayOptimal(int[] nums, int goal){
//
//    }
}
