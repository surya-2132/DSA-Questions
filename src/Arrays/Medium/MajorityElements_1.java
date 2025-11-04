package Arrays.Medium;

import Utility.Operations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElements_1 {
    public static void main(String[] args) {
        int[] nums = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 7, 7, 7};
        System.out.println(majorityElementOptimal(nums));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 9)));
    }


    public static int majorityElementBrute(int[] nums){
        //7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], map.getOrDefault(nums[i], 1));
            }
        }

        int majorityElement = nums.length/2;
        int majority = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > majorityElement){
                majority = entry.getKey();
                break;
            }
        }
        return majority;
    }


    public static int majorityElementOptimal(int[] nums){
        //7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5
        int elem = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(count == 0){
                elem = nums[i];
                count = 1;
            } else if (elem == nums[i]){
                count++;
            } else{
              count--;
            }
        }

        int count1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(elem == nums[i]){
                count1++;
            }
        }

        return (count1 > nums.length / 2) ? elem : -1;
    }


    public static int[] rotateArray(int[] nums, int kTimes){

        if(kTimes > nums.length){
            kTimes = kTimes % nums.length;
        }

        int[] array = reverse(nums, 0, nums.length-1);
        reverse(array, 0, kTimes-1);
        reverse(array, kTimes, nums.length-1);
        return array;
    }

    public static int[] reverse(int[] nums, int start, int end){
        while(start <= end){
            Operations.swap(nums, start, end);
            start++;
            end--;
        }
        return nums;
    }
}
