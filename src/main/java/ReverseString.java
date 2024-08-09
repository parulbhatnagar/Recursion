public class ReverseString {

    public static void main(String[] args) {
        // For a give string e.g.
        // This is a test
        // response should be tset a si sihT

        // we need to use recursion

        reverse("This is a test");

        System.out.println(reverseString("Second Test with return type"));

    }

    public static void reverse(String s) {
        // base condition
        if (s.length() == 1) {
            System.out.print(s.charAt(0));
            return ;
        }
        else {
             reverse(s.substring(1));
            System.out.print(s.charAt(0));
        }
    }

    public static String reverseString(String s){
        if (s.equals("")){
            return "";
        }
        else {
            return reverseString(s.substring(1)) + s.charAt(0);
        }
    }
}
