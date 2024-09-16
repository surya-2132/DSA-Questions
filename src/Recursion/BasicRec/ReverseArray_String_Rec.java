package Recursion.BasicRec;

import java.util.Vector;

public class ReverseArray_String_Rec {
    public static void main(String[] args) {
        Vector<Character> s = new Vector<>();
        //s.add('m'); s.add('a'); s.add('l'); s.add('a'); s.add('y'); s.add('a'); s.add('l'); s.add('a'); s.add('m');
        s.add('s'); s.add('u'); s.add('r'); s.add('y'); s.add('a');
        System.out.println(reverseStringRec(s));

        System.out.println("palindrome: "+palindrome("malayalam"));
        System.out.println("palindromeReverse: "+palindromeReverse("malayalam"));
    }

    //Reverse a string using recursion - Data Structure is Vector
    public static Vector<Character> reverseStringRec(Vector<Character> str){
        int start = 0;
        int end = str.size()-1;
        reverse(str, start, end);
        return str;
    }
    private static void reverse(Vector<Character> str, int start, int end){
        //we usually use while(start <= end) to continue the loop, to break use inversely here
        if(start >= end){
            return;
        }

        //swap logic
        char startChar = str.get(start);
        char endChar = str.get(end);
        str.set(start, endChar);
        str.set(end, startChar);

        //start + 1 not start++
        //start + 1 is a temporary value, keeping start unchanged.
        //start++ modifies start, but not until after the current call,
        reverse(str, start + 1, end - 1);
    }


    //Method 1 -> just checking char from left and right parellely -> more efficient
    public static boolean palindrome(String str){
        return isPalindrome(str, 0, str.length()-1);
    }
    private static boolean isPalindrome(String str, int left, int right){
        //if its crosses left which means no mismatched char found in between.
        if(left >= right){
            return true;
        }
        //if any char miss matched
        if(str.charAt(left) != str.charAt(right)){
            return false;
        }
        //recursion call -> start + 1 not start++
        return isPalindrome(str, left + 1, right - 1);
    }


    //Method 2 -> reverse the string using recursion and check its equal or not after reverse
    public static boolean palindromeReverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        reverseUsingBuilder(s, 0, s.length()-1);
        return s.contentEquals(sb);
    }
    private static void reverseUsingBuilder(String str, int start, int end){
        if(start >= end){
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        char sChar = sb.charAt(start);
        char eChar = sb.charAt(end);
        sb.setCharAt(start, sChar);
        sb.setCharAt(end, eChar);

        //recursion call -> start + 1 not start++
        reverseUsingBuilder(sb.toString(), start + 1, end - 1);
    }


}
