package BasicMath;

public class FactorialFibonacci {
    public static void main(String[] args) {
        System.out.println(factorial(6));
    }

    //fibonacci series is a sum of last two numbers
    //0,1,1,2,3,5,8,13,21,34,55
    //Using iterative method
    public static void fibonacciIterative(int range){
        int num1 = 0;
        int num2 = 1;

        for(int i = 0; i < range; i++){
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            System.out.print(num3+" ");
        }
    }

    //Factorial of a number
    //Factorial of 5 is 5 * 4 * 3 * 2 * 1
    public static int factorial(int num){
        int fac = 1;
        while(num > 0){
            fac = fac * num;
            num--;
        }
        return fac;
    }

    //Using recursive method for Factorial and Fibonacci
}
