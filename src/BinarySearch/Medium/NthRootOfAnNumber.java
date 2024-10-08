package BinarySearch.Medium;

public class NthRootOfAnNumber {
    public static void main(String[] args) {

    }


    public static int nthRootOptimal(int n, int m){
        int low = 1;
        int high = m;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int val = findingPowerNForGivenNumberM(mid, n, m);

            if(val == 1){   //findingPowerNForGivenNumberM(mid, n, m) == m before
                return mid;
            } else if (val == 0) {
                low = mid + 1;
            } else {
                high = mid  - 1;
            }
        }
        return -1;
    }


    //mid is a num, n is power, m is number
    private static int findingPowerNForGivenNumberM(int mid, int n, int m){
        long ans = 1;
        for(int i = 1; i <= n; i++) {
            ans = ans * mid;

            if (ans > m) {
                return 2;
            }
        }

        if(ans == m){
            return 1;
        }

        return 0;
    }
}
