package TwoPtr_SlidingWnd.Hard;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 0, 0, 1};
        System.out.println("Binary SubArrayCount equal to target: "+numSubarraysWithSum(nums, 3));
    }

    //specific type of problem where we break down this into two parts
    //It call the helper function to find out the number of subarrays with sum less than or equal to goal.
    //In the second call, it gets the number of subarrays with sum less than or equal to goal - 1.
    // Finally, the difference gives the exact count of subarrays with sum equal to goal.
    public static int numSubarraysWithSum(int[] nums, int target) {
        return window(nums, target) - window(nums, target-1);
    }

    public static int window(int[] nums, int target){
        //1, 1, 0, 1, 0, 0, 1
        if (target < 0) return 0;

        int left = 0;
        int right = 0;
        int sum = 0;
        int ansCount = 0;

        while(right < nums.length){
            sum = sum + nums[right];

            //if its exceeds target shrink it until it's less than the target,
            //then add the current window to currCount
            while(sum > target){
                sum = sum - nums[left];
                left++;
            }
            //adding window to ans because for ex: 1 0 0 where target is 2
            //which means 1,0,0 all themselves makes an individual valid answer
            //where its it should be currCount+3 to add this, ADD THE ENTIRE WINDOW R-L+1
            int currLenIncludingZero = right - left + 1;
            ansCount += currLenIncludingZero;
            right++;
        }

        return ansCount;
    }
}