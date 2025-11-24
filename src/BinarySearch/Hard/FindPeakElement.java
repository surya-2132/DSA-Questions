package BinarySearch.Hard;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};
        System.out.println("Peak Element: "+ findPeak(nums));
    }

    // An array can have multiple peaks
    public static int findPeak(int[] nums){
        // -infi, 1, 2, 3, 4, 5, 6, 7, 8, 5, 1, -infi
        int n = nums.length;


        // Edge cases:
        if (n == 1) return 0; // only one element is present
        if (nums[0] > nums[1]) return 0;  //1st elem > 2nd ele
        if (nums[n - 1] > nums[n - 2]) return n - 1; // last elem > second last ele

        int low = 1;    //reduced search space from one ele after 1st ele
        int high = n-2; //reduced search space from one ele before last ele

        while(low <= high){
            int mid = low + (high - low) / 2;

            // 3 < 4 < 2
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid - 1] < nums[mid]){  //we are in left side so move low to high
                low = mid + 1;
            }else{  //by removing "else if" here, we can eliminate the lowest pt issue where this code fails [1,5,1,2,1]
                high = mid - 1; //we are in right side so move high to low
            }
        }

        return -1;
    }
}
