package Arrays.Medium;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(productSubArrBrute(new int[] {2,3,-2,4}));
        System.out.println(productSubArrBetter(new int[] {2,3,-2,4}));
        System.out.println(productSubArrOptimal(new int[] {2,3,-2,4}));

    }

    public static int productSubArrBrute(int[] nums){
        //2,3,-2,4
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int product = 1;
                for(int k = i; k <= j; k++){
                    product = product * nums[k];
                }
                max = Math.max(max, product);
            }
        }
        return max;
    }


    public static int productSubArrBetter(int[] nums){
        //2,3,-2,4
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int product = 1;
            for(int j = i; j < nums.length; j++){
                product = product * nums[j];
                max = Math.max(max, product);
            }

        }
        return max;
    }

    public static int productSubArrOptimal(int[] nums){
        int prefix = 1; //like left pointer
        int suffix = 1; //like right pointer
        int max = Integer.MIN_VALUE;    //track max between prefix and suffix

        for(int i = 0; i < nums.length; i++){

            if(prefix == 0){  //while traversing any element is 0, reset prefix prod to 1
                prefix = 1;
            }

            if(suffix == 0){  //while traversing any element is 0, reset suffix prod to 1
                suffix = 1;
            }

            //multiplying the current ith value with prev calculated prefix/suffix
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length-1-i];

            max = Math.max(max, Math.max(prefix, suffix));
        }

        //did this same calculation in one go (suffix line, n-1-p)
        // for(int s = nums.length-1; s >= 0; s--){
        //     if(nums[s] == 0){
        //         suffix = 1;
        //     }
        //     suffix = suffix* nums[s];
        //     max = Math.max(max, suffix);
        // }

        return max;
    }
}