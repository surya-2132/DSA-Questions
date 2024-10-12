package BinarySearch.Easy;

import java.util.Arrays;

public class FirstAndLastOccurrenceOfEle {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(firstAndLastOccBrute(nums, 8)));
    }

    public static int[] firstAndLastOccBrute(int[] nums, int target){
        //[5, 7, 7, 8, 8, 10]

        int first = -1;
        int second = -1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                if(first == -1){
                    first = i;
                }
                second = i;
            }
        }
        return new int[]{first, second};
    }
}
