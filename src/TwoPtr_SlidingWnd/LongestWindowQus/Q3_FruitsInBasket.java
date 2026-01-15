package TwoPtr_SlidingWnd.LongestWindowQus;

import java.util.HashMap;

public class Q3_FruitsInBasket {
    public static void main(String[] args) {
        System.out.println(fruitsInBasket(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public static int fruitsInBasket(int[] fruits){
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
                // while(map.size() > 2){ -> to make it optimal remove loop

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