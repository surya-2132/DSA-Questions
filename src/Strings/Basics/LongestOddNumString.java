package Strings.Basics;

public class LongestOddNumString {
    public static void main(String[] args) {

        System.out.println("longestOddNumString is : "+longestOddNumString("02146388"));

    }

    public static String longestOddNumString(String str){
        //02146388
        //first odd number from the end using reverse loop,
        //if we find out store that index in a variable
        int lastOddIdx = 0;
        int i;
        for(i = str.length()-1; i >= 0; i--){
            if((str.charAt(i) - '0') % 2 != 0){
                lastOddIdx = i;
                break;
            }
        }

        //if we don't find any odd num return empty string
        if(lastOddIdx == 0){
            return "";
        }

        //reassign i = 0 to loop from beginning,
        //while iteration i should not cross lastOddIndex,
        //and also it should loop until it meet non-zero value. if it's find int value break
        i = 0;
        while(i <= lastOddIdx && str.charAt(i) == '0'){
            i++;
        }
        //return first non-zero value and lastOddIndex value which is our longest odd num
        return str.substring(i, lastOddIdx+1);
    }
}
