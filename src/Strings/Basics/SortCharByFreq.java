package Strings.Basics;

import java.util.*;

public class SortCharByFreq {
    public static void main(String[] args) {
        System.out.println(frequencySort("raaajj"));
    }


    public static List<Character> frequencySort(String s) {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        //paritioning all string value into hasmap with its frequency
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        //Map can't be sorted to adding them into list to sort
        List<Map.Entry<Character, Integer>> sortCharFreqList = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Character, Integer>> valueComparator = (a, b) -> {
            int freqValueDiff = b.getValue() - a.getValue(); //b-a id dec, a-b is asc for sorting here.
            if(freqValueDiff == 0){ //if its 0 they have same frequency like 1-1=0, 2-2=0 ...
                return a.getKey().compareTo(b.getKey());
            }   //since we need asc here we're using a.compareTo(b), if desc b.compareTo(a);
            return freqValueDiff;
        };

        sortCharFreqList.sort(valueComparator);

        //adding all the keys from map to list
        for(Map.Entry<Character, Integer> uniqueCharAscFreq : sortCharFreqList){
            list.add(uniqueCharAscFreq.getKey());
        }

        return list;

//        for(int i = 0; i < sortFreqValue.size(); i++){
//            list.add(sortFreqValue.get(i).getKey());
//        }

//        for(char key : map.keySet()){
//            list.add(key);
//        }
    }
}
