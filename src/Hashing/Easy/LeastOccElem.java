package Hashing.Easy;

import java.util.HashMap;
import java.util.Map;

public class LeastOccElem {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,3,4,4,5,5};
        System.out.println("leastOccElem: "+leastOccElemBetter(nums));
        System.out.println("leastOccElem's Frequency: "+leastOccElemOptimal(nums));
    }

    //returning freq instead of elem itself
    //so that we can use this for "Sum of Highest and Lowest Frequency" problem
    public static int leastOccElemOptimal(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int minOccElem = Integer.MAX_VALUE;
        int minElemFreq = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int currElem = entry.getKey();
            int currFreq = entry.getValue();
            if(currFreq < minElemFreq || (currFreq == minElemFreq && minOccElem > currElem)){
                minElemFreq = currFreq;
                minOccElem = currElem;
            }
        }
        return minElemFreq;
    }


    public static int leastOccElemBetter(int[] nums) {
        int max = Integer.MIN_VALUE;

        // find max
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] hash = new int[max + 1];

        // fill hash
        for (int num : nums) {
            hash[num]++;
        }

        int elem1 = -1;
        int elem1Freq = Integer.MAX_VALUE;

        // find element with the lowest frequency (> 0)
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0 && hash[i] < elem1Freq) {
                elem1 = i;
                elem1Freq = hash[i];
            }
        }

        return elem1;
    }
}