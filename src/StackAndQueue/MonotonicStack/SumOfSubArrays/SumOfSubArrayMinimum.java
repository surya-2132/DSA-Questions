package StackAndQueue.MonotonicStack.SumOfSubArrays;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMinimum {
    public static void main(String[] args) {
        int[] nums = {11, 81, 94, 43, 3};
        System.out.println(sumSubarrayMinimumsOptimal(nums));
    }

    public static int sumSubarrayMinimumsBrute(int[] nums) {
        int sum = 0;
        for(int i  = 0; i < nums.length; i++){
            int min = Integer.MAX_VALUE;
            //check min in each subarray starting from curr num to end
            for(int j = i; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                sum += min;
            }
        }
        return sum;
    }

    // calc total using formula
    public static int sumSubarrayMinimumsOptimal(int[] nums) {
        // first -> find the prev smallest element on the left half of curr elem
        // second -> find the next smallest elem on the right half of curr elem
        // once we find the first and second, we will calculate the product of subarray length
        // total = product * currElem along with mod will be out total


        int[] nse = nextSmallerElement(nums);
        System.out.println(Arrays.toString(nse));
        int[] pse = prevSmallerEqualElement(nums);
        System.out.println(Arrays.toString(pse));

        int totalSubArrayMin = 0;
        final int MOD = (int)1e9 + 7;
        for(int i = 0; i < nums.length; i++){
            int leftSubArraySize = i - pse[i];
            int rightSubArraySize = nse[i] - i;

            // total += left * right * currElem => 4 * 3 = 12 => 12 * 3 = 36 like this.
            //totalSubArrayMin = (totalSubArrayMin + (leftSubArraySize * rightSubArraySize * nums[i]) % MOD) % MOD;

            long contribution = ((long)leftSubArraySize * rightSubArraySize % MOD) * nums[i] % MOD;
            totalSubArrayMin = (int)((totalSubArrayMin + contribution) % MOD);
        }

        return totalSubArrayMin;
    }



    //PSE
    public static int[] prevSmallerEqualElement(int[] nums){
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);  // -1 means no smaller element found on the left
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements from the stack that are greater than nums[i]
            // The previous smaller element must be smaller than nums[i].
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ansArr[i] = stack.peek();  // store the index of the previous smaller element
            }

            stack.push(i);  // push the index, not the value
        }

        return ansArr;

    }


    // NSE
    public static int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, n);  // set to 'n' as the right boundary if no smaller element is found
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove elements from the stack that are greater than or equal to nums[i].
            // The next smaller element must be smaller than nums[i].
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ansArr[i] = stack.peek(); // store the index of the next smaller element
            }

            stack.push(i); // push index, not the element
        }

        return ansArr;
    }
}