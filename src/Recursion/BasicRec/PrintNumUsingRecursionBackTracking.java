package Recursion.BasicRec;

public class PrintNumUsingRecursionBackTracking {
    public static void main(String[] args) {
        //printNameMultipleTimes(0);
        //printNameUsingParam(1, 5); //-> print 1 to 5 times
        //printNumberFromOneToN(1, 10);
        //printNumberFromNToOne(10, 1);
        //printOneToNBackTracking(10, 1);
        printNToOneBackTracking(1, 10);
    }


    public static void printNameMultipleTimes(int counter){
        counter++;
        if(counter > 5){
            return;
        }
        System.out.println("Surya");
        printNameMultipleTimes(counter);
    }


    public static void printNameUsingParam(int i, int n){
        if(i > n){ // 1 > 5 ? no, 2 > 5 ? no ... 6 > 5 ? yes then return
            return;     //and starts executing(print) previous function's value in rev order.
        }
        System.out.println("Surya");
        printNameUsingParam(i + 1, n); //2, 3, 4, 5, 6 then break.
    }


    public static void printNumberFromOneToN(int i, int n){
        // i = 1, n = 10
        if(i > n){ // 1 > 10 ? no, 2 > 10 ? no ... 11 > 10 yes then return ans start executing values
            return;
        }
        System.out.println(i);
        printNumberFromOneToN(i+1, n);  //increase i on each iteration.
    }


    public static void printNumberFromNToOne(int i, int n){
        //i = 10, n = 10
        if(i < n){ // 10 < 1 ? no, 9 < 1 no ... 1 < 1 no, 0 < 1 yes then return
            return;
        }

        System.out.println(i);
        printNumberFromNToOne(i-1, n);  //3, 2, 1.
    }


    //Print one to N but by backtracking
    //Print statement should come after function call, and it will start execution from last func call's value
    //in last func call it will meet 0 < 1 return in last second func all it will start to print 1, then 2 ... till 10
    public static void printOneToNBackTracking(int i, int n) {
        if(i < n){
            return;
        }
        printOneToNBackTracking(i - 1, n);  //this func call is over THEN print value, at that time i value will be 1
        System.out.println(i); //Back Tracking -> printing the values from backside/rev func call
    }


    //Print N to one but by backtracking
    public static void printNToOneBackTracking(int i, int n){
        if(i > n){
            return;
        }
        printNToOneBackTracking(i + 1, n); // 1, 2, 3 ... 10 then once func(10, 10) terminates
        System.out.println(i);  //then start printing from backwards 10, 9, 8 ... 1
    }
}
