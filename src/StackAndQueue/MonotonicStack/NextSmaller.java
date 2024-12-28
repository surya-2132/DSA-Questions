package StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmaller {
    public static void main(String[] args) {
        int[] nums = {3, 8, 5,  2, 25};
        System.out.println(Arrays.toString(nextSmallerOptimal(nums)));
    }

    public static int[] nextSmallerOptimal(int[] nums){
        // Input -  3, 8, 5,  2, 25
        // output - 2, 5, 2, -1, -1
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--){

            //pop all the element which is greater than curr elem from stack until stack gets empty
            // Remove elements from the stack that are greater than or equal to nums[i].
            // The next smaller element must be smaller than nums[i].
            while(!stack.isEmpty() && nums[i] <= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                ansArr[i] = -1;
            }else{
                ansArr[i] = stack.peek();
            }

            stack.push(nums[i]);
        }

        return ansArr;
    }
}
