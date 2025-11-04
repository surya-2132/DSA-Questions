package Arrays.Easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,3,5};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = 0;

        while(left > 0 && right < n){
            if(nums1[left] > nums2[right]){
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            }
            else{
                break;
            }
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);


        for(int i = m; i < m+n; i++){
            nums1[i] = nums2[i-m]; //5-5, 6-5, 7-5 ...
        }
        return nums1;
    }
}