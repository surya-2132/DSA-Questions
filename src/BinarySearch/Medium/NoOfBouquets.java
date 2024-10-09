package BinarySearch.Medium;

public class NoOfBouquets {
    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println(roseGardenBrute(nums.length, nums, 3, 2));
        System.out.println(roseGardenOptimal(nums.length, new int[]{1, 10, 3, 10, 2}, 1, 3));
    }

    //m is required bouquet
    //k is adjacent roses -> can assume like window
    //n is no of element in an array
    public static int roseGardenBrute(int n, int[] nums, int k, int m) {

        if((long) m * k > n){ //exceeds required number of elems in array
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        for(int i = min; i <= max; i++){
            if(isBouquetPossibleOnGivenDay(nums, i, k, m)){
                return i;
            }
        }
        return -1;
    }

    //m is required bouquet
    //k is adjacent roses -> can assume like window
    //n is no of element in an array

    //TC -> O(N x log(min - max + 1))
    public static int roseGardenOptimal(int n, int[] nums, int k, int m) {
        if((long) m * k > n){ //exceeds required number of elems in array
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int low = min;
        int high = max;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(isBouquetPossibleOnGivenDay(nums, mid, k, m)){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans; // can return low itself
    }

    public static boolean isBouquetPossibleOnGivenDay(int[] nums, int days, int k, int m) {

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
        noOFBouquet += (currCount / k); //me might left with count when coming out to loop so check again with remaining count
        return noOFBouquet >= m;
    }
}
