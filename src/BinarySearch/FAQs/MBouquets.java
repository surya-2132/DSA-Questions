package BinarySearch.FAQs;

import Utility.Operations;

public class MBouquets {
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println("No Of Days Minimum Needed: " + roseGarden(nums.length, nums, 3, 2));
    }

    public static int roseGarden(int n, int[] nums, int k, int m) {

        if((long) m * k > n){ //exceeds required number of elem in array
            return -1;
        }

        //for brute force approach
        // for(int i = min; i <= max; i++){
        //     if(isBouquetCheckBrute(nums, i, k, m)){
        //         return i;
        //     }
        // }

        int low = Operations.min(nums);
        int high = Operations.max(nums);
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isBouquetCheckBrute(nums, mid, k, m)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans; // can return low itself
    }

    public static boolean isBouquetCheckBrute(int[] nums, int days, int k, int m) {

        int currCount = 0;
        int noOFBouquet = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] <= days){ //curr ele requires less than given day to bloom
                currCount++;
            }else{
                noOFBouquet += (currCount / k);
                currCount = 0;
            }
        }
        noOFBouquet += (currCount / k);

        return noOFBouquet >= m;
    }
}