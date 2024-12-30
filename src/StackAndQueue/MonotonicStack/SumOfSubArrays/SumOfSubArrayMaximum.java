package StackAndQueue.MonotonicStack.SumOfSubArrays;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMaximum {
    public static void main(String[] args) {
        int[] nums = {5, 7, 9, 6, 7, 4, 5, 1, 3, 7};
        int result = sumSubarrayMaximumsOptimal(nums);
        System.out.println("Total Sum of Subarray Maximums: " + result);
    }


    public static int sumSubarrayMaximumsOptimal(int[] nums) {
        // first -> find the prev greatest element on the left half of curr elem
        // second -> find the next greatest elem on the right half of curr elem
        // once we find the first and second, we will calculate the product of subarray length
        // total = product * currElem along with mod will be out total

        int[] pge = previousGreaterElement(nums);
        System.out.println(Arrays.toString(pge));
        int[] nge = nextGreaterElement(nums);
        System.out.println(Arrays.toString(nge));


        int totalSubArrayMax = 0;
        final int MOD = (int)1e9 + 7;
        for(int i = 0; i < nums.length; i++){
            int leftSubArraySize = i - pge[i];
            int rightSubArraySize = nge[i] - i;

            // calculate the contribution and use modulo correctly to avoid overflow
            // totalSubArrayMax = (totalSubArrayMax + (leftSubArraySize * rightSubArraySize * nums[i]) % MOD) % MOD;

            long contribution = (long) leftSubArraySize * rightSubArraySize % MOD * nums[i] % MOD;
            totalSubArrayMax = (int) ((totalSubArrayMax + contribution) % MOD);
        }

        return totalSubArrayMax;
    }


    // PGE
    public static int[] previousGreaterElement(int[] nums){
        //5, 7, 9, 6, 7, 4, 5, 1, 3, 7
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++){

            //peak is smaller than currElem, then pop peekElem.
            //since we are pushing index into stack -> nums[stack.peek() aka idx] will give the element
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ansArr[i] = stack.peek();
            }

            stack.push(i);
        }

        return ansArr;
    }


    // NGE
    public static int[] nextGreaterElement(int[] nums){
        //5, 7, 9, 6, 7, 4, 5, 1, 3, 7
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, n);
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--){

            //peak is smaller than currElem, then pop peekElem.
            //since we are pushing index into stack -> nums[stack.peek() aka idx] will give the element
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                ansArr[i] = stack.peek();
            }

            stack.push(i);
        }

        return ansArr;
    }
}
