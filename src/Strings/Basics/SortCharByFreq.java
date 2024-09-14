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

    //KthMostOccurringElement
    public static int KthMostFrequentElement(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> sortFreqList = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> freqValueComparator = (a, b) -> {
            int freqValue = b.getValue() - a.getKey();
            if(freqValue == 0){
                return a.getKey() - b.getKey();
            }
            return freqValue;
        };
        sortFreqList.sort(freqValueComparator);

        int freqCount = 1;
        int maxFreq = sortFreqList.get(0).getValue();   //sortFreqList.getFirst().getValue() first map's value in arraylist.
        for(int i = 1; i < sortFreqList.size(); i++){
            if(sortFreqList.get(i).getValue() < maxFreq){
                maxFreq = sortFreqList.get(i).getKey();
                freqCount++;
            }

            if(freqCount == k){
                return sortFreqList.get(i).getKey();
            }
        }
        return -1;
    }
























    public static int secondMostFrequentElementOrg(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //this is list of hashmap's entry -> [4, 4, 5, 5, 6, 7] list ->[
        //        {4 -> 2}, {5 -> 2}, {6 -> 1}, {7 -> 1} ->
        //    ]
        // Step 2: Convert map entries to a list and sort them by frequency and then by element
        List<Map.Entry<Integer, Integer>> sortFreqList = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<Integer, Integer>> freqValueComparator = (a, b) -> {
            int freqValue = b.getValue() - a.getValue();    //sorting values in desc
            if(freqValue == 0){     //if values are same, sorting keys in asc
                return a.getKey().compareTo(b.getKey());
            }
            return freqValue;
        };
        sortFreqList.sort(freqValueComparator);

        // Step 3: Handle edge cases and return the second most frequent element
        if (sortFreqList.size() < 2) {
            // If there are fewer than 2 unique elements, there is no second most frequent element
            return -1;
        }

        // Check the first and second elements in the sorted list
        int maxFrequency = sortFreqList.get(0).getValue();
        for (int i = 1; i < sortFreqList.size(); i++) {
            if (sortFreqList.get(i).getValue() < maxFrequency) {
                // If the current element's frequency is less than the highest frequency, it's the second most frequent
                return sortFreqList.get(i).getKey();
            }
        }

        // If all elements have the same frequency, there is no second most frequent element
        return -1;
    }

}
