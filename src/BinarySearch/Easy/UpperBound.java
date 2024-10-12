package BinarySearch.Easy;

public class UpperBound {
    public static void main(String[] args) {
        int[] nums = {3,5,8,15,19};
        System.out.println(upperBound(nums, 3));
    }

    public static int upperBound(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length; //this variable is important for lower/upper bound problems

        while(low <= high){
            int mid = low + (high - low) / 2;

            // Check if mid-element is a potential answer
            if(target < nums[mid]){ //In lower bound <= here just <
                ans = mid;
                high = mid - 1; // Search left half
            }
            else if(nums[mid] <= target) {
                low = mid + 1;  // Search right half
            }
        }
        return ans;
    }
}
