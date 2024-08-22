package dp;

public class Kadane {

    public int maxSubArray(int[] nums) {

        int sum = 0, maxSum=-10000;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxSum < sum){
                maxSum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubarraySumCircular(int[] nums) {

        // two possible approached
        // 1. duplicate the array and make it a max window size = n sliding window problem
        // 2. Max Sum sub array = Total sum - min sum array (inverse of kadane)

        int sum = 0, maxSum=-30000;
        int start = 0, end = 0;
        int secondEndOfArray = 0;

        for (int i = 0; start < nums.length && secondEndOfArray <= 1; i++) {
            if (i==nums.length){
                i = 0;
                secondEndOfArray++;
            }
            if (sum == 0){
                start = i;
                end = i;
            }
            sum += nums[i];
            if (maxSum < sum){
                maxSum = sum;
                end = i;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {5,-3,5};
        Kadane kadane = new Kadane();
        System.out.println(kadane.maxSubArray(nums));

        System.out.println(kadane.maxSubarraySumCircular(nums));
    }
}
