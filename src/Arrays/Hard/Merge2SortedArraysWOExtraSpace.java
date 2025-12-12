package Arrays.Hard;

import java.util.Arrays;

public class Merge2SortedArraysWOExtraSpace {

    public static void main(String[] args) {
        // Example values
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;

        int[] nums2 = {1, 2, 3};
        int n = 3;

        // Call merge method
        merge(nums1, m, nums2, n);

        // Print result
        System.out.println("Merged nums1: " + Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = 0;

        while(left >= 0 && right <= nums2.length){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }
            else{
                break; //sorted order maintained by default from here
            }
        }

        //after swapping elems between nums1 and nums2 order would be disturbed, so again sort them
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        //add nums2 elem into nums1
        int j = 0;
        for(int i = m; i < m+n; i++){ //starting of from nums1.length+1
            nums1[i] = nums2[j++];
        }
    }
}