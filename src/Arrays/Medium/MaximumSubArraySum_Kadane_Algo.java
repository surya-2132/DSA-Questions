package Arrays.Medium;

import java.util.Arrays;

public class MaximumSubArraySum_Kadane_Algo {

    public static void main(String[] args) {
        System.out.println(subArrayBrute(new int[]{2, 3, 5, -2, 7, -4}));
        System.out.println(subArrayBetter(new int[]{2, 3, 5, -2, 7, -4}));
        System.out.println(subArrayOptimalUsingAlgo(new int[]{2, 3, 5, -2, 7, -4}));
        System.out.println(Arrays.toString(subArrayItself(new int[]{-2, -3, 4, -1, -2, 1, 5, -3})));

    }

    public static int subArrayBrute(int[] nums){
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            for(int j = i; j < nums.length; j++){
                int sum = 0;

                for(int k = i; k < j; k++){
                    sum += nums[k];
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public static int subArrayBetter(int[] nums){

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){

            // Inner loop: Iterate over all subArrays starting from index 'i' to the end
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j]; // Add current element to the running sum
                max = Math.max(max, sum);  // Update max with the larger value between the current max and the current sum

            }
        }
        return max;
    }

    public static int subArrayOptimalUsingAlgo(int[] nums){
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }

    public static int[] subArrayItself(int[] nums){

        int sum = 0;
        int max = Integer.MIN_VALUE;

        int start = 0;
        int startIndex = -1;
        int endIndex = -1;
        int[] startAndEndIndexArray = new int[2];

        for(int i = 0; i < nums.length; i++){

            if(sum == 0){
                start = i; //when we reset sum to 0, on next iteration's first ele is new start of subArray
            }
            sum += nums[i];

            // Update max sum and track start and end indices of max subarray
            if(sum > max){
                max = sum;
                startIndex = start;
                endIndex = i; //currentIndex
                startAndEndIndexArray[0] = startIndex;
                startAndEndIndexArray[1] = endIndex;
            }

            // Reset sum if it goes negative to start a new subarray
            if(sum < 0){
                sum = 0;
            }
        }

        // Print the entire subarray with the maximum sum
        System.out.print("Maximum sum subarray: ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(); // To print a new line after the subarray

        return startAndEndIndexArray;
    }
}
