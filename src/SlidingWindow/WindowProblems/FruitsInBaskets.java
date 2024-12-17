package SlidingWindow.WindowProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitsInBaskets {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(maxSubarrayWithMaxElemOfTwoBrute(fruits));
        System.out.println(maxSubarrayWithMaxElemOfTwoBetter(fruits));
    }


    //Brute Approach using for loop nested-ly + HashSet
    public static int maxSubarrayWithMaxElemOfTwoBrute(int[] fruits){

        int maxLen = 0;
        for(int i = 0; i < fruits.length; i++){

            Set<Integer> set = new HashSet<>();
            for(int j = i; j < fruits.length; j++){
                set.add(fruits[j]);
                if(set.size() <= 2){
                    int currLen = j - i + 1;
                    maxLen = Math.max(maxLen, currLen);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }


    //Optimal Approach - Using Two pointer approach + HashMap
    //Better solution can ber move a left pointer till we gwt max elem in the map as 2
    //Add while to remove elem from the left
    public static int maxSubarrayWithMaxElemOfTwoBetter(int[] fruits){
        //3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = fruits.length;
        //Map to track the count of each fruit type in the current window
        HashMap<Integer, Integer> map = new HashMap<>();

        while(right < n){
            map.put(fruits[right], map.getOrDefault(fruits[right],0) + 1);

            //If the number of different fruits exceeds 2, shrink the window from the left
            if(map.size() > 2){
                //while(map.size() > 2){ -> to make it optimal remove loop
                    map.put(fruits[left], map.get(fruits[left]) -1); //reduce freq of left elem
                    //if that left elem freq is 0, remove that elem from the map
                    if(map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                    }
                    left++;
                //}
            }

            //Again if number of different fruits is at most 2, update maxLen
            if(map.size() <= 2){
                int currLen = right - left + 1;
                maxLen = Math.max(maxLen, currLen);
            }

            right++;
        }
        return maxLen;
    }
}
