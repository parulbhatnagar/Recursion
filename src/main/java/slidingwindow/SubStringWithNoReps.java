package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubStringWithNoReps {

    /**
     * 3. Longest Substring Without Repeating Characters
     * Solved
     * Medium
     * Topics
     * Companies
     * Hint
     * Given a string s, find the length of the longest
     * substring
     *  without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     *
     * Constraints:
     *
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     */

    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, length = s.length();
        int maxLength = 0;
        Map<Character,Integer> uniqueCharMap = new HashMap<>();
        while (right < s.length()& left <= right){
            // check for unique condition
            if (uniqueCharMap.get(s.charAt(right)) == null){ // expand the window
                uniqueCharMap.put(s.charAt(right),1);
                maxLength = maxLength>(right-left+1)?maxLength:right-left+1;
                right++;
            }
            else { // failed condition move left forward
                uniqueCharMap.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String test1="abcabcbb", test2="bbbbb", test3="pwwkew";

//        System.out.println("Test 1, input string = " + test1 + "and max len = "+lengthOfLongestSubstring(test1));
//        System.out.println("Test 2, input string = " + test2 + "and max len = "+lengthOfLongestSubstring(test2));
        System.out.println("Test 3, input string = " + test3 + "and max len = "+lengthOfLongestSubstring(test3));
    }
}
