package Arrays.Hard;

import java.util.Arrays;

public class RepeatingAndMissing {

    public static void main(String[] args) {
        int[] nums = {6, 5, 7, 1, 8, 6, 4, 3, 2};
        System.out.println("repeatingAndMissingBrute: " + Arrays.toString(repeatingAndMissingBrute(nums)));
        System.out.println("repeatingAndMissingBetter: " + Arrays.toString(repeatingAndMissingBetter(nums)));
        System.out.println("repeatingAndMissingOptimal: " + Arrays.toString(repeatingAndMissingOptimal(nums)));

    }

    //Using nested for TC - O(N^2) , SC -> O(1)
    public static int[] repeatingAndMissingBrute(int[] nums){

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

            // If both repeating and missing are found, break out of the loop
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
        //By default, values are 0 in a new array

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

            //once both are find out, break the loop
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        return new int[]{repeating, missing};
    }


    public static int[] repeatingAndMissingOptimal(int[] nums){
        // Size of the array
        long n = nums.length;

        long S = 0;
        long SN = (n * (n + 1)) / 2; // Sum of first n natural numbers

        long S2 = 0;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6; // Sum of squares of first n natural numbers

        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN;

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

    /* Calculate X and Y from X + Y and X - Y
       X = ((X + Y) + (X - Y)) / 2
       Y = X - (X - Y) */
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the results as [repeating, missing]
        return new int[]{(int) x, (int) y};
    }

}
