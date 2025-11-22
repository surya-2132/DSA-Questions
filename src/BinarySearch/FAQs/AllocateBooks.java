package BinarySearch.FAQs;

import Utility.Operations;

public class AllocateBooks {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(findPagesBrute(arr, 2));
        System.out.println(findPagesOptimal(arr, 2));

    }

    public static int findPagesBrute(int[] nums, int mStudents) {
        // start from max pages so that if they give only one student,
        // all pages can go to that student only, which is max
        int min = Operations.max(nums);
        int max = Operations.sum(nums);
        int totalStudents = 0;

        for(int pages = min; pages <= max; pages++){
            totalStudents = allocatingBooks(nums, pages);
            if(totalStudents <= mStudents){
                return pages;
            }
        }

        return -1;
    }


    public static int findPagesOptimal(int[] nums, int mStudents) {
        int low = Operations.max(nums);
        int high = Operations.sum(nums);
        int totalStudents = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;
            totalStudents = allocatingBooks(nums, mid);
            if(totalStudents <= mStudents){
                high = mid - 1;
            }
            else{
                low = mid + 1; //if no of students more increase the page count to minimize student
            }
        }

        return low;
    }

    private static int allocatingBooks(int[] nums, int maxPage) {
        int currStudent = 1;
        int pagesAllocated = 0;

        for(int i = 0; i < nums.length; i++){

            if(pagesAllocated + nums[i] <= maxPage){
                pagesAllocated += nums[i];
            }
            else{
                currStudent++; //going to the next student
                pagesAllocated = nums[i]; // carrying the pages which couldn't give to last student(give it here)
            }
        }

        return currStudent;
    }
}
