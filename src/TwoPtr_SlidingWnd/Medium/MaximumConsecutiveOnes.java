package TwoPtr_SlidingWnd.Medium;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println("maximumConsecOnes_i : " + maximumConsecOnes_i(nums));
        System.out.println("maximumConsecOnes_ii -> 2 flips: " + maximumConsecOnes_ii(nums));
        System.out.println("maximumConsecOnes_iii -> k flips: " + maximumConsecOnes_iii(nums, 2));
    }


    public static int maximumConsecOnes_i(int[] nums){
        int currConsec = 0;
        int maxConsec = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currConsec++;
            }
            else{
                maxConsec = Math.max(maxConsec, currConsec);
                currConsec = 0;
            }
        }
        return maxConsec;
    }


    //exactly as same as maxConsecOnes_iii here just two flips instead of k
    public static int maximumConsecOnes_ii(int[] nums){
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
            if(zeros > 2){
                if(nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Always calculate the current subarray length if zeros exceeds k, above while loop will take care
            if(zeros <= 2){
                int length = right - left + 1;
                maxLen = Math.max(maxLen, length);
            }

            right++;

        }
        return maxLen;
    }


    //1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 and k = 2
    public static int maximumConsecOnes_iii(int[] nums, int k){
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
            if(zeros > k){
                if(nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Always calculate the current subarray length if zeros exceeds k, above while loop will take care
            if(zeros <= k){
                int length = right - left + 1;
                maxLen = Math.max(maxLen, length);
            }

            right++;

        }
        return maxLen;
    }
}
