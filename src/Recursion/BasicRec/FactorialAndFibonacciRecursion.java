package Recursion.BasicRec;

import java.util.Scanner;

public class FactorialAndFibonacciRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to get factorial of : " );
        int input1 = scanner.nextInt();
        System.out.println(factorial(input1) + "\n");


        System.out.println("Enter number to get n'th fibonacci num : ");
        int input2 = scanner.nextInt();
        System.out.println(fibonacci(input2));
    }

    public static int factorial(int num){
        if(num == 0){
            return 1;
        }
        return num * factorial(num -1);
    }

    public static int fibonacci(int numTill){
        if(numTill == 0|| numTill == 1){
            return numTill;
        }
        return fibonacci(numTill - 1) + fibonacci(numTill -2);
    }
}
