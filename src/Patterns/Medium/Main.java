package Patterns.Medium;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nPattern 12");
        pattern12(5);


        System.out.println("\nPattern 13");
        pattern13(5);


        System.out.println("\nPattern 14");
        pattern14(5);


        System.out.println("\nPattern 15");
        pattern15(5);


        System.out.println("\nPattern 16");
        pattern16(5);


        System.out.println("\nPattern 17");
        pattern17(5);


        System.out.println("\nPattern 18");
        pattern18(5);


        System.out.println("\nPattern 19");
        pattern19(5);


        System.out.println("\nPattern 20");
        pattern20(5);


        System.out.println("\nPattern 21");
        pattern21(5);

    }


    public static void pattern12(int n) {
        //outer loop for total rows
        for(int i = 1; i <= n; i++) {

            //left side numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            //space -> 2 * n will give last num
            //And its increase in 2 table in rev order like 6 spaces, 4 spaces then 2 spaces.

            //8 - 2= 6 -> 8-4 = 4 -> 8-6 = 2 -> 8-8=0, inc current index x 2 to get even nums
            for (int s = 1; s <= ((2 * n) - (2 * i)); s++) {
                System.out.print(" ");
            }

            //right side numbers
            for (int k = i; k > 0; k--) {
                System.out.print(k);
            }
            System.out.println();
        }
    }


    public static void pattern13(int n){
        //Keep a number to print in all rows and cols
        int num = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(num + " ");
                num++;   //print num variable itself, instead of any index
            }
            System.out.println();
        }
    }

    public static void pattern14(int n) {
        //create a character variable called ch with 'A'
        char ch = 'A';
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(ch);
                ch++;   //print ch value instead of index then increase it.
            }
            ch = 'A';   //Again initialize it to 'A', so that again it will start printing from A.
            System.out.println();
        }
    }


    public static void pattern15(int n) {
        char ch = 'A';
        for(int i = n; i > 0; i--){    //just reverse the outer loop because of pattern
            for(int j = 1; j <= i; j++){
                System.out.print(ch);
                ch++;
            }
            ch = 'A';
            System.out.println();
        }
    }


    public static void pattern16(int n) {
        char  ch = 'A';
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(ch);
            }
            ch++;   //since we're inc char val on each row after inner loop iteration, then inc the ch value.
            System.out.println();
        }
    }

    public static void pattern17(int n) {

        //We are going to use 5 loops
        //1st loop, to print all the rows
        //2nd loop, to print left space
        //3rd loop, to print first half of the chars of that row, in the pyramid.
        //4th loop, to print second half of the chars of that row, in the pyramid.
        //5th loop, to print right spaces

        for(int i = 1; i <= n; i++){

            char ch = 'A';
            int charLineLength = 2*i-1; //To get total length of char (-1 used to get odd value)
            int firstHalf = (charLineLength + 1)/2; //To get the char length of first half to be printed.
            int secondHalf = charLineLength - firstHalf; //To get the char length of second half to be printed.

            //left space
            for(int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }

            //first half chars
            for(int rc = 1; rc <= firstHalf; rc++){
                System.out.print(ch);
                ch++;
            }
            ch--;

            //second half chars
            for(int lc = 1; lc <= secondHalf; lc++){
                ch--;
                System.out.print(ch);
            }

            //right space
            for(int k = 1; k <= n-i; k++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void pattern18(int n) {
        for (int i = 1; i <= n; i++) {
            // Start with the nth character minus the current row number plus one
            char ch = (char)('A' + n - i);

            // Inner loop to print the characters in reverse order
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++; // Move to the next character in the alphabet
            }
            System.out.println();
        }
    }


    public static void pattern19(int n) {
        upperEmptyDiamond(n);
        lowerEmptyDiamond(n);
    }

    private static void upperEmptyDiamond(int n){

        //To print n rows, here starting with 0, so that we can do 2*0=0 which print 0 spaces on first row.
        for(int i = 0; i < n; i++){

            //to print left stars
            for(int j = 1; j <= n-i; j++){
                System.out.print("*");
            }

            //to print empty space to make diamond
            //since we are increase space by 2 we multiply current i x 2 -> 0,2,4,6,8.....
            for(int k = 1; k <= 2*i; k++){
                System.out.print(" ");
            }

            //to print right stars
            for(int l = 1; l <= n-i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void lowerEmptyDiamond(int n){
        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            //space inc in even nums, 2*(4-1)-> 2*(3)->6 like 2*(4-2)-> 2*(2)->4
            for(int k = 1; k <= 2*(n-i); k++){
                System.out.print(" ");
            }

            for(int l = 1; l <= i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    //Just reciprocal of last problem pattern 19 change conditions in loop
    public static void pattern20(int n) {
//        upperEmptySpace(n);
//        lowerEmptySpace(n);
        //can use the previous qus methods to, just remove = to reduce one line in upper loop
        lowerEmptyDiamond(n);
        upperEmptyDiamond(n);
    }

    public static void upperEmptySpace(int n){

        //To print n rows, here starting with 0, so that we can do 2*0=0 which print 0 spaces on first row.
        for(int i = 1; i <= n; i++){

            //to print left stars
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }

            //to print empty space to make diamond
            //since spaces are decrease by 2 we multiply 2*(5-1)->2*(4)=8 then 2 x 4-2, 4-3 etc...
            for(int k = 1; k <= 2*(n-i); k++){
                System.out.print(" ");
            }

            //to print right stars
            for(int l = 1; l <= i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void lowerEmptySpace(int n){
        //remove condition i <= n to i < n to reduce one line (first line) as per diagram.
        for(int i = 1; i < n; i++){

            for(int j = 1; j <= n-i; j++){
                System.out.print("*");
            }

            //space inc in even nums, 2*(4-1)-> 2*(3)->6 like 2*(4-2)-> 2*(2)->4
            for(int k = 1; k <= 2*i; k++){
                System.out.print(" ");
            }

            for(int l = 1; l <= n-i; l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern21(int n){
        //Outer loop to print all n rows
        for(int i = 1; i <= n; i++){
            //if its first or last row print only stars
            if(i == 1 || i == n){
                for(int j = 1; j <= n; j++){
                    System.out.print("*");
                }
            }
            //else start printing one start followed by empty spaces in a loop,
            //when loop ends again print a last star then exit loop, go next line
            else{
                System.out.print("*");
                for(int k = 1; k <= n-2; k++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
