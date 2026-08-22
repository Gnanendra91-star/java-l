import java.util.*;

public class Solution {

    public static long stringSimilarity(String s) {

        int n = s.length();

        int[] z = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {

            // If i is inside the current Z-box
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            // Extend the match
            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            // Update Z-box
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        long answer = n; // z[0] = n

        for (int i = 1; i < n; i++) {
            answer += z[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            System.out.println(stringSimilarity(s));
        }

        sc.close();
    }
}
