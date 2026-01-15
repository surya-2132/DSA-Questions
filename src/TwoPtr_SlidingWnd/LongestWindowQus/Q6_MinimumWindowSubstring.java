package TwoPtr_SlidingWnd.LongestWindowQus;

public class Q6_MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minimumWindowSubStr("ddaaabbca", "abc"));
    }


    public static String minimumWindowSubStr(String s, String t){

        // Count the frequencies of characters in t -- preInserting
        int[] hash = new int[256];
        for(char ch : t.toCharArray()){
            hash[ch]++;
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int startIdx = -1;
        int endIdx = Integer.MAX_VALUE;

        // Iterate through the current window
        while(right < s.length()){

            // Include the current character in the window and reduce the value if it's 0 or not present
            if(hash[s.charAt(right)] > 0){
                count++;
            }
            hash[s.charAt(right)]--;


            // If all characters from t are found in the current window(Hash)
            while(count == t.length()){

                // Update minLen and sIndex if the current window is smaller
                if(right - left + 1 < endIdx){
                    endIdx = right - left + 1;
                    startIdx = left;
                }

                // Remove leftmost character from window
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0){
                    count--;
                }
                left++;
            }
            right++;
        }

        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + endIdx);
    }
}
