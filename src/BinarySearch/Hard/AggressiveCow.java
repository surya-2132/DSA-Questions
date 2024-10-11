package BinarySearch.Hard;

import java.util.Arrays;

public class AggressiveCow {
    // Minimum distance between any two cows is the maximum possible.
    // Find the maximum possible minimum distance.

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 5};
        System.out.println(aggressiveCows(nums, 3));
    }

    public static int aggressiveCows(int[] nums, int noOfCows) {

        Arrays.sort(nums);
        int maxLimit = nums[nums.length-1] - nums[0];

        int low = 0;
        int high = maxLimit;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canWePlace(nums, mid, noOfCows)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

//brute force
//        for(int i = 1; i < maxLimit; i++){
//            if(!canWePlace(nums, i, noOfCows)){
//                return (i-1);
//            }
//        }
//        return maxLimit;

        return high; // if cows can be placed in first and last index return the entire length of arr

    }

    public static boolean canWePlace(int[] nums, int dist, int noOfCows){

        int countOfCowsPlaced = 1;
        int lastCowPosition = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - lastCowPosition >= dist){
                countOfCowsPlaced++;
                lastCowPosition = nums[i];
            }
            if(countOfCowsPlaced >= noOfCows) return true;
        }
        return countOfCowsPlaced >= noOfCows;
    }
}
