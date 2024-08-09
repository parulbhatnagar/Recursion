public class DecimalToBinary {

    public static String  toBinary(int num){
        // base condition
        if(num==0 || num==1){
            return String.valueOf(num);
        }

        // small work
        int remainder = num%2;
        return toBinary(num/2) + String.valueOf(remainder) ;

    }

    public static void main(String[] args) {
        System.out.println(toBinary(233));
    }
}
