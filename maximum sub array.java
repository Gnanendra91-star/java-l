import java.util.*;

public class Solution {

    public static int[] maxSubarray(int[] arr) {

        // Maximum subarray sum (Kadane's algorithm)
        int current = arr[0];
        int maxSubarray = arr[0];

        // Maximum subsequence sum
        int maxElement = arr[0];
        int maxSubsequence = 0;

        for (int i = 0; i < arr.length; i++) {

            // Kadane's algorithm
            if (i > 0) {
                current = Math.max(arr[i], current + arr[i]);
                maxSubarray = Math.max(maxSubarray, current);
            }

            // Find largest element
            maxElement = Math.max(maxElement, arr[i]);

            // Add positive elements
            if (arr[i] > 0) {
                maxSubsequence += arr[i];
            }
        }

        // If everything is negative, choose the largest element
        if (maxSubsequence == 0) {
            maxSubsequence = maxElement;
        }

        return new int[]{maxSubarray, maxSubsequence};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] result = maxSubarray(arr);

            System.out.println(result[0] + " " + result[1]);
        }

        sc.close();
    }
}
