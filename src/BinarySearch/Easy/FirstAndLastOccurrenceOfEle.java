package BinarySearch.Easy;

import java.util.Arrays;

public class FirstAndLastOccurrenceOfEle {
    public static void main(String[] args) {
        //Brute force
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(firstAndLastOccBrute(nums, 8)));

        //using bound
        System.out.println(Arrays.toString(occurrenceBound(nums, 8)));

        //Using Binary Search
        int[] ans = {-1, -1};
        int first = occurrenceBS(nums, 8, true);
        int last = occurrenceBS(nums, 8, false);
        ans[0] = first;
        ans[1] = last;
        System.out.println(Arrays.toString(ans));

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


    //using bound
    public static int[] occurrenceBound(int[] nums, int target){
        int firstOcc = LowerBound.lowerBound(nums, target);
        //if we don't find the target in the array while searching with lower bound return -1
        if(firstOcc == nums.length || nums[firstOcc] != target) return new int[]{-1, -1};
        int lastOcc = UpperBound.upperBound(nums, target);
        return new int[]{firstOcc, lastOcc-1};
    }


    //using binary search
    public static int occurrenceBS(int[] nums, int target, boolean isFirstOccurrence){
        int low = 0;
        int high = nums.length-1;
        int returnIndex = -1;

        //normal binary search
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < target){
                low = mid  + 1;
            }
            else if (nums[mid] > target){
                high = mid - 1;
            }
            else{
                returnIndex = mid; //to find 1st occurrence we do nested BS instead of "return mid"
                if(isFirstOccurrence){
                    //firstOccurrence always lies on the left, so end = mid -1
                    high = mid -1;
                }
                else{
                    //to find second occurrence
                    low = mid + 1;
                }
            }
        }

        return returnIndex;
    }

}
