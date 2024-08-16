package slidingwindow;

import java.util.Arrays;

/**
 * 1004. Max Consecutive Ones III
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {

        int left = 0 , right = 0 , inputLength = nums.length;
        int returnMaxLength = 0;
        int flipCounter=k;

        // traverse till right reaches length
        while (right<inputLength && left<=right){
            // matching condition expand the window
            if (nums[right]==1){
                returnMaxLength = (returnMaxLength>right-left+1 ? returnMaxLength : right-left+1) ;
                right++;
            }else if (nums[right]==0 &&flipCounter >0){
                returnMaxLength = (returnMaxLength>right-left+1 ? returnMaxLength : right-left+1) ;
                right ++;
                flipCounter--;
            }else{
                // non-matching then shrink the window
                // if outgoing is 0 then increment k as well otherwise let it be
                if (nums[left]==0 && flipCounter+1< k){
                    flipCounter++;
                }
                if (left == right){
                    right++;
                }
                left ++;
            }
        }
        return returnMaxLength;
    }

    public static void main(String[] args) {
        int [] test1={0,0,1,1,1,0,0};
        int k=0;
        System.out.println("Test 1, input  = " + Arrays.toString(test1) + "and max len = "+longestOnes(test1,k));

    }
}
