package dp;

import java.util.Arrays;

public class CostOfClimbingStairs {

    public static void main(String[] args) {

        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println("Total cost = " + minCostClimbingStairs(cost));
        System.out.println("Total cost (tabular) = " + minCostClimbingStairsTabular(cost));
        System.out.println("Total cost (tabular Space optimized) = " + minCostClimbingStairsTabularOptimized(cost));


    }


    public static int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
        return costCalculator(cost, cost.length , dp);
    }

    public static int costCalculator(int[] cost, int index, int []dp) {
        if (index == 0 || index == 1) {
            // zero cost
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        dp[index] = Math.min(
                (cost[index-1]) + costCalculator(cost, index - 1, dp)
                , (cost[index-2]) + costCalculator(cost, index - 2, dp));
        System.out.println(index + "->" + dp[index]);

        return dp[index];
    }

    public static int minCostClimbingStairsTabular(int[] cost) {
        int dp[] = new int[cost.length+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <=cost.length; i++) {
            dp[i] = Math.min((cost[i-1] + dp[i-1]),(cost[i-2] + dp[i-2]));
        }
        return dp[cost.length];
    }

    public static int minCostClimbingStairsTabularOptimized(int[] cost) {
        int prevMinusOne = 0;
        int prev= 0;
        int curr = -1;
        for (int i = 2; i <=cost.length; i++) {
            curr= Math.min((cost[i-1] + prev),(cost[i-2] + prevMinusOne));
            System.out.println(prevMinusOne + "->" + prev + "->" + curr);

            prevMinusOne = prev;
            prev = curr;
        }
        return curr;
    }
}
