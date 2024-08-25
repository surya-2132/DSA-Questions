package Patterns;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nPattern 1");
        pattern1(5);


        System.out.println("\nPattern 2");
        pattern2(5);


        System.out.println("\nPattern 3");
        pattern3(5);


        System.out.println("\nPattern 4");
        pattern4(5);


        System.out.println("\nPattern 5");
        pattern5(5);


        System.out.println("\nPattern 6");
        pattern6(5);


        System.out.println("\nPattern 7");
        pattern7(5);


        System.out.println("\nPattern 8");
        pattern8(5);


        System.out.println("\nPattern 9");
        pattern9(5);


        System.out.println("\nPattern 10");
        pattern10(5);


        System.out.println("\nPattern 11");
        pattern11(5);



    }

    public static void pattern1(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void pattern2(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void pattern4(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }


    public static void pattern5(int n){
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void pattern6(int n){
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= n-i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void pattern7(int n){
        //on each line we have to print [space, stars, space]
        //outermost loop to run no of lines, lets say n = 4 ( just for iteration 1)
        for(int i = 1; i <= n; i++){    //1 to 4

            //this loop is to print left spaces, j <= 4-1 = 3, it'll print 3 spaces
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            //this loop is to print stars inbetween spaces on both sides, k <= 2*1-1 -> 2-1 -> 1, print 1 star
            for(int k = 1; k <= 2*i-1; k++){
                System.out.print("*");
            }

            //this loop is to print right spaces, l <= 4-1 = 3, it'll print 3 spaces
            for(int l = 1; l <= n - i; l++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void pattern8(int n) {

        //total number of lines
        for(int i = 1; i <= n; i++){

            //left space
            for(int j = 1; j <= i-1; j++){
                System.out.print(" ");
            }

            //stars, formula -> (2*(n-i)+1
            //i = 1 -> n=4 => 2*(4-1)+1 =(2*3)+1 = 6+1= 7
            //i = 2 -> n=4 => 2*(4-2)+1 =(2*2)+1 = 4+1= 5
            //i = 3 -> n=4 => 2*(4-3)+1 =(2*1)+1 = 2+1= 3
            //i = 4 -> n=4 => 2*(4-4)+1 =(2*0)+1 = 0+1= 1
            for(int k = 1; k <= (2*(n-i)+1); k++){
                System.out.print("*");
            }

            //right space
            for(int l = 1; l <= i-1; l++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern9(int n){
        pattern7(n);
        pattern8(n);
    }

    public static void pattern10(int n){
        pattern2(n);
        pattern5(n-1);
    }

    public static void pattern11(int n) {

        //Outer loop for total required rows
        for(int i = 1; i <= n; i++){

            //Inner loop in reverse, if we check the pattern it always starts with 1 at the end
            //then following by 0 and it repeats.
            for(int j = i; j > 0; j--){
                if(j % 2 != 0){
                    System.out.print("1 "); //so if index is odd we put 1
                }else{
                    System.out.print("0 "); //if index is even we put 0
                }
            }
            System.out.println();
        }
    }
}
