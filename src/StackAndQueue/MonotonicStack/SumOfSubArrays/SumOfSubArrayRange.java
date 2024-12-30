package StackAndQueue.MonotonicStack.SumOfSubArrays;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayRange {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        long result = subArrayRanges(nums);
        System.out.println(result);
    }

    //This question is basically the combination of: SumOfSubArrayMinimum and SumOfSubArrayMaximum
    //Once we find both of them just do the sum of {max - min} to find the range sum.
    //Once find the range do sum of all the ranges.

    public static long subArrayRangesDistributed(int[] nums) {
        long maxRangeSum = SumOfSubArrayMaximum.sumSubarrayMaximumsOptimal(nums);
        long minRangeSum = SumOfSubArrayMinimum.sumSubarrayMinimumsOptimal(nums);
        return maxRangeSum - minRangeSum;
    }




    // Type 2: Or we can do everything in one place.
    public static long subArrayRanges(int[] nums) {
        long maxRangeSum = sumSubarrayMaximumsOptimal(nums);
        long minRangeSum = sumSubarrayMinimumsOptimal(nums);
        return maxRangeSum - minRangeSum;  // No need for MOD, as we're returning plain range
    }

    public static long sumSubarrayMaximumsOptimal(int[] nums) {
        int n = nums.length;
        long totalSubArrayMax = 0;

        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[n];  // previous greater element
        int[] nge = new int[n];  // next greater element

        // Initialize arrays
        Arrays.fill(pge, -1);//pge
        Arrays.fill(nge, n);//nge

        // Find Previous Greater Element (PGE)
        // Since pushing index onto the stack, to get elem we are using nums[stack.peek()]
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack for NGE computation
        stack.clear();

        // Find Next Greater Element (NGE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the contribution of each element as the maximum in subarrays
        for (int i = 0; i < n; i++) {
            long leftSubArraySize = i - pge[i];  // subarrays ending at i
            long rightSubArraySize = nge[i] - i;  // subarrays starting at i
            totalSubArrayMax += nums[i] * leftSubArraySize * rightSubArraySize;
        }

        return totalSubArrayMax;
    }

    public static long sumSubarrayMinimumsOptimal(int[] nums) {
        int n = nums.length;
        long totalSubArrayMin = 0;

        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[n];  // previous smaller element
        int[] nse = new int[n];  // next smaller element

        // Initialize arrays
        Arrays.fill(pse, -1);//pse
        Arrays.fill(nse, n);//nse

        // Find Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            }
            stack.push(i);
        }

        // Clear stack for NSE computation
        stack.clear();

        // Find Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }

        // Calculate the contribution of each element as the minimum in subarrays
        for (int i = 0; i < n; i++) {
            long leftSubArraySize = i - pse[i];  // e-s = size, subarrays ending at i
            long rightSubArraySize = nse[i] - i;  // s-e = size, subarrays starting at i
            totalSubArrayMin += nums[i] * leftSubArraySize * rightSubArraySize;
        }

        return totalSubArrayMin;
    }
}
