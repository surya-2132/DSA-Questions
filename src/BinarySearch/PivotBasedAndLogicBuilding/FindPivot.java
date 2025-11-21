package BinarySearch.PivotBasedAndLogicBuilding;

public class FindPivot {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println("Pivot: " + findPivot(nums));
    }

    public static int findPivot(int[] nums){
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            //case 1 where middle is 0 which is 7 > 0
            if(low < mid && nums[mid-1] > nums[mid]){
                return mid-1;
            }

            //case 1 where middle is 7 which is 7 > 0
            if(mid < high && nums[mid] > nums[mid+1]){
                return mid; //if pivot is lastElement-1,then IndexOutOfBound so mid < end
            }

            //case 3 where middle is 0(lowest)
            if(nums[low] >= nums[mid]){  //4 >= 0 then create new END from previous(0) mid
                high = mid - 1;
            }

            //case 4 where middle is 7(greatest)
            if(nums[low] <= nums[mid]){
                low = mid + 1; //7 >= 0 then create new START from previous(6) mid
            }
        }
        return -1;
    }
}