package Arrays.Medium;

public class RemoveDuplicateElements_2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int left = 1;
        int currFreq = 1;

        for (int right = 1; right < nums.length; right++){
            if(nums[right] == nums[right-1]){
                currFreq++;
            }else{
                currFreq = 1;
            }

            if(currFreq <= 2){
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

}