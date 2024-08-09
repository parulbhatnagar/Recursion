import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    // print fibonacci series for given length

    public static void main(String[] args) {
        int length = 10;
        System.out.println("series -> " + fibonacci(length));
    }

    private static long fibonacci(long number ){
        // base condition
        if (number==0 || number == 1) {
            //System.out.println(" " + number);
            return number;
        }
        var  returnValue = fibonacci(number-1) + fibonacci(number-2);
        //System.out.println(" " +returnValue);
        return returnValue;
    }
}
