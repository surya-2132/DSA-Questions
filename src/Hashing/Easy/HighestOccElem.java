package Hashing.Easy;

import java.util.HashMap;
import java.util.Map;

public class HighestOccElem {
    public static void main(String[] args) {
        int[] nums = {5, 5, 4, 4, 6, 6, 6, 1};
        System.out.println("mostFrequentElement: " + mostFrequentElementBetter(nums));
        System.out.println("mostFrequentElement's Frequency: " + mostFrequentElementOptimal(nums));
    }


    //returning freq instead of elem itself
    //so that we can use this for "Sum of Highest and Lowest Frequency" problem
    public static int mostFrequentElementOptimal(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //To get max frequency(value) and min num(key if freq is same)
        //we need two variable for both key and value to compare
        //MaxValue & currValue will compare and keep track of max freq
        //maxOccElem and currKey will have number which has min number from both
        int maxFreq = Integer.MIN_VALUE;
        int maxOccElem = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int currElem = entry.getKey();
            int currFreq = entry.getValue();                   //5 > 4 so set 4 in second iteration
            if(maxFreq < currFreq || (maxFreq == currFreq && maxOccElem > currElem)){
                maxFreq = currFreq;   //update max freq (value)
                maxOccElem = currElem;          //& small numb(key) among them
            }
        }
        return maxFreq;
    }

    public static int mostFrequentElementBetter(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num: nums) max = Math.max(num, max);

        int[] hash = new int[max+1];

        for(int i = 0; i < nums.length; i++){
            hash[nums[i]]++;
        }

        int maxOccElem = -1;
        int maxFreq = 0;

        for(int i = 0; i < hash.length; i++){
            if(maxFreq < hash[i]){
                maxOccElem = i;
                maxFreq = hash[i];
            }
        }

        return maxOccElem;
    }
}
