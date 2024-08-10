package reccursion;

public class Palindrome {

    public static boolean checkPalindrome(String s){
        // base condition
        // either string is empty or string is single character
        if(s.length() == 0 || s.length() == 1){
            return true;
        }

        // Do some work
        if (s.charAt(0)== s.charAt(s.length()-1)){
            return checkPalindrome(s.substring(1,s.length()-1));
        }
        // Additional bas condition to handle non palindromes
        return false;
/*        else{
            return false;
        }*/
        /*else {
            if (s.charAt(0)== s.charAt(s.length()-1)
            && checkPalindrome(s.substring(1,s.length()-1))){
                return true;
            }
            else {
                return false;
            }
        }
*/
    }

    public static void main(String[] args) {
        System.out.println("Checking given string is palindrome or not");
        if (checkPalindrome("kayak")){
            System.out.println("YES");
        }
        else {
            System.out.println( "NO !!!!!");
        }
    }
}
