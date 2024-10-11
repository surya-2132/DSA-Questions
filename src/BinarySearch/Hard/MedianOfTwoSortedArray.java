package BinarySearch.Hard;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3};
        System.out.println(median(arr1, arr2));
    }

    public static double median(int[] arr1, int[] arr2) {
        int a1 = arr1.length;
        int a2 = arr2.length;
        int totalLength = a1 + a2;
        int idx2 = totalLength / 2;
        int idx1 = idx2 - 1;
        int idx1Ele = -1;
        int idx2Ele = -1;
        int count = 0;
        int i = 0;
        int j = 0;

        while(i < a1 && j < a2){
            if(arr1[i] < arr2[j]){
                if(count == idx1) idx1Ele = arr1[i];
                if(count == idx2) idx2Ele = arr1[i];
                count++;
                i++;
            }
            else{
                if(count == idx1) idx1Ele = arr2[j];
                if(count == idx2) idx2Ele = arr2[j];
                count++;
                j++;
            }
        }

        while(i < a1){
            if(count == idx1) idx1Ele = arr1[i];
            if(count == idx2) idx2Ele = arr1[i];
            count++;
            i++;
        }

        while(j < a2){
            if(count == idx1) idx1Ele = arr2[j];
            if(count == idx2) idx2Ele = arr2[j];
            count++;
            j++;
        }

        if(totalLength % 2 == 1){
            return idx2Ele;
        }

        return (double) (idx1Ele + idx2Ele) / 2.0;
    }


}
