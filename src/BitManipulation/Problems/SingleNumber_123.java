package BitManipulation.Problems;

import java.util.*;

public class SingleNumber_123 {
    public static void main(String[] args) {
        int[] singleNumberOne = {1, 2, 2, 4, 3, 1, 4};
        int[] singleNumberTwo = {1, 0, 3, 0, 1, 1, 3, 3, 10, 0};
        int[] singleNumberThree = {1, 9, 1, 2, 8, 2};
        System.out.println(("Single number one: "+ singleNumber_12_Brute(singleNumberOne)));
        System.out.println(("Single number two: "+ singleNumber_12_Brute(singleNumberTwo)));
        System.out.println("Single number three: "+ singleNumber_3_Brute(singleNumberThree));
    }

    public static int singleNumber_12_Brute(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }


    // Unlike single number 1 and 2, here we have 2 single numbers,
    // except these two numbers; others appear exactly twice, return in asc order
    public static List<Integer> singleNumber_3_Brute(int[] nums){

        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1); // Update the map
        }

        // Iterate on the map
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            // If frequency is 1
            if (entry.getValue() == 1) {
                /* Add the element to
                the result array */
                ans.add(entry.getKey());
            }
        }

        // Return the result after sorting
        Collections.sort(ans);
        return ans;
    }



    //Optimal solutions - Yet to find
   /* public int singleNumberOneOptimal(int[] nums) {

    }

    public int singleNumberTwoOptimal(int[] nums) {

    }

    public int singleNumberThreeOptimal(int[] nums) {

    }*/

}
