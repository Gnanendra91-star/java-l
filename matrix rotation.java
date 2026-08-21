import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] result = new int[m][n];
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            List<Integer> ring = new ArrayList<>();

            // Extract layer
            for (int i = top; i <= bottom; i++)
                ring.add(matrix.get(i).get(left));

            for (int j = left + 1; j <= right; j++)
                ring.add(matrix.get(bottom).get(j));

            for (int i = bottom - 1; i >= top; i--)
                ring.add(matrix.get(i).get(right));

            for (int j = right - 1; j > left; j--)
                ring.add(matrix.get(top).get(j));

            int size = ring.size();
            int index = r % size;

            // Put rotated elements back
            for (int i = top; i <= bottom; i++)
                result[i][left] = ring.get(index++ % size);

            for (int j = left + 1; j <= right; j++)
                result[bottom][j] = ring.get(index++ % size);

            for (int i = bottom - 1; i >= top; i--)
                result[i][right] = ring.get(index++ % size);

            for (int j = right - 1; j > left; j--)
                result[top][j] = ring.get(index++ % size);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);
        sc.close();
    }
}
