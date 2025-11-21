package BinarySearch.Easy;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Binary Search: "+ binarySearch(new int[] {0,1,2,3,4,5,6,7}, 6));
        System.out.println("lowerBound: "+ lowerBound(new int[] {0,1,2,3,4,5,6,7}, 2));
        System.out.println("upperBound: "+ upperBound(new int[] {0,1,2,3,4,5,6,7}, 6));
    }

    public static int binarySearch(int[] nums, int target){
        int low = 0; int high = nums.length;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;

            else if(nums[mid] < target) low = mid + 1;

            else high = mid - 1;
        }
        return -1;
    }

    public static int lowerBound(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        int ans = nums.length;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(target <= nums[mid]){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }


    public static int upperBound(int[] nums, int target){
        int low = 0; int high = nums.length-1;
        int ans = nums.length;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(target < nums[mid]){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

}
