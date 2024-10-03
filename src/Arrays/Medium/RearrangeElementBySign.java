package Arrays.Medium;

import java.util.Arrays;

public class RearrangeElementBySign {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, -4, -5};
        System.out.println(Arrays.toString(rearrangeArrayOptimal(nums)));
    }


    public static int[] rearrangeArrayOptimal(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;

        //3,1,-2,-5,2,-4
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;  //0, 2, 4, 6, 8, 10
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;  //1, 3, 5, 7, 9, 11
            }
        }

        return ans;
    }


    public static int[] rearrangeArrayBrute(int[] nums){
        //int[] A = {1, 2, -4, -5};
        int[] pos = new int[nums.length/2]; int p = 0;
        int[] neg = new int[nums.length/2]; int n = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pos[p++] = nums[i];
            }else{
                neg[n++] = nums[i];
            }
        }

        //pos will be in 0, 2, 4, 6, 8 even indices
        //neg will be in 1, 3, 5, 7, 9 odd indices
        for(int i = 0; i < nums.length/2; i++){
            nums[2*i] = pos[i];
            nums[2*i+1] = neg[i];
        }

        return nums;
    }


    public int[] rearrangeArrayBetter(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0;    //positive integer pointer
        int neg = 0;    //negative integer pointer
        int i = 0;      //original array pointer

        while(i < nums.length){

            //run untill you find next pos number
            while(pos < nums.length && nums[pos] < 0){
                pos++;
            }
            ans[i++] = nums[pos++]; //once found add it to ans and move pos and i pointer

            //run untill you find next neg number
            while(neg < nums.length && nums[neg] > 0){
                neg++;
            }
            ans[i++] = nums[neg++]; //once found add it to ans and move neg and i pointer
        }

        return ans;
    }
}
