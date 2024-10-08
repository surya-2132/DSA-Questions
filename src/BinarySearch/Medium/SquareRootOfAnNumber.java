package BinarySearch.Medium;

public class SquareRootOfAnNumber {
    public static void main(String[] args) {
        System.out.println(sqrtBrute(28));
        System.out.println(sqrtOptimal(28));
    }

    public static int sqrtBrute(int num){
        int ans = 1;
        for(int i = 1; i < num / 2; i++){
            if(i * i <= num){
                ans = i;
            }else{
                break;
            }
        }
        return ans;
    }

    public static int sqrtOptimal(int num){
        int low = 1;
        int high = num;
        int ans = 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(mid * mid <= num){
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
