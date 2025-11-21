package BinarySearch.PivotBasedAndLogicBuilding;

public class SearchInSortedArr_1 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(search(nums, 6));
    }

    //AFTER FOUND PIVOT MAKE BINARY SEARCH ON GIVER ARRAY
    public static int search(int[] nums, int target) { //start = 0;end = nums.length -1;
        int pivot = findPivot(nums);

        if(pivot == -1){    // No rotation in array[0,1,2,3,4]
            return binarySearch(nums, target, 0, nums.length -1);
        }
        //case 1 pivot itself target, target is 7 and pivot is also 7
        //if the middle element itself pivot then return that pivot, because that's the target
        if(nums[pivot] == target){
            return pivot;
        }

        //case 2  where start is smaller than the target
        //if start element[4] is smaller than target[7], no need to search after pivot,
        //because those are less than the target.
        if(nums[0] <= target){ //[4,5,6] 7 won't come it would catch in above checks
            return binarySearch(nums, target, 0, pivot - 1);
        }


        //case 3  where start is greater than the target
        //if start element[4] and target element[0], no need to search before pivot,
        //because those are greater than the target.
        if(nums[0] >= target){  //[0,1,2]
            return binarySearch(nums, target, pivot + 1, nums.length -1);
        }

        return -1;      //target is not found in a rotated array

    }


    //TO FIND THE PIVOT ELEMENT FROM ROTATED ARRAY
    public static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start <= end){

            int mid = start + (end - start)/2;

            //case 1 where middle is 7
            if(mid < end && nums[mid] > nums[mid + 1]){  //7 > 0 then middle element 7 is a pivot
                return mid;     //if pivot is lastElement-1,then IndexOutOfBound so mid < end
            }

            //case 2 where middle is 0
            if(mid > start && nums[mid] < nums[mid -1]){ //0 < 7 then middle-1 element is a pivot
                return mid - 1;
            }

            //case 3 where middle is 0(lowest)
            if(nums[start] >= nums[mid]){   //0 <= 4 then create new END from previous(0) mid
                end = mid - 1;
            }

            //case 4 where middle is 7(greatest)
            if(nums[start] <= nums[mid]){   //7 >= 0 then create new START from previous(6) mid
                start = mid + 1;
            }
        }
        return -1;
    }


    //USUAL BINARY SEARCH ALGORITHM WITH START AND END AS PARAMETER
    public static int binarySearch(int[] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;

            if(target > nums[mid]){
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}