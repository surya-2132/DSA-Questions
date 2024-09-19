package Arrays.Easy;

public class MaxOccurrenceOfOnes {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1, 0, 1, 1, 1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currConsec = 0;
        int maxConse = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currConsec++;
            }else{
                maxConse = Math.max(maxConse, currConsec);
                currConsec = 0;
            }
        }
        return maxConse;
    }
}
