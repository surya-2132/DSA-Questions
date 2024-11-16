package Recursion.BasicRec;

import java.util.ArrayList;
import java.util.Vector;

public class BasicRecQus {
    public static void main(String[] args) {

    }

    // Qus 1: Factorial of a given number
    public long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }



    // Qus 2: Fibonacci Number
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }



    // Qus 3: check if num is prime or not
    public boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }

        return isPrime(num, 2);
    }
    private boolean isPrime(int num, int counter) {
        if (counter > Math.sqrt(num)) {
            return true;
        }

        if (num % counter == 0) {
            return false;
        }

        return isPrime(num, counter + 1);
    }



    // Qus 4: Sum of first N numbers
    public int firstN_NumsSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + firstN_NumsSum(n - 1);
    }



    // Qus 5: Sum of array elements
    public int arraySum(int[] nums) {
        return recArrSum(nums, 0);
    }
    private int recArrSum(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        return nums[idx] + recArrSum(nums, idx + 1);
    }



    // Qus 6: Reverse an array
    public int[] reverseArray(int[] nums) {
        recRevArr(nums, 0, nums.length - 1);
        return nums;
    }
    private void recRevArr(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        recRevArr(nums, left + 1, right - 1);
    }



    // Qus 7: Check if the array is sorted
    public boolean isSorted(ArrayList<Integer> nums) {
        return recIsSorted(nums, 0, 1);
    }
    private boolean recIsSorted(ArrayList<Integer> nums, int left, int right) {
        if (right >= nums.size() - 1) {
            return true;
        }

        if (nums.get(left) > nums.get(right)) {
            return false;
        }

        return recIsSorted(nums, left + 1, right + 1);
    }



    // Qus 8: Reverse a string
    public Vector<Character> reverseString(Vector<Character> s) {
        recRevStr(s, 0, s.size() - 1);
        return s;
    }
    private void recRevStr(Vector<Character> s, int left, int right) {
        if (left >= right) {
            return;
        }

        char lChar = s.get(left);
        char rChar = s.get(right);

        s.set(left, rChar);
        s.set(right, lChar);

        recRevStr(s, left + 1, right - 1);
    }



    // Qus 9: Check if string is palindrome or not
    public boolean palindromeCheck(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }
    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }



    // Qus 10: Sum of digits in a given number
    public int addDigits(int num) {
        return recAddDigit(num);
    }
    private int recAddDigit(int num) {
        if (num < 10) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }

        return recAddDigit(sum);
    }
}
