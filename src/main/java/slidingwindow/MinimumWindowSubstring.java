package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        Map<Character, Integer> sourceMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            if(sourceMap.get(t.charAt(i))==null){
                sourceMap.put(t.charAt(i),1);
            } else{
                sourceMap.put(t.charAt(i),sourceMap.get(t.charAt(i))+1);
            }
        }
        int left=0, right=0, startIndex=0, endIndex=0;

        while (left <= right && right <=s.length()){

            if (sourceMap.get(s.charAt(right))!= null){
                if (sourceMap.get(s.charAt(right))>1){
                    sourceMap.put(s.charAt(right), sourceMap.get(s.charAt(right)-1));
                }
                else{
                    sourceMap.remove(s.charAt(right));
                }
                right++;
            }
            else {
                left++;right++;
            }
            if(sourceMap.isEmpty()){
                break;
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s,t));
    }
}
