package BitManipulation.Basics;

public class Main {

    public static void main(String[] args) {
        convertIntegerToBinary(13);
        System.out.println(convertBinaryToInteger("1001101"));
        System.out.println(set_ithBit(13, 2));
        System.out.println(clear_ithBit(13, 2));
        System.out.println(toggle_ithBit(10, 1));
        System.out.println(removeTheLastSetBitFromRight(12));
        System.out.println(removeTheLastSetBitFromRightIterative(12));
        System.out.println(isPowerOfTwo(16));
        System.out.println(hammingWeight(13));
        System.out.println(countSetBit(13));
    }


    public static void convertIntegerToBinary(int num){
        StringBuilder res = new StringBuilder();
        while (num != 0) {
            if (num % 2 == 1) {
                res.append('1');
            } else {
                res.append('0');
            }
            num = num / 2;  // Continue dividing the number by 2
        }
        res.reverse();
        System.out.println(res);
    }



    public static int convertBinaryToInteger(String str){
        // we just need to add the powers only, whenever we find set bits as 1,
        // skip 0 and since 1 * pow equals pow, add the pow alone whenever we get 1

        int ans = 0;
        int pow = 1;
        for(int i = str.length()-1; i >= 0; i--){
            if(str.charAt(i) == '1'){
                ans = ans + pow;
            }
            pow = pow * 2;
        }
        return ans;
    }


    // << Left shift
    public static boolean ithBitSetOrNot_LEFT_SHIFT(int num, int i){
        //By Left shift <<
        //13 is (1 1 0 1) base 2
        // 1 1 0 1 -> 1 1 0 1
        // 0 0 1 0 -> 0 1 0 0

        // 13 is 1 1 0 1
        // place 1 after ith places is 0 0 0 ... 1 0 0
        // so at last 13 is 1 1 0 1 AND 0 1 0 0 is true, returns true.
        return ((num & (1 << i)) != 0);
    }


    // >> Right shift + AND
    public static boolean ithBitSetOrNot_RIGHT_SHIFT(int num, int i){
        //By Left shift >>
        //13 is (1 1 0 1) base 2
        // [1 1 0] 1 -> 1 1 0 1
        // 0 [1 1 0] -> 0 0 [1 1] 0

        // removed 2 bits from right most end
        // [1 1] 0 1 became 0 0 [1 1]
        return (((num >> i) & 1) == 1);
    }


    // Using Left Shift + OR operator, OR because 0|1 or 1|1 = 1 which can set bit
    public static int set_ithBit(int num, int i){
        //set i-1 items 0 from right most side then set 1 on ith bit
        //when we do OR operation except all the values ith bit will only change to 1
        //all remaining values will stay as it is since rest adding new bits 0
        // 0 | 1 = 1, 1 | 0 = 1
        return (num | (1 << i));
    }


    // Using LS, ~(NOT), and AND operator, NOT because initially 00001 will flip into 11110
    public static int clear_ithBit(int num, int i){
        // Same as above as logic but using AND, so that other bit values will stay as it is.
        // Using ~ to change the inverse nums like (1 1 0 1) -> (0 0 1 0)
        return (num & ~(1 << i));
    }


    // Using XOR and LS, because 0 ^ 1 && 1 ^ 0 is 1 which is flipped. 0^0 and 1^1 is 0
    public static int toggle_ithBit(int num, int i){
        // Toggles the ith bit by XORing num with (1 << i)
        // Example: num = 10 (1010 in binary), i = 1
        // 1 << 1 = 0010 (only 2nd bit set)
        // 1010 ^ 0010 = 1000 (a result is 8)
        return (num ^ (1 << i));
    }



    public static int removeTheLastSetBitFromRight(int num){
        // num = 12 -> binary representation: 1 1 0 0 (base 2)
        // We are finding the last set bit (first '1' from the right) and removing it.
        // Example: num = 12 (1 1 0 0) -> After removing the last set bit, the result is 8 (1 0 0 0).

        // Num - 1: This subtracts 1 from num, flipping all bits to the right of the last set bit.
        // For example,
        // num = 12 (1 1 0 0)
        // num - 1 = 11 (1 0 1 1)

        // Performing 'num & (num - 1)' clears the last set bit.
        // num & (num - 1) works by turning off the lowest set bit (first '1' from the right) in num.
        // num = 12 (1 1 0 0) & 11 (1 0 1 1) results in 8 (1 0 0 0)
        return (num & (num - 1));
    }



    public static int removeTheLastSetBitFromRightIterative(int num) {
        int pos = 0;  // To keep track of the position of the current bit
        int mask = 1; // A mask to check each bit from right to left

        // Iterate over the bits
        while ((num & mask) == 0) {
            // Shift mask left to check the next bit
            mask = mask << 1;
            pos++;
        }

        // At this point, mask is at the position of the rightmost set bit
        // To remove the set bit and invert all the bits to the right of it
        int inversionMask = (1 << pos) - 1; // Create a mask that has all 1's to the right of the set bit
        return num & ~(mask | inversionMask); // Remove the set bit and invert the right side bits
    }


    public static int setRightmostUnsetBit(int n) {
        if (n == 0) {
            return 1; // Special case: if n is 0, set the rightmost bit to 1
        }

        // Find the rightmost unset bit
        int mask = 1;
        while ((n & mask) != 0) {
            mask <<= 1;
        }

        // Set the rightmost unset bit
        n |= mask;

        return n;
    }



    public static boolean isPowerOfTwo(int n) {
        //return ((n & (n-1)) == 0)
        if (n <= 0) return false; // Negative numbers and 0 can't be powers of two
        int counter = 0;
        while (n > 0) {
            // Check if the last bit is 1
            if ((n & 1) == 1) {
                counter++;
            }
            n = n >> 1;  // Right shift n by 1 to check the next bit
        }
        return counter == 1;    // If there's only one '1' bit, it's a power of two
    }



    public static int hammingWeight(int n) {
        int counter = 0;
        while (n > 0) {
            // Check if the last bit is 1
            if ((n & 1) == 1) {     // (n & 1) == 1 is equal to n % 2 == 1
                counter++;
            }
            // Right shift n by 1 to check the next bit
            n = n >> 1;  // n = n >> 1 is equals to n = n / 2;
        }
        return counter;    // If there's only one '1' bit, it's a power of two
    }
    public static int countSetBit(int num){
        //Here on each time 1 will be reduced from bit. Like 1101, 1100, 1000 (after flip operation)
        //On each iteration (in binary set bit) right most 1 will be turned off
        int count = 0;
        while(num != 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }
}