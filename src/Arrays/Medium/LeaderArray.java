package Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};
        System.out.println(leaders(nums));
    }

    public static ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int right = nums.length-1;
        int left = nums.length-2;

        arrayList.add(nums.length);
        while(left >= 0){
            if(nums[left] > nums[right]){
                arrayList.add(nums[left]);
                right = left;
            }
            left--;
        }

        Collections.reverse(arrayList); // efficient
        //arrayList.sort(Collections.reverseOrder());   //not efficient since sorting is O(N log N)
        return arrayList;
    }
}
