package StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater2 {
    public static void main(String[] args) {
        int[] nums = { 2, 10, 12, 1, 11};
        System.out.println(Arrays.toString(nextGreater2Optimal(nums)));
    }


    // Assume as a circular array
    public static int[] nextGreater2Brute(int[] nums){
        // 2, 10, 12, 1, 11 -> but in circular we have to iterate till:
        // "idx to end" then "beginning to idx-1" which can be archived by %

        int[] ansArr = new int[nums.length];
        Arrays.fill(ansArr, -1);
        for(int i = 0; i < nums.length; i++){

            // Nested loop to get the next greater element
            for(int j = i + 1; j < i+nums.length-1; j++){
                int idx = j % nums.length; // to make it circular

                // If the next greater element is found (even in a circular array)
                if(nums[i] < nums[idx]){
                    ansArr[i] = nums[idx];
                    break;
                }
            }
        }

        return ansArr;
    }


    public static int[] nextGreater2Optimal(int[] nums){
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n-1; i >= 0; i--){
            // Removing elements from stack whichever smaller than curr elem
            while(!stack.isEmpty() && nums[i%n] >= stack.peek()){
                stack.pop();
            }

            // Since we doubled the array (Hypothetically),
            // when its comes to actual size, then start filling elem from peeking stack.
            if(i < n) {
                // ansArr[i] = stack.isEmpty() ? -1 : stack.peek();
                if (stack.isEmpty()) { // can use ternary operator here
                    ansArr[i] = -1;
                } else {
                    ansArr[i] = stack.peek();
                }
            }

            // Always push current element for future comparison
            stack.push(nums[i%n]);
        }

        return ansArr;
    }
}
