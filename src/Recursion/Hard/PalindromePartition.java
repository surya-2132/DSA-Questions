package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        System.out.println(partition("aabaa"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ansList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        recPalindrome(0, s, list, ansList, s.length());
        return ansList;
    }

    public static void recPalindrome(int index, String str, List<String> list, List<List<String>> ansList, int n){
        if(index == n){
            ansList.add(new ArrayList<>(list));
            return;
        }

        for(int j = index; j < n; j++){
            if(isPalindrome(str, index, j)){
                String currSubString = str.substring(index, j + 1);
                list.add(currSubString);
                recPalindrome(j + 1, str, list, ansList, n);
                list.removeLast();
            }
        }
    }

    public static boolean isPalindrome(String str, int left, int right){
        while(left <= right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
