package Utility;

public class Operations {

    public static void swap(int[] nums, int num1, int num2){
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }

    public static int[] reverse(int[] nums, int start, int end){
        while(start <= end){
            Operations.swap(nums, start, end);
            start++;
            end--;
        }
        return nums;
    }

    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }


    public static int min(int[] nums){
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < minValue) {
                minValue = num;
            }
        }

        return minValue;
    }


    public static int sum(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }
}
