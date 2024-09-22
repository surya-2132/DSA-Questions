package Arrays.Hard;

public class RepeatingAndMissing {

    public static void main(String[] args) {

    }

    //Using nested for TC - O(N^2) , SC -> O(1)
    public static int[] repeatingAndMissing(int[] nums){

        int repeating = -1;
        int missing = -1;

        // Find the repeating and missing number:
        //i is actually a number like 1, 2, 3, 4, 5, 6, ...
        for(int i = 1; i <= nums.length; i++){
            int count = 0;
            // Count the occurrences of current i
            for(int j = 0; j < nums.length; j++){
                if(i == nums[j]){   //checking i number(which is in order to current array number arr[j] )
                    count++;
                }
            }

            // Check if i is repeating or missing
            if(count == 2){
                repeating = i;
            } else if (count == 0) {
                missing = i;
            }

            // If both repeating and missing are found, break out of loop
            if(repeating != -1 && missing != -1){
                break;
            }
        }
        return new int[]{repeating, missing};
    }

    //Using Hashing Technique TC - O(N + N) , SC -> O(N)
    public static int[] repeatingAndMissingBetter(int[] nums) {
        // 6, 5, 7, 1, 8, 6, 4, 3, 2
        int[] hashArray = new int[nums.length + 1];
        //By default values are 0 in a new array

        // for(int i = 0; i < hashArray.length; i++){
        //     hashArray[i] = 0;
        // }

        for (int i = 0; i < nums.length; i++) {
            hashArray[nums[i]]++;
        }

        int repeating = -1;
        int missing = -1;
        //we will check each ele in hashArray which will have only one 2 and one 0
        for (int i = 1; i < hashArray.length; i++) {
            if (hashArray[i] == 2) {
                repeating = i;
            } else if (hashArray[i] == 0) {
                missing = i;
            }

            //once both are find out break the loop
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        return new int[]{repeating, missing};
    }
}
