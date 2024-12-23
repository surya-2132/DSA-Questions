package Arrays.Medium;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {2, -1, 0, 1, -2, 2, -1, 1, 0, -2, 2, -1, 0, 1, -2, 2, 0, -1, 1, -2};
        System.out.println("Four Sum: " + fourSumBetter(nums, 4));
    }


    //TC -> O(N^4)
    //SC -> O 2(no of quadruplet in set)
    public static List<List<Integer>> fourSumBrute(int[] nums, int target) {

        // Set to store unique quadruplet
        Set<List<Integer>> uniqueQuadSet = new HashSet<>();

        // Check all possible quadruplets
        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                for(int k = j + 1; k < nums.length; k++){

                    for(int l = k + 1; l < nums.length; l++){

                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            // Found a quadruplet that sums up to target
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);

                            //Sort the quadruplet to ensure uniqueness when storing in the set
                            Collections.sort(list);
                            uniqueQuadSet.add(list);
                        }
                    }
                }
            }
        }

        // Return set to list of lists (unique quadruplet)
        return new ArrayList<>(uniqueQuadSet);
    }


    
    //TC -> O(N^3) -> n reduced because of using complement number
    //SC -> O 2(no of quadruplet in the set)
    public static List<List<Integer>> fourSumBetter(int[] nums, int target) {

        List<List<Integer>> ansList = new ArrayList<>();
        Set<List<Integer>> quadSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                Set<Integer> set = new HashSet<>();

                for(int k = j + 1; k < nums.length; k++){

                    // Calculate the 4th element needed to reach target
                    int fourthElement = target - (nums[i] + nums[j] + nums[k]);

                    // Find if fourthElement element exists in hashset (complements seen so far)
                    if(set.contains(fourthElement)){
                        // Found a quadruplet that sums up to target
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(fourthElement);

                        //Sort the quadruplet to ensure uniqueness when storing in set*/
                        Collections.sort(temp);
                        quadSet.add(temp);
                    }

                    // If we don't find 4th elem which makes target,
                    // insert the current k'th elem into hashset for future checks
                    set.add(nums[k]);
                }
            }
        }

        // Convert set to list of lists (unique quadruplet)
        ansList.addAll(quadSet);
        return ansList;
    }


    //TC -> O(n x log n) + O(n^3) and SC -> O(1)
    // Do it later
    // Same approach like 3SUm with pointer adjustment according to 4Sum
    // public static List<List<Integer>> threeSumOptimal(int[] nums) {}

}
