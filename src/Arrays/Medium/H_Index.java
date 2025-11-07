package Arrays.Medium;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        System.out.println(hIndexBrute(new int[]{0, 1, 3, 5, 6}));
    }

    /* “If I have 3 papers that each got at least 3 citations, then my h-index is at least 3.”
    citations = [3, 0, 6, 1, 5]
    If we sort it, we get: sorted_array = [0, 1, 3, 5, 6]
    Now, start checking from the right (highest citations):
    6 → yes (that’s 1 paper with ≥1 citation) → h = 1
    5 → yes (2 papers with ≥2) → h = 2
    3 → yes (3 papers with ≥3) → h = 3
    1 → no (only 3 papers with ≥4)
    So the answer is 3, because we have 3 papers with at least 3 citations each. */
    public static int hIndexBrute(int[] citations) {
        Arrays.sort(citations); //-> 0, 1, 3, 5, 6
        int hIndex = 0;
        for(int i = citations.length-1; i >= 0; i--){
            if(citations[i] > hIndex){
                hIndex++;
            }
            else{
                break;
            }
        }
        return hIndex;
    }
}