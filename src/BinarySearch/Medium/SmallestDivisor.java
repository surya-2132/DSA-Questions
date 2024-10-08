package BinarySearch.Medium;

public class SmallestDivisor {

    public static void main(String[] args) {
        int[] nums = {8,4,2,3};
        System.out.println(smallestDivisorBrute(nums, 10));
        System.out.println(smallestDivisorOptimal(nums, 10));
    }

    public static int smallestDivisorBrute(int[] nums, int threshold){
        int max = max(nums);

        for(int divisor = 1; divisor <= max; divisor++){
            int sum = 0;

            for(int j = 0; j < nums.length; j++){
                sum += (int) Math.ceil((double) (nums[j]) / (double) divisor);
            }
            if(sum <= threshold){
                return divisor;
            }
        }
        return -1;
    }

    public static int smallestDivisorOptimal(int[] nums, int threshold){
        int low = 1;
        int high = max(nums);
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(sumOfDivisor(nums, mid) <= threshold){
                high = mid - 1;
            }
            else {
                low = mid + 1;
                ans = low;
            }
        }
        return ans; //low can also be returned

    }

    public static int sumOfDivisor(int[] nums, int div){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += (int) Math.ceil((double) nums[i] / (double) div);
        }
        return sum;
    }

    public static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}
