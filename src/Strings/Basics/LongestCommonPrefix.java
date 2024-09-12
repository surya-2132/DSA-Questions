package Strings.Basics;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str = {"flowers" , "flow" , "fly", "flight"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] str) {
        // ["flowers" , "flow" , "fly", "flight" ]
        Arrays.sort(str);   //it will be sorted alphabetically on each char wise.

        //after sorting alphabetically
        //[flight, flow, flower, fly]
        char[] firstWord = str[0].toCharArray(); //[f, l, i, g, h, t]
        char[] lastWord = str[str.length-1].toCharArray();  //[f, l, y]

        //reason we're taking last word is, whatever word present in last char
        // should also be present in first, atleast first few chars partially
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < firstWord.length; i++){
            if(firstWord[i] != lastWord[i]){
                break;
            }else{
                sb.append(firstWord[i]);    //if chars are common append into string
            }
        }
        return sb.toString();   //return as string not StringBuilder
    }
}
