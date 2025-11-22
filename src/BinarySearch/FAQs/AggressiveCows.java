package BinarySearch.FAQs;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] nums = {0, 3, 4, 7, 10, 9};
        System.out.println("Cows maximum distance: " +aggressiveCowsOptimal(nums, 4));
    }

    //linear search
    public static int aggressiveCowsBrute(int[] nums, int kCows){
        Arrays.sort(nums);
        int min = nums[0]; //1st elem
        int max = nums[nums.length-1]; // last elem
        int limit = max - min;

        for(int i = 1; i < limit; i++){
            if(!canWePlace(nums, kCows, i)){
                return i-1; //The Current interval between two cows is not possible but last one was. so return prev idx
            }
        }
        return limit; //like returning -1
    }


    //Binary Search
    public static int aggressiveCowsOptimal(int[] nums, int kCows){
        Arrays.sort(nums);
        int min = nums[0]; //1st elem
        int max = nums[nums.length-1]; // last elem

        int low = 1;
        int high = max - min;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if(!canWePlace(nums, kCows, mid)){
                high = mid - 1; // if we can't place with longer distance, then reduce the distance by moving high
            }
            else{
                low = mid + 1;
            }
        }
        return high; //like returning -1
    }


    public static boolean canWePlace(int[] nums, int kCows, int distance){
        int totalCowsPlaced = 1;
        int lastCowPlaced = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] - lastCowPlaced >= distance){
                totalCowsPlaced++;
                lastCowPlaced = nums[i]; //when we place next cow we need to subtract distance from updated location
            }

            if(totalCowsPlaced >= kCows) return true;
        }

        return false;
    }
}
