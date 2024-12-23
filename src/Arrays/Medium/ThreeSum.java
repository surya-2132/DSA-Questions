package Arrays.Medium;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 1, -2, 2, -1, 1, 0, -2, 2, -1, 0, 1, -2, 2, 0, -1, 1, -2};
        System.out.println("Three Sum: " + threeSumOptimal(nums));
    }


    //TC -> O(N^3)
    //SC -> O 2(no of triplets in the set)
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



    //TC -> O(N^2) -> n reduced because of using complement number
    //SC -> O 2(no of triplets in set)
    public static List<List<Integer>> threeSumBetter(int[] nums) {
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

                // If we don't find 3rd elem which makes target,
                // insert the current j'th elem into hashset for future checks
                hashset.add(nums[j]);
            }
        }

        // Convert set to list of lists (unique triplets)
        ansList.addAll(tripletSet);
        return ansList;
    }


    //TC -> O(n x log n) + O(n^2)
    //SC -> O(1)
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();

        // Sort the array to use two-pointer approach
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            // Two-pointer approach
            while (left < right) {
                // Can use long for sub declaration to avoid integer overflow
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++; // Move a left pointer to increase the sum
                } else if (sum > 0) {
                    right--; // Move a right pointer to decrease the sum
                } else {
                    // Found a valid triplet
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ansList.add(list);
                    left++;
                    right--;

                    // Skip duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }

        return ansList;
    }



}
