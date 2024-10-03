package Arrays.Medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums){
        //1, 0, 2, 1, 0
        int start = 0;
        int mid = 0;
        int end = nums.length-1;

        while(mid <= end){

            switch(nums[mid]){
                case 0:
                    swap(nums, start, mid);
                    start++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int num1, int num2){
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}
