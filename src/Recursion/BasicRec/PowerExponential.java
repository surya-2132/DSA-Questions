package Recursion.BasicRec;

public class PowerExponential {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -3));
    }

    //Recursive
    public static double myPow(double num, int pow) {
        if(pow < 0){
            return 1.0 / myPowHelper(num, -pow);
        }

        return myPowHelper(num, pow);
    }

    public static double myPowHelper(double num, int pow) {
        if(pow == 0){
            return 1;
        }

        if(pow % 2 == 1){
            return num * myPowHelper(num, pow -1);
        }

        return myPowHelper(num * num, pow / 2);
    }


    //Iterative
    public static double myPowIterative(double num, int p) {
        //if odd reduce one from power and multiply ans with given number
        //if even divide the power / 2 and multiply the number by itself.

        double ans = 1.0;
        long pow = Math.abs((long) p); //Temp variable to copy pow value and make it as +ve

        while(pow > 0){

            if(pow % 2 == 1){
                ans = ans * num;
                pow = pow - 1;
            }
            else{
                pow = pow / 2;
                num = num * num;
            }
        }

        if(p < 0){ //check if given pow is negative inverse ans
            ans = 1.0 / ans;
        }

        return ans;
    }


}
