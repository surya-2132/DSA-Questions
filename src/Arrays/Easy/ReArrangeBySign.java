package Arrays.Easy;

import java.util.Arrays;

public class ReArrangeBySign {
    public static void main(String[] args) {
        int[] nums = {1, -1, -3, -4, 2, 3};
        System.out.println("rearrangeArrayBrute: " + Arrays.toString(rearrangeArrayBrute(nums)));
        System.out.println("rearrangeArrayOptimal: " + Arrays.toString(rearrangeArrayOptimal(nums)));
    }


    public static int[] rearrangeArrayBrute(int[] nums) {
        int pos = 0;
        int neg = 0;
        int i = 0;
        int[] ans = new int[nums.length];

        while(i < nums.length){

            //if curr elem is -ve run till we get +ve num
            while(pos < nums.length && nums[pos] < 0){
                ans[i++] = nums[pos++];
                pos++;
            }
            ans[i++] = nums[pos++];

            //if curr elem is +ve run till we get -ve elem
            while(neg < nums.length && nums[neg] > 0){
               neg++;
            }
            ans[i++] = nums[neg++];
        }

        return ans;
    }


    //In this approach, pos directly goes to odd indices and neg to even indices (as per qus constrains)
    public static int[] rearrangeArrayOptimal(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int pos = 0; // index for placing positive numbers
        int neg = 1; // index for placing negative numbers

        for (int num : nums) {
            if (num > 0) {
                ans[pos] = num; // place positive at even index
                pos += 2;
            } else {
                ans[neg] = num; // place negative at odd index
                neg += 2;
            }
        }

        return ans;
    }
}