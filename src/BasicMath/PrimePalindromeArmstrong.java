package BasicMath;

public class PrimePalindromeArmstrong {

    public static void main(String[] args) {

       printRange(2000, 2100);
//       System.out.println("\n"+isPrimeNumber(13));
        System.out.println("Palindrome : "+isPalindrome(124521));
        System.out.println("Armstrong : " + armstrongNumber(153));
        System.out.println("Leap Year : " + isLeapYear(2012));

    }

    //To print from a range, can be used for prime, leapYear and armstrong
    // and similar type of qus to print between a given range.
    public static void printRange(int start, int end){
        for(int i = start; i <= end; i++){
            if(isLeapYear(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println("\n-------------------------------------");
    }


    //primeNumber - A number should be divided by 1 and by number itself.
    // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    public static boolean isPrimeNumber(int number){
        int count = 0;
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
               count++;
            }
        }
        //To calculate prime numbers from the given range can use two for loop, TC -> o(n^2)
        //to reduce that we can use sieve of eratosthenes.
        //System.out.println("if count is equal to 2 then it's a prime number");
        return count == 2;
    }


    //Palindrome -> After reversal number should be equal to same as it before.
    public static boolean isPalindrome(int number){
        int original = number;
        // original : 123421 -> after reverse : 124321

        int rev = 0;
        while(number > 0){ //122, 12, 1, 0
            int rem = number % 10; //1221 -> 1, 122 -> 2, 12 % 10 -> 2, (1 % 10 -> 1)
            rev = rev * 10 + rem; // 0 * 10 + 1 -> 0 + 1 = 1, 1 * 10 + 2 -> 12, 12 * 10 + 2 -> 122, (122 * 10 + 1 -> 1221)
            number = number / 10; //122 / 10 -> 12, 12 / 10  -> 1, 1 / 10 -> 0.1
        }

        return original == rev;
//        if(original == rev){
//            return true;
//        }else {
//            return false;
//        }
    }



    //Armstrong number -> A number that is equal to the sum of its digits, each raised to a power of 3.
    //Eg : 153 -> 1^3 + 5^3 + 3^3 -> 1 + 125 + 27  -> 153
    public static boolean armstrongNumber(int number){
        int org = number; //org = 153
        int sum = 0;
        while(number > 0){  //153 > 0, 15 > 0, 1 > 0, 0 > 0 condition fails
            int rem = number % 10;  //rem = 3, 15 % 10 = 5, 1 % 10 = 1
            rem = rem * rem * rem;  //rem = 3 * 3 * 3 = 27, rem = 5 * 5 * 5 = 125, rem = 1 * 1 * 1 = 1
            sum = sum + rem;    //sum = 0 + 27 = 27 -> 27 + 125 -> 152, sum = 152 + 1 = 153
            number = number / 10;   //153 / 10 = 15 -> 15 / 10 = 1, 1/ 10 = 0.1(0)
        }

        //In this approach TC -> would be O(n) if you want to print range by using another for TC -> O(n^2)
        return org == sum; //153 == 153 ? true : false;
    }

    public static boolean isLeapYear(int year){
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

//        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
//            System.out.println(year + " is a leap year");
//            return true;
//        }else{
//            System.out.println(year + " is NOT a Leap year");
//            return false;
//        }
    }
}
