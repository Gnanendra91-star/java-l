import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Store one layer
            List<Integer> values = new ArrayList<>();

            // Left column: top -> bottom
            for (int i = top; i <= bottom; i++) {
                values.add(matrix[i][left]);
            }

            // Bottom row: left+1 -> right
            for (int j = left + 1; j <= right; j++) {
                values.add(matrix[bottom][j]);
            }

            // Right column: bottom-1 -> top
            for (int i = bottom - 1; i >= top; i--) {
                values.add(matrix[i][right]);
            }

            // Top row: right-1 -> left+1
            for (int j = right - 1; j > left; j--) {
                values.add(matrix[top][j]);
            }

            int len = values.size();
            int shift = r % len;

            int index = 0;

            // Put rotated values back

            // Left column
            for (int i = top; i <= bottom; i++) {
                matrix[i][left] = values.get((index + shift) % len);
                index++;
            }

            // Bottom row
            for (int j = left + 1; j <= right; j++) {
                matrix[bottom][j] = values.get((index + shift) % len);
                index++;
            }

            // Right column
            for (int i = bottom - 1; i >= top; i--) {
                matrix[i][right] = values.get((index + shift) % len);
                index++;
            }

            // Top row
            for (int j = right - 1; j > left; j--) {
                matrix[top][j] = values.get((index + shift) % len);
                index++;
            }
        }

        // Print result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}
