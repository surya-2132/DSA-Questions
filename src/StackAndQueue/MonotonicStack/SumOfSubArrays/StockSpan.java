package StackAndQueue.MonotonicStack.SumOfSubArrays;

import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        int[] nums = {7, 2, 1, 3, 3, 1, 8};
        System.out.println(Arrays.toString(stockSpanOptimal(nums, nums.length)));
    }

    public static int[] stockSpanBrute(int[] nums){
        int[] ansArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            // To store the current span of stocks
            int currSpan = 0;

            for(int j = i; j >= 0; j--){
                //from curr elem, go backwards until we found greater or until we have smaller count++
                if(nums[j] <= nums[i]){
                    currSpan++;
                }else{
                    break;//if we found greater elem then currElem break
                }
            }
            ansArr[i] = currSpan;
        }
        return ansArr;
    }

    public static int[] stockSpanOptimal(int[] nums, int n) {
        n = nums.length;
        int[] PGE = SumOfSubArrayMaximum.previousGreaterElement(nums);
        int[] ansArr = new int[n];
        for(int i = 0; i < n; i++){
            //like we exactly found for "SubArraySumMaximum" -> leftSubArraySize
            ansArr[i] = i - PGE[i]; //from curr index to PGEelem is our span count
        }

        return ansArr;
    }
}
