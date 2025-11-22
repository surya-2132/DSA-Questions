package BinarySearch.FAQs;

import Utility.Operations;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] nums = {7, 15, 6, 3};
        System.out.println("kokoEatingBananas: "+ kokoEatingBananas(nums, 8));
    }

    public static int kokoEatingBananas(int[] nums, int maxHours){
        int low = 0;
        int high = Operations.max(nums);
        int minHour = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int currHour = 0;

            for(int i = 0; i < nums.length; i++){
                currHour += (int) Math.ceil((double) nums[i] / mid);
            }

            if(currHour <= maxHours){
                minHour = currHour;
                high = mid - 1; // shrink the towards left to get even min hour
            }
            else{
                low = mid + 1; //can't eat in curr hour so we need more time to eat, so inc mid
            }
        }

        return minHour;
    }
}