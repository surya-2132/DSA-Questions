package BinarySearch.PivotBasedAndLogicBuilding;

public class Min_And_LenOfRotatedArr {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println("Find minimum in pivot: "+ findMin(nums));
        System.out.println("Find length of the rotation: "+ findKRotation(nums));
    }

    /*
    In leetcode qus it'll be ArrayList<Integers> modify accordingly
    Given an integer array nums of size N, sorted in ascending order with distinct values,
    and then rotated an unknown number of times (between 1 and N),
    find the minimum element in the array
     */
    public static int findMin(int[] nums) {
        int pivot = FindPivot.findPivot(nums);
        return nums[pivot+1];
    }


    /*
    In leetcode qus it'll be ArrayList<Integers> modify accordingly
    Given an integer array nums of size n, sorted in ascending order with distinct values.
    The array has been right rotated an unknown number of times, between 0 and n-1 (including).
    Determine the number of rotations performed on the array.
     */

    public static int findKRotation(int[] nums) {
        int pivot = FindPivot.findPivot(nums);
        return pivot + 1; //current pivot index + 1 to get length
    }
}
