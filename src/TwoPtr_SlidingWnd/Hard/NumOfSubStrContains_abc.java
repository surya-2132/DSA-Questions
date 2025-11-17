package TwoPtr_SlidingWnd.Hard;

public class NumOfSubStrContains_abc {
    public static void main(String[] args) {
        System.out.println(abcSubStr("abcba"));
        System.out.println(abcSubStrOptimal("abcba"));
    }

    public static int abcSubStr(String s){

        int totalSUbStr = 0;
        for(int i = 0; i < s.length(); i++){
            int[] hash = new int[3];

            for(int j = i; j < s.length(); j++){
                hash[s.charAt(j) - 'a'] = 1;

                if(hash[0] + hash[1] + hash[2] == 3){
                    totalSUbStr++;
                }
            }
        }

        return totalSUbStr;
    }

    public static int abcSubStrOptimal(String s){

        //Array to store the last seen index of characters 'a', 'b', 'c'
        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        // Iterate through each character in string str
        for (int i = 0; i < s.length(); ++i) {

            // Update lastSeen index
            lastSeen[s.charAt(i) - 'a'] = i;

            // Check if all characters 'a','b', 'c' have been seen
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {

                // Count valid substrings ending at current index
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }

        return count;
    }

}