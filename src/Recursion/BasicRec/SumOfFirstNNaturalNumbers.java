package Recursion.BasicRec;

public class SumOfFirstNNaturalNumbers {
    public static void main(String[] args) {
        sumOfFirstNNaturalNumbers(97);
        System.out.println(sumOfNaturalNumRecursion(97));
    }

    public static void sumOfFirstNNaturalNumbers(int num){
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum += i;
        }
        System.out.println(sum);
    }

    public static int sumOfNaturalNumRecursion(int num){
        if(num == 0){
            return 0;
        }
        return num + sumOfNaturalNumRecursion(num - 1);
    }
}
