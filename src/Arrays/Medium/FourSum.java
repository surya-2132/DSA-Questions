package Arrays.Medium;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSumBrute(int[] nums, int target) {

        Set<List<Integer>> uniqueQuadSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                for(int k = j + 1; k < nums.length; k++){

                    for(int l = k + 1; l < nums.length; l++){

                        if(nums[i] + nums[j] + nums[k] + nums[l] == target){
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);

                            Collections.sort(list);
                            uniqueQuadSet.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(uniqueQuadSet);
    }

    public List<List<Integer>> fourSumBetter(int[] nums, int target) {

        List<List<Integer>> ansList = new ArrayList<>();
        Set<List<Integer>> quadSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            for(int j = i + 1; j < nums.length; j++){

                Set<Integer> set = new HashSet<>();

                for(int k = j + 1; k < nums.length; k++){

                    int fourthElement = target - (nums[i] + nums[j] + nums[k]);

                    if(set.contains(fourthElement)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(fourthElement);

                        //Sort the quadruplet to ensure uniqueness when storing in set*/
                        Collections.sort(temp);
                        quadSet.add(temp);
                    }
                    set.add(nums[k]);
                }
            }
        }

        ansList.addAll(quadSet);
        return ansList;
    }

}
