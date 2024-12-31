package StackAndQueue.FAQs;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 7, 1, 6};
        System.out.println(Arrays.toString(maxSlidingWindowOptimal(nums, 3)));
    }


    public static int[] maxSlidingWindowBrute(int[] nums, int k) {
        int max;
        List<Integer> ansList = new ArrayList<>();
        for(int i = 0; i <= nums.length - k; i++){
            max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                max = Math.max(max, nums[j]);
            }
            ansList.add(max);
        }

        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] maxSlidingWindowOptimal(int[] nums, int k) {
        List<Integer> ansList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // Remove elements from deque if they are out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index at the back of the deque
            deque.offerLast(i);

            // Start adding the maximum element to the answer list once the window is of size k
            if (i >= k - 1) {
                //noinspection DataFlowIssue
                ansList.add(nums[deque.peekFirst()]);
            }
        }

        // Convert the answer list to an array and return it
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }


}
