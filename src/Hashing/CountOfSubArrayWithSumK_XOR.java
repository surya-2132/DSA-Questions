package Hashing;

public class CountOfSubArrayWithSumK_XOR {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 2, 6, 4};
        System.out.println(subArraySumXOR_Better(nums, 6));
    }

    public static int subArraySumXOR_Brute(int[] nums, int target){

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum = sum ^ nums[k];
                }
                if(sum == target){
                    count++;
                }
            }
        }
        return count;
    }

    public static int subArraySumXOR_Better(int[] nums, int target){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum = sum ^ nums[j];
                if(sum == target){
                    count++;
                }
            }
        }
        return count;
    }
}
