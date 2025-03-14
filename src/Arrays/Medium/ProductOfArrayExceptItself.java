package Arrays.Medium;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {

    }


    //Use leftArray for prefix sum
    //Use rightArray for suffix sum
    //when calculating the value for that particular index (of num) multiple i'th prefix and suffix
    public static int[] productExceptItself(int[] nums){
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] prodArr = new int[nums.length];

        leftSum[0] = 1;
        for(int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i-1] * nums[i-1];
        }

        rightSum[nums.length-1] = 1;
        for(int j = nums.length-2; j >= 0; j--){
            rightSum[j] = rightSum[j+1] * nums[j+1];
        }

        for(int i = 0; i < nums.length; i++){
            prodArr[i] = leftSum[i] * rightSum[i];
        }
        return prodArr;
    }
}
