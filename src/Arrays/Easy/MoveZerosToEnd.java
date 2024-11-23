package Arrays.Easy;

import Arrays.Medium.SortColors;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        pushZerosToEnd(new int[]{0, 0, 1, 0, 2, 0, 3, 0, 4, 5, 0});
    }

    public static void pushZerosToEnd(int[] nums) {
        int left = 0;
        int right = 0;

        while(right < nums.length){
            if(nums[right] != 0){
                SortColors.swap(nums, left, right);
                left++;
            }
            right++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
