package Arrays.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3, 2, 2, 3}; //op = 1 and 2
        System.out.println(majorityElement2Brute(nums));
        System.out.println(majorityElement2Better(nums));
        System.out.println(majorityElement2Optimal(nums));

    }

    public static List<Integer> majorityElement2Brute(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int currEleCount = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    currEleCount++;
                }
            }
            //checking the obtained current element count with n/2
            //do this for every ith element using outer loop.
            if(currEleCount > nums.length / 3 && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static List<Integer> majorityElement2Better(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // atleast n / 3 times should appear in arr = nums.length = 7 / 3 = 2 (atleast 2 times)
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length / 3){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static List<Integer> majorityElement2Optimal(int[] nums){
        List<Integer> list = new ArrayList<>();

        // Two potential candidates for majority elements and their respective counts
        int element1 = Integer.MIN_VALUE; // Candidate 1
        int count1 = 0;                   // Count of candidate 1

        int element2 = Integer.MIN_VALUE; // Candidate 2
        int count2 = 0;                   // Count of candidate 2

        // Step 1: Find the two potential candidates that could be the majority elements
        for(int i = 0; i < nums.length; i++){
            // If count1 is 0, assign a new candidate element1 (ensure it's not equal to element2)
            if(count1 == 0 && nums[i] != element2){
                element1 = nums[i];
                count1 = 1;
            }
            // If count2 is 0, assign a new candidate element2 (ensure it's not equal to element1)
            else if(count2 == 0 && nums[i] != element1){
                element2 = nums[i];
                count2 = 1;
            }

            else if(nums[i] == element1){
                count1++;
            }
            else if(nums[i] == element2){
                count2++;
            }

            // If current element is neither element1 nor element2, decrement both counts
            else{
                count1--;
                count2--;
            }
        }

        // Step 2: Verify if the candidates occur more than n/3 times
        int freqCount1 = 0;
        int freqCount2 = 0;

        // Count the frequency of element1 and element2 in the array
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == element1){
                freqCount1++;
            }
            if(nums[i] == element2){
                freqCount2++;
            }
        }

        int mini = nums.length / 3;

        // Add element1 to the result list if it occurs more than n/3 times
        if(freqCount1 > mini){
            list.add(element1);
        }

        // Add element2 to the result list if it occurs more than n/3 times
        // and it should not same as element1
        if(freqCount2 > mini && element1 != element2){
            list.add(element2);
        }

        return list;
    }
}
