package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    public static void main(String[] args) {
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        System.out.println(majorityElement_Nby2Brute(nums));
        System.out.println(majorityElement_Nby2Better(nums));
        System.out.println(majorityElement_Nby2Optimal(nums));

    }

    public static int majorityElement_Nby2Brute(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int currEleCount = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    currEleCount++;
                }
            }
            //checking the obtained current element count with n/2
            //do this for every ith element using outer loop.
            if(currEleCount > nums.length / 2){
                return nums[i];
            }
        }
        return -1;
    }

    public static int majorityElement_Nby2Better(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            //get current iterations, value and check if its > n/2, then return its key
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    //This approach uses Moore's Voting Algorithm
    public static int majorityElement_Nby2Optimal(int[] nums){
        int currElement = 0;   //will be change once we start countring from 0.
        int count = 0;

        // Applying the core Moore's voting algorithm
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                count = 1;
                currElement = nums[i];
            }
            else if(currElement == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }

        // Checking if the stored element is the majority element

        //this additional checking will be important if and only
        //if there wasn't any assurity of any majority element didn't present in array.
        int freqOfElement = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == currElement){
                freqOfElement++;
            }
        }

        // Return element if it is a majority element
        if(freqOfElement > nums.length / 2){
            return currElement;
        }
        return -1;
    }
}
