package Arrays.Medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};


    }


    //TC -> O(N^3)
    //SC -> O 2(no of triplets inset)
    public static List<List<Integer>> threeSumBrute(int[] nums){

        // Set to store unique triplets
        Set<List<Integer>> uniqueTripletSet = new HashSet<>();

        // Check all possible triplets
        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                for(int k = j + 1; k < nums.length; k++){

                    if(nums[i] + nums[j] + nums[k] == 0){
                        // Found a triplet that sums up to target
                        List<Integer> tempTriplet = Arrays.asList(nums[i], nums[j], nums[k]);

                        //Sort the triplet to ensure uniqueness when storing in set
                        Collections.sort(tempTriplet);
                        uniqueTripletSet.add(tempTriplet);
                    }


                }
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(uniqueTripletSet);
        return ans;
    }


    public List<List<Integer>> threeSumBetter(int[] nums) {
        // Set to store unique triplets
        List<List<Integer>> ansList = new ArrayList<>();
        Set<List<Integer>> tripletSet = new HashSet<>();

        // Check all possible triplets
        for (int i = 0; i < nums.length; i++) {
            // Set to store elements seen so far in the loop
            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {

                // Calculate the 3rd element needed to reach 0
                int thirdElement =  - (nums[i] + nums[j]);

                // Find if thirdElement element exists in hashset (complements seen so far)
                if (hashset.contains(thirdElement)) {
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(thirdElement);

                    //Sort the triplet to ensure uniqueness when storing in set*/
                    Collections.sort(temp);
                    tripletSet.add(temp);
                }

                // Insert the current element into hashset for future checks*/
                hashset.add(nums[j]);
            }
        }

        // Convert set to list of lists (unique triplets)
        ansList.addAll(tripletSet);
        return ansList;
    }


}
