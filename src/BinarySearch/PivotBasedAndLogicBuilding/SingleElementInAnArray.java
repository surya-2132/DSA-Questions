package BinarySearch.PivotBasedAndLogicBuilding;

public class SingleElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(singleElemBrute(nums));
        System.out.println(singleElemOptimal(nums));
    }

    public static int singleElemBrute(int[] nums){

        if(nums.length == 1) return nums[0];

        for(int i = 0; i < nums.length; i++){

            //checking 1st and 2nd elem whether first is single elem or not
            if(i == 0){
                if(nums[i] != nums[i+1]) return nums[i];
            }

            //checking last 2 elem whether last is single elem or not
            else if(i == nums.length-1){
                if(nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
            }

            //from 1st index to second last index
            else{
                if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) return nums[i];
            }
        }

        return -1;
    }


    public static int singleElemOptimal(int[] nums) {
        int low = 1;
        int high = nums.length-2;

        // 3 edge cases
        if(nums.length == 1){   //if only one element is present, return that
            return nums[0];
        }

        if(nums[0] != nums[1]){  // Check if the single element is at the start.
            return nums[0];
        }

        if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];  // Check if the single element is at the end.
        }

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }


            // 1st condition -> even, odd means left is fine, unique element in right half
            // 2nd condition -> odd, even means left part has unique.
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                //eliminate left half
                low = mid + 1;
            }else{
                //eliminate right half
                high = mid - 1;
            }
        }

        return -1;
    }
}
