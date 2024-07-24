package BasicMath;

public class CountSumReverseTheNumber {

    public static void main(String[] args) {
        System.out.println();
        countDigit(1234);
        reverseGivenNumber(98765);
        sumOfAnNumber(12345);
    }

    //count how many digits in given number
    public static void countDigit(int number){
        //1234
        int count = 0;
        while(number > 0){
            number = number / 10;
            count++;
        }
        System.out.println("Number of digits  in given number: "+count);
    }

    //Sum of a given number
    public static void sumOfAnNumber(int number){
        //12345
        int sum = 0;
        int org = number;
        while(number > 0){
            int rem = number % 10;
            sum = sum + rem;
            number = number / 10;
        }
        System.out.println("Sum of an given number " + org + " is: " + sum);

    }

    //Reverse of a given number
    public static void reverseGivenNumber(int number){
        //12345
        int rev = 0;
        int org = number;
        while(number > 0){
            int rem = number % 10;
            rev = rev * 10 + rem;
            number = number / 10;
        }
        System.out.println("Inverse of an given number " + org + " is: " + rev);
    }

}
