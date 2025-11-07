package SlidingWindow.CountingSubsProblem;

import java.util.HashMap;

public class CountNoOf_ABC_SubsInGivenStr {
    public static void main(String[] args) {
        String str = "abcccbab";
        System.out.println(countSubsOptimal(str));
    }

    public static int countSubsBrute(String str){
        int totalSubs = 0;
        for(int i = 0; i < str.length(); i++){

            HashMap<Character, Integer> map = new HashMap<>();

            for(int j = i; j < str.length(); j++){
                char ch = str.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if(map.size() == 3){
                    totalSubs += (str.length() - j);
                    break;
                }
            }
        }
        return totalSubs;
    }


    public static int countSubsOptimal(String s) {

        int totalSubArrays = 0;   //0a, 1b, 2c
        int[] lastSeenCharIndex = {-1, -1, -1}; //-1 indicates that char is neven seen yet

        for(int i = 0; i < s.length(); i++){
            //NOTE: a-a = 0, b-a = 1, c-a = 2
            lastSeenCharIndex[s.charAt(i) - 'a'] = i;   //update curr char index everytime to calculate curr subarray lengths

            if(lastSeenCharIndex[0] != -1 && lastSeenCharIndex[1] != -1 && lastSeenCharIndex[2] != -1){
                //curr total + Min index among (a, b, c) + 1 -> NOTE: +1 is like (right - left + 1) in reverse
                totalSubArrays = totalSubArrays
                        + (Math.min(Math.min(
                                lastSeenCharIndex[0],
                                lastSeenCharIndex[1]),
                                lastSeenCharIndex[2]) + 1);
            }
        }

        return totalSubArrays;
    }
}
