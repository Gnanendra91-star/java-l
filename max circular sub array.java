import java.util.*;

public class Solution {

    public static int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            totalSum += nums[i];

            if (i > 0) {
                // Maximum subarray
                currentMax = Math.max(nums[i], currentMax + nums[i]);
                maxSum = Math.max(maxSum, currentMax);

                // Minimum subarray
                currentMin = Math.min(nums[i], currentMin + nums[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }

        // If all elements are negative, wrapping would mean
        // choosing an empty subarray, which is not allowed.
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum wrapping subarray
        int circularSum = totalSum - minSum;

        return Math.max(maxSum, circularSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(maxSubarraySumCircular(nums));

        sc.close();
    }
}
