package Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums2 = {2, 3, 4, 4, 5, 11, 12};
        System.out.println("Union Array: "+Arrays.toString(unionArrayOptimal(nums1, nums2)));
    }

    public static int[] unionArrayBrute(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1) set.add(num);
        for(int num : nums2) set.add(num);
        int[] ansArray = new int[set.size()];

        int i = 0;
        for(int num : set){
            ansArray[i++] = num;
        }

        return ansArray;
    }


    public static int[] unionArrayOptimal(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        int i = 0;
        int[] unionArr = new int[nums1.length + nums2.length];

        while(n1 < nums1.length && n2 < nums2.length){
            if(nums1[n1] <= nums2[n2]){
                if(i == 0 || unionArr[i-1] != nums1[n1]){
                    unionArr[i++] = nums1[n1++];
                }
                else{
                    n1++;
                }
            }
            else{
                if(i == 0 || unionArr[i-1] != nums2[n2]){
                    unionArr[i++] = nums2[n2++];
                }
                else{
                    n2++;
                }

            }
        }

        while(n1 < nums1.length) {
            if (i == 0 || unionArr[i-1] != nums1[n1]) {
                unionArr[i++] = nums1[n1++];
            } else {
                n1++;
            }
        }

        while(n2 < nums2.length) {
            if (i == 0 || unionArr[i-1] != nums2[n2]) {
                unionArr[i++] = nums2[n2++];
            } else {
                n2++;
            }
        }

        int[] result = new int[i];
        System.arraycopy(unionArr, 0, result, 0, i);
        return result;
    }
}