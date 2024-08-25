public class Main {
    public static void main(String[] args) {
        countDigitsInANumber(123456);
        System.out.println("sumOfAnNumber "+sumOfAnNumber(100000));
        System.out.println("Reverse an number "+reverseAnNumber(12345));
        System.out.println("Is palindrome number " + isPalindromeNumber(12321));

        System.out.println("Is prime number " + isPrimeNumber(14));
        printRange(1, 100);

        System.out.println("Factorial " + factorial(6) + "\n");
        fibonacci(10);

        System.out.println(armstrongNumber(153) + "\n");
        System.out.println("leap year " + leapYear(2025));
        //printRange(2000, 2100);

        System.out.println("\n\n GCD, LCM, Co-Prime");
        System.out.println(GCD(45, 30));
        System.out.println(LCM(45, 30));
        System.out.println(COPrime(2,8));
    }


    public static void printRange(int start, int end){
        for(int i = start; i < end; i++){
            if(leapYear(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void countDigitsInANumber(int num){
        //123456
        int digitsPresent = 0;
        while(num > 0){
            digitsPresent++;
            num = num / 10;
        }
        System.out.println("digits present: "+digitsPresent);
    }

    public static int sumOfAnNumber(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum = sum + rem;
            num = num / 10;
        }
        return sum;
    }

    public static int reverseAnNumber(int num){
        //1234
        int reversedNumber = 0;
        while(num > 0){
            int rem = num % 10;
            reversedNumber = reversedNumber * 10 + rem;
            num = num / 10;
        }
        return reversedNumber;
    }
    
    public static boolean isPalindromeNumber(int num){
        int rev = 0;
        int org = num;
        while(num > 0){
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return org == rev;
    }

    public static boolean isPrimeNumber(int num){
        int count = 0;
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                count++;
            }
        }
        return count == 2;
    }

    public static int factorial(int num){
        // 3! = 3 * 2 * 1
        int fact = 1;
        for(int i = num; i > 0; i--){
            fact = fact * i;
        }
        return fact;
    }

    public static void fibonacci(int fiboEnd){
        //0,1,1,2,3,5,8,13,21,34,55,89
        int num1 = 0;
        int num2 = 1;
        for(int i = 0; i < fiboEnd; i++){
            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            System.out.print(num3+ " ");
        }
        System.out.println();
    }

    public static boolean armstrongNumber(int num){
        //153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
        int sum = 0;
        int rem;
        int org = num;
        while(num > 0){
            rem = num % 10;
            rem = rem * rem * rem;
            sum = sum + rem;
            num = num / 10;
        }
        return org == sum;
    }

    public static boolean leapYear(int year){
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a % b);
    }

    public static int LCM(int a, int b){
        int gcd = GCD(a, b);
        int lcm = (a * b) / gcd;
        return lcm;
    }

    public static String COPrime(int a , int b){
        int gcd = GCD(a, b);
        return gcd == 1 ? "Co-Prime numbers" :  "Not a Co-Prime numbers";
    }


}