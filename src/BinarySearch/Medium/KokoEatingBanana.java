package BinarySearch.Medium;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] nums = {3, 7, 6, 11};
        System.out.println(kokoBananaOptimal(nums, 8));
    }

    public static int kokoBananaBrute(int[] nums, int h){
        int max = maxi(nums);
        for(int i = 1; i <= max; i++){
//            instead of separate method can directly write here too.
//            int totalMinHours = 0;
//            for(int j = 0; j < nums.length; j++){
//                totalMinHours += (int) Math.ceil((double) nums[j] / (double) i);
//            }

            int currentHour = calculateTotalMinHours(nums, i);
            if(currentHour <= h) {
                return i;
            }
        }
        return -1;
    }

    public static int kokoBananaOptimal(int[]nums, int h){
        int low = 1;
        int high = maxi(nums);
        int ans = -1;

        while(low <= high){

            int mid = low + (high - low)/2;
            int currentHour = calculateTotalMinHours(nums, mid);
            if(currentHour <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
                ans = low;
            }
        }
        return ans;
    }

    public static int calculateTotalMinHours(int[] nums, int currentValue){
        int totalMinHours = 0;
        for(int i = 0; i < nums.length; i++){
            totalMinHours +=  (int) Math.ceil((double) nums[i] / (double) currentValue);
        }
        return totalMinHours;
    }

    public static int maxi(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
