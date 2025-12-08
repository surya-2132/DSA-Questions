package Arrays.Medium;

class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,0,-1,-4,2,0};
        System.out.println("Brute: "+maximumProductBrute(nums));
        System.out.println("Optimal: "+maximumProductOptimal(nums));
    }


    public static int maximumProductBrute(int[] nums){
        // 2,0,-1,-4,2,0
        int maxProd = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int product = 1;
                for(int k = i; k <= j; k++) {
                    product *= nums[k];
                    maxProd = Math.max(maxProd, product);
                }
            }
        }
        return maxProd;
    }

    public static int maximumProductOptimal(int[] nums){
        int prefixProd = 1;
        int suffixProd = 1;
        int maxProd = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(prefixProd == 0) {
                prefixProd = 1;
            }

            if(suffixProd == 0){
                suffixProd = 1;
            }

            prefixProd = prefixProd * nums[i];
            suffixProd = suffixProd * nums[nums.length -i-1];
            maxProd = Math.max(maxProd, Math.max(prefixProd, suffixProd));
        }
        return maxProd;
    }
}