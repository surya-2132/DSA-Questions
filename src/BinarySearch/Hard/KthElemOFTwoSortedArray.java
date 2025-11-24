package BinarySearch.Hard;

public class KthElemOFTwoSortedArray {

    //Almost the same solution as Median of two sorted array with little change
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};
        System.out.println("Kth Element: "+ kthElement(nums1, nums2, 5));
    }


    public static int kthElement(int[] arr1, int[] arr2, int k) {

        int a1 = arr1.length;
        int a2 = arr2.length;

        // change: we only need one index now
        int targetIdx = k - 1;
        int targetEle = -1;

        int count = 0;
        int i = 0;
        int j = 0;

        while (i < a1 && j < a2) {
            if (arr1[i] < arr2[j]) {
                if (count == targetIdx) targetEle = arr1[i];
                count++;
                i++;
            } else {
                if (count == targetIdx) targetEle = arr2[j];
                count++;
                j++;
            }
        }

        while (i < a1) {
            if (count == targetIdx) targetEle = arr1[i];
            count++;
            i++;
        }

        while (j < a2) {
            if (count == targetIdx) targetEle = arr2[j];
            count++;
            j++;
        }

        return targetEle;
    }
}