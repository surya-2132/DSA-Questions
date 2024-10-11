package BinarySearch.Hard;

public class SplitArrayLargestSum_BookAllocation {
    // Return the minimized largest sum of the split.
    // Allocate the books to m students in such a way that
    // the maximum number of pages assigned to a student is minimized.
    // If the allocation of books is not possible, return -1.

    // Similar problem - Painters Partition
    // Do partition of an array with given k,
    // And find out the max on in way if it makes possible to distribute the k
    //Example: [10] [20, 30, 40] is 90, [10, 20] [30, 40] is 70, [10, 20, 30] [40] is 60
    //Such that it's a minimized largest sum -> min(max)

    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        System.out.println(findPages(nums, 2));
    }

    public static int findPages(int[] nums, int totalStudent) {

        if(totalStudent > nums.length) return -1;
        int low = maximum(nums);
        int high = sumOfAnArray(nums);

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(countStudents(nums, mid) > totalStudent){
                low = mid + 1;  //if pages can be distributed to more students than expected
                //increase page count so that we can get minimum students
            }else {
                high = mid - 1;
            }
        }
        return low;

        //Brute force
//        for(int i = low; i <= high; i++){
//            if(countStudents(nums, i) == totalStudent){
//                return i;
//            }
//        }
//        return -1;
    }

    public static int countStudents(int[] nums, int maxPages){
        int currStudent = 1;
        int currStudentCurrPagesSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(currStudentCurrPagesSum + nums[i] <= maxPages){
                currStudentCurrPagesSum += nums[i];
            }else{
                currStudent++;
                currStudentCurrPagesSum = nums[i];
            }
        }
        return currStudent; //no of students can hold current maxPages
    }

    public static int maximum(int[] nums){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        return maxi;
    }

    public static int sumOfAnArray(int[] nums){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        return sum;
    }


}
