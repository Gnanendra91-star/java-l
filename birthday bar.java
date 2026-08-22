import java.io.*;
import java.util.*;

public class Solution {

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int sum = 0;

        // Calculate the sum of the first window
        for (int i = 0; i < m; i++) {
            sum += s.get(i);
        }

        if (sum == d) {
            count++;
        }

        // Slide the window
        for (int i = m; i < s.size(); i++) {
            sum += s.get(i);
            sum -= s.get(i - m);

            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        String[] input = br.readLine().trim().split(" ");
        List<Integer> s = new ArrayList<>();

        for (String value : input) {
            s.add(Integer.parseInt(value));
        }

        String[] dm = br.readLine().trim().split(" ");
        int d = Integer.parseInt(dm[0]);
        int m = Integer.parseInt(dm[1]);

        System.out.println(birthday(s, d, m));
    }
}
