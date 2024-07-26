package BasicMath;

public class LCM_GCD_SQRT_POW {
    public static void main(String[] args) {
        System.out.println("GCD Iterative 1 : " + gcdIterative(20, 30));
        System.out.println("GCD Iterative 2 : " + gcdIterative2(20, 30));
        System.out.println("GCD Recursive : " + gcdRecursive(20, 30));
        System.out.println("LCM Recursive : " + lcmUsingGCD(20, 30));
        System.out.println("Co-Prime number : " + coPrimeNumber(2, 6));
        System.out.println("Power Exponential : " + powerExponential(3, 9));
        System.out.println("Perfect Square : " + isPerfectSqrtRoot(14));
    }

    //GCD -> greatest common divisor or HCF -> Highest common factor
    //This ,method is brute for where TC -> O(n)
    public static int gcdIterative(int a, int b){
        int result = 0;
        int min = Math.min(a, b);

        for(int i = 1; i <= min; i++){
            if(a % i == 0 && b % i == 0){
                result = i;
            }
        }
        return result;
    }

    //GCD - Iterative Method 2
    public static int gcdIterative2(int a, int b){

        if (a == 0) return b;
        if (b == 0) return a;

        while(a > 0 && b > 0){
            if (a > b){
                a = a-b;
            }
            else{
                b = b-a;
            }
        }
        return a == 0 ? b : a;
    }

    //GCD - This recursive method TC -> O(log(min(a, b))
    public static int gcdRecursive(int a, int b){
        if(b == 0){ //base condition to stop recursion
            return a;
        }
        return gcdRecursive(b, a % b);
        //i) (30 , 20 % 30) -> a=30, b=20
        //ii) (20, 30 % 20) -> a=20, b=10
        //iii) (20,20 % 10) -> a=20, b=0
        //since b = 0 return a value where a = 20; DO recursive tree manually.
    }


    //LCM - Least common multiplier
    //To find LCM we can always use a formula -> lcm = (num1 * num2) / gcd
    //So first we have to find GCD
    public static int lcmUsingGCD(int a, int b){
        int gcd = gcdIterative2(a, b);
        int lcm = (a * b) / gcd;
        return lcm;
    }

    //CO-Prime Number -> Will always be 1, because if it's more than 5 adjacent numbers divided by 2 so no possibility.
    public static String coPrimeNumber(int a, int b){
        int gcd = gcdIterative2(a, b);
        return gcd == 1 ? "Co-Prime numbers" :  "Not a Co-Prime numbers";

//        if(gcd == 1){
//            return "Co-Prime numbers";
//        }else{
//            return "Not a Co-Prime numbers";
//        }
    }


    //Power of exponential - gfg
    //Pow(x, n) x is num, n is its power - lc
    public static int powerExponential(int num, int pow){
        //if pow is odd -> reduce 1 from power to make it even meanwhile multiply num with existing answer
        //if pow is even -> divide the power by two meanwhile multiply num = num * num;
        //if power is -ve, convert it into absolute value using Math.abs((long)pow)
        int ans = 1;
        while(pow > 0){
            if(pow % 2 == 1){
                pow = pow - 1;
                ans = ans * num;
            }else{
                pow = pow / 2;
                num = num * num;
            }
        }
        //if power is -ve -> 3 ^ -9 is (3 ^ 1/9) so just inverse it.
        if(pow < 0){
            return 1/ans;
        }
        return ans;
    }

    //Brute force can be O(n) loop through from start to end meanwhile multiply num * num == sqrt
    //Optimal solution will be by using binary search
    public static boolean isPerfectSqrtRoot(int num){
        //let's take we have to find 14 is perfect square or not.
        int left = 1;
        int right = num / 2; //because if 4 * 4 = 16, 14 can't be more than this, 
                             // it should be with in the half of its number. so stop it here.
        
        while(left <= right){
            int mid = (left + right) / 2;
            long sqrt = (long)mid * mid;
            
            if(mid == sqrt){
                return true;
            } else if (sqrt > num) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}
