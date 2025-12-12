package Hashing.Easy;

import java.util.HashMap;
import java.util.Map;

public class SecondHighestOccElem {

    public static void main(String[] args) {
        int[] nums = {4, 4, 5, 5, 6, 7};
        System.out.println("secondMostFrequentElementBetter: " + secondMostFrequentElementBetter(nums));
        System.out.println("secondMostFrequentElementOptimal: " + secondMostFrequentElementOptimalMine(nums));
    }

    //Gemini solution, Not sure why mine isn't correct
    public static int secondMostFrequentElementOptimal(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Initialize Max
        int maxFreq = 0;
        int maxOccElem = Integer.MAX_VALUE; // Start with MAX so any real number is smaller

        // Initialize Second Max
        int secondMaxFreq = 0;
        int secondMaxOccElem = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currElem = entry.getKey();
            int currFreq = entry.getValue();

            // 1. Check if current is better than the Number 1 spot
            // Condition: Higher Freq OR (Same Freq AND Smaller Value)
            boolean isBetterThanMax = (currFreq > maxFreq) ||
                    (currFreq == maxFreq && currElem < maxOccElem);

            if (isBetterThanMax) {
                // Demote current Max to Second Max
                secondMaxFreq = maxFreq;
                secondMaxOccElem = maxOccElem;

                // Update New Max
                maxFreq = currFreq;
                maxOccElem = currElem;
            }

            // 2. If not better than Max, check if it's better than Number 2 spot
            else {
                // Condition: Higher Freq than 2nd OR (Same Freq as 2nd AND Smaller Value)
                boolean isBetterThanSecond = (currFreq > secondMaxFreq) ||
                        (currFreq == secondMaxFreq && currElem < secondMaxOccElem);

                // IMPORTANT: We must ensure this 'candidate' isn't actually the 'max' itself
                // (Though map keys are unique, conceptually we are comparing logic)
                // In your specific bug, you blocked cases where currFreq == maxFreq.
                // We MUST allow currFreq == maxFreq here, because if we have {1:5, 2:5},
                // 1 is Max, 2 is Second Max.

                if (isBetterThanSecond) {
                    secondMaxFreq = currFreq;
                    secondMaxOccElem = currElem;
                }
            }
        }

        // Return -1 (or appropriate value) if no second frequent element exists
        if (secondMaxFreq == 0) return -1;

        return secondMaxOccElem;
    }

    public static int secondMostFrequentElementOptimalMine(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int maxOccElem = Integer.MIN_VALUE;

        int secondMaxFreq = Integer.MIN_VALUE;
        int secondMaxOccElem = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int currElem = entry.getKey();
            int currFreq = entry.getValue();

            if(maxFreq < currFreq || (maxFreq == currFreq && maxOccElem > currElem)){
                secondMaxOccElem = maxOccElem;
                secondMaxFreq = maxFreq;

                maxFreq = currFreq;
                maxOccElem = currElem;
            }
            //in-case we met an array where 7, 7, 5, 5, 6, 6
            //without this condition -> && currElem < secondMaxOccElem 5 will update as secondMaxFreq
            //rest conditions are like if currFeq is less than max but greater than second, update secondMaxFreq
            else if((currFreq < maxFreq) && (secondMaxFreq < currFreq ||
                    (currFreq == secondMaxFreq && currElem < secondMaxOccElem))){
                secondMaxOccElem = currElem;
                secondMaxFreq = currFreq;
            }
        }

        return secondMaxOccElem;
    }


    public static int secondMostFrequentElementBetter(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num: nums) max = Math.max(num, max);

        int[] hash = new int[max+1];

        for(int i = 0; i < nums.length; i++){
            hash[nums[i]]++;
        }

        int elem1 = -1;
        int elem2 = -1;
        int maxFreq1 = 0;
        int maxFreq2 = 0;

        //hash[i] contains the freq of the respective number,
        //i is the actual element since we created 0 to max+1 index based array
        for(int i = 0; i < hash.length; i++){
            if(maxFreq1 < hash[i]){
                elem2 = elem1; //we got new max freq, so assign curr freq to second, then make new max freq to first
                elem1 = i;

                maxFreq2 = maxFreq1;
                maxFreq1 = hash[i];
            }
            //if curr elem is greater than 2 but smaller than first, just directly update second alone
            else if (hash[i] > maxFreq2 && hash[i] < maxFreq1) {
                // update only second best
                elem2 = i;
                maxFreq2 = hash[i];
            }
        }

        return elem2;
    }
}
