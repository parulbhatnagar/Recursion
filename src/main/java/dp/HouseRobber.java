package dp;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int [] nums = {2,7,9,3,1};

        HouseRobber houseRobber = new HouseRobber();
        System.out.println("Max Loot = " + houseRobber.rob(nums));
        System.out.println("Max Loot  (tabulazied) = " + houseRobber.robTabulized(nums));

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxRob(nums, nums.length-1, dp);
    }

    private int maxRob(int[] nums, int index, int[] dp) {
        // base condition
        if (index == 0 ){
            return nums[index];
        } else if (index == 1){
            return Math.max( nums[index],  nums[index-1]);
        }
        if (dp[index]!=-1){
            return dp[index];
        }
        int ifNthHouseIsRobber = nums[index] + maxRob(nums, index - 2, dp);
        int ifNMinusOnethIsRobber =  maxRob(nums, index -1, dp);

        // to maximize the loot
        dp[index] = Math.max(ifNthHouseIsRobber, ifNMinusOnethIsRobber);
        return  dp[index];
    }

    public int robTabulized(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        // base condition
        dp[0] = nums[0];
        dp[1] = Math.max (nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(
                    dp[i-2] + nums[i],
                    dp[i-1]
            );
        }

        return dp[nums.length-1];
    }

}
