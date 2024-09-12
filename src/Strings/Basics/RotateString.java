package Strings.Basics;

public class RotateString {
    public static void main(String[] args) {

    }

   public static boolean rotateStringBrute(String str, String goal){
        if(str.length() != goal.length()){
            return false;
        }
        //0 1 2 3 4 5 6 -> index
        //a b c d e f g -> chars
        for(int i = 0; i < str.length(); i++){
            String rotated = str.substring(i) + str.substring(0, i);
            if(rotated.equals(goal)){
                return true;
            }
        }
        //iteration 1 i = 0 -> a b c d e f g -> defgabc ? no false.
        //iteration 2 i = 1 -> b c d e f g + a -> bcdefga == defgabc ? no false.
        //iteration 3 i = 2 -> c d e f g + a b -> cdefgab == defgabc ? no false.
        //iteration 4 i = 3 -> d e f g + a b c -> defgabc == defgabc ? yes true
       return false;
   }


    public static boolean rotateStringOptimal(String str, String goal){
        if(str.length() != goal.length()){

            return false;
        }
        //str + str = acbdefgabcdefg -> contaibs methods checks internally (AKA robin karp algo)
        String doubledStr = str + str;
        return doubledStr.contains(goal);
    }
}
