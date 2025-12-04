package Arrays.Medium;

import java.util.Arrays;

public class IntersectionOfTwoSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 3, 3};
        int[] nums2 = {2, 3, 3, 4, 5, 7};
        System.out.println("Intersection Array " + Arrays.toString(intersectionArray(nums1, nums2)));
    }

    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        int i = 0;
        int[] intersecArray = new int[Math.max(nums1.length, nums2.length)];

        while(n1 < nums1.length && n2 < nums2.length){
            if(nums1[n1] < nums2[n2]){
                n1++;
            }

            else if(nums1[n1] > nums2[n2]){
                n2++;
            }

            else if(nums1[n1] == nums2[n2]){
                intersecArray[i++] = nums1[n1];
                n1++;
                n2++;
            }
        }

        int[] result = new int[i];
        System.arraycopy(intersecArray, 0, result, 0, i);
        return result;
    }
}