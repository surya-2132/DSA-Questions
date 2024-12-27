package StackAndQueue.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater1 {
    public static void main(String[] args) {
        int[] nums = {8, 3, 4, 6, 1, 2, 7, 5, 9};
        System.out.println(Arrays.toString(nextGreater1Optimal(nums)));
    }

    public int[] nextLargerElement(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i = 0; i < n; i++) {
            int currEle = arr[i];

            // Nested loop to get the next greater element
            for(int j = i + 1; j < n; j++) {

                // If the next greater element is found
                if(arr[j] > currEle) {
                    // Store the next greater element
                    ans[i] = arr[j];
                    // Break from the loop
                    break;
                }
            }
        }

        return ans;
    }



    public static int[] nextGreater1Optimal(int[] nums){
        int n = nums.length;
        int[] ansArr = new int[n];
        Arrays.fill(ansArr, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            //removing elements from stack whichever smaller than curr elem
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
