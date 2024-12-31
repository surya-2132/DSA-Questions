package StackAndQueue.FAQs;

import java.util.Stack;

public class LargestAreaOfHistogram {
    public static void main(String[] args) {
        int[] nums = {3, 2, 10, 11, 5, 10, 6, 3};
        System.out.println(largestRectangleAreaOptimal(nums));
    }


    public static int largestRectangleAreaOptimal(int[] heights) {
        int currArea = 0;
        int maxArea = 0;
        int pse = 0;
        int nse = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            //Remove elements from the stack that are greater than or equal to nums[i].
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                int currIdx = stack.pop();
                pse = stack.isEmpty() ? -1: stack.peek(); //Update the index of previous smaller element
                nse = i;    //The Next smaller element index for the popped element is current index
                currArea = heights[currIdx] * (nse - pse - 1); //Calculate the area of the popped element
                maxArea = Math.max(maxArea, currArea); //Update the maximum area
            }
            stack.push(i);
        }

        //Same logic again: For elements that are not popped from stack
        while(!stack.isEmpty()){
            int currIdx = stack.pop();
            pse = stack.isEmpty() ? -1: stack.peek();
            nse = heights.length;
            currArea = heights[currIdx] * (nse - pse - 1);
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}
