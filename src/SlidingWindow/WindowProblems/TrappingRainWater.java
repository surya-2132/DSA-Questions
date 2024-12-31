package SlidingWindow.WindowProblems;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWaterOptimal(height));
    }
    
    
    //calculating with prefixSum and suffixSum
    // TC-> O(3N), SC-> O(2N)
    public static int trappingRainWaterBrute(int[] nums){
        int n = nums.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = Math.max(nums[i], prefixSum[i-1]);
        }

        int[] suffixSum = new int[n];
        suffixSum[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixSum[i] = Math.max(nums[i], suffixSum[i+1]);
        }

        int totalWater = 0;
        for(int i = 0; i < nums.length; i++){
            int leftMax = prefixSum[i];
            int rightMax = suffixSum[i];
            //if the current number is in between two bigger buildings on the left and right side
            if(leftMax > nums[i] && nums[i] < rightMax){
                //curr elem can store min of any l or r sides unit - curr unit
                //eg: left side is min 3 units, and the current elem is 1 so water can store 3-1 => 2 units.
                totalWater += Math.min(leftMax, rightMax) - nums[i];
            }
        }
        return totalWater;
    }


    // TC-> O(2N), SC-> O(N)
    public static int trappingRainWaterBetter(int[] nums){
        int n = nums.length;
        if (n == 0) return 0;

        int[] maxHeights = new int[n];  // To store the combined prefix and suffix max
        int leftMax = 0;                // Initialize the left max to zero
        int rightMax = 0;               // Initialize the right max to zero
        int totalWater = 0;

        // Calculate the left max and store it in the array
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            maxHeights[i] = leftMax;
        }

        // Calculate the right max and trapped water in the same loop
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, nums[i]);
            // Calculate trapped water at this index by taking the minimum of leftMax and rightMax
            totalWater += Math.min(maxHeights[i], rightMax) - nums[i];
        }

        return totalWater;
    }


    // TC-> O(N), SC-> O(1)
    public static int trappingRainWaterOptimal(int[] height){
        int start = 0;
        int end = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while(start <= end){
            if(height[start] <= height[end]){
                if(leftMax > height[start]){
                    totalWater += leftMax - height[start];
                }
                else{
                    leftMax = height[start];
                }
                start++;
            }
            else{
                if(rightMax > height[end]){
                    totalWater += rightMax - height[end];
                }
                else {
                    rightMax = height[end];
                }
                end--;
            }
        }
        return totalWater;
    }
}
