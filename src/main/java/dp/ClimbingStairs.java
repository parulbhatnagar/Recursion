package dp;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        //n (x,y) = 4 -> (4,0), (2,1)X2 (0,2)
        // x + 2y = n
        // x = n - 2y
        int count=0;
        int x = 0;
        for (int y = 0 ; y <=n && x >=0; y ++){
            x = n - 2*y;
            if (x>=0) {
                if (x == 0 || y==0) {
                    count ++;
                }
                else {
                    count += factorial (x+y)/(factorial(x)*factorial(y));
                }
            }
        }
        return count;
    }

    public static int factorial(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        else {
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println( "number of solutions = " + climbStairs(5));
    }
}
