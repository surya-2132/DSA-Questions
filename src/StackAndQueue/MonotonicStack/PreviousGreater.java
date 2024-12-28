package StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreater {
    public static void main(String[] args) {
        int[] nums = {5, 7, 9, 6, 7, 4, 5, 1, 3, 7};
        System.out.println(Arrays.toString(previousGreater(nums)));
        System.out.println(Arrays.toString(brute(nums)));
    }

    public static  int[] brute(int[] nums){
        int[] ansArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ansArr[i] = -1; // Initialize to -1 (no greater element found)

            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) { // If we find a previous greater element
                    ansArr[i] = nums[j]; // Set the current index to that greater element
                    break; // No need to check further once a greater element is found
                }
            }
        }
        return ansArr;
    }



    public static int[] previousGreater(int[] nums){
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++){

            // Remove elements from the stack that are smaller than or equal to nums[i].
            // The previous greater element must be larger than nums[i].
            while(!stack.isEmpty() && nums[i] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                ansArr[i] = -1;
            }
            else{
                ansArr[i] = stack.peek();
            }

            // Always push current elem for future checks
            stack.push(nums[i]);
        }

        return ansArr;
    }
}
