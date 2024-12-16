package SlidingWindow.WindowProblems;

public class MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnes3Optimal(nums, 2));
    }


    //Brute - Generating all subArrays.
    public static int maxConsecutiveOnes3Brute(int[] nums, int k){
        int maxLen = 0, zeros;

        for(int i = 0; i < nums.length; i++){
            zeros = 0;
            for(int j = i; j < nums.length; j++){

                if(nums[j] == 0){
                    zeros++;
                }

                if(zeros <= k){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }


    //Using a sliding window while shrinking left to k sized zeros
    public static int maxConsecutiveOnes3Better(int[] nums, int k){
        //1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 and k = 2
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int zeros = 0;

        while (right < nums.length){

            if(nums[right] == 0){
                zeros++;
            }

            //whenever we violate the rule zeroes exceeds given sized k
            //we reduce zeros from our result(zeros var) until we meet the condition
            //till then we have to shrink to reduce the visited zeros iterated by right
            while(zeros > k){
                if(nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Always calculate the current subarray length if zeros exceeds k,
            // above while loop will take care
            int length = right - left + 1;
            maxLen = Math.max(maxLen, length);

            right++;
        }

        return maxLen;
    }



    //Using a sliding window while shrinking left to k sized zeros
    public static int maxConsecutiveOnes3Optimal(int[] nums, int k){
        //1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 and k = 2
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int zeros = 0;

        while (right < nums.length){

            if(nums[right] == 0){
                zeros++;
            }

            //whenever we violate the rule zeroes exceeds given sized k
            //we reduce zeros from our result(zeros var) until we meet the condition
            //till then we have to shrink to reduce the visited zeros iterated by right
            if (zeros > k){
                if(nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Always calculate the current subarray length if zeros exceeds k,
            // above while loop will take care
            int length = right - left + 1;
            maxLen = Math.max(maxLen, length);

            right++;
        }

        return maxLen;
    }
}
