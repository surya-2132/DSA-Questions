package Arrays.Easy;

public class SecondLargestAndSmallest {
    public static void main(String[] args) {
        int[] nums = {7, 9, 1, 7, 0, 2, 2, 10, 10, 10, 8};
        System.out.println("Second Largest: " + secondLargestOptimal(nums));
        System.out.println("Second Smallest: " + secondSmallest(nums));

    }

    //Finding in two pass -> O(2N)
    public static int secondLargestBrute(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    //Finding in single pass -> O(N)
    public static int secondLargestOptimal(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] < largest && nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }

        return secondLargest;
    }


    //Finding in single pass -> O(N)
    public static int secondSmallest(int[] nums){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            }
            else if(nums[i] != smallest && nums[i] < secondSmallest){
                secondSmallest = nums[i];
            }
        }

        return secondSmallest;
    }
}
