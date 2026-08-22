import java.io.*;
import java.util.*;

public class Solution {

    static int[] log, st;

    static int[] manacher(String s) {
        int n = s.length();
        int[] d = new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d[l + r - i], r - i + 1);

            while (i - k >= 0 && i + k < n &&
                   s.charAt(i - k) == s.charAt(i + k))
                k++;

            d[i] = k - 1;   // IMPORTANT: radius used by this problem

            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }
        return d;
    }

    static void build(int[] a) {
        int n = a.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++)
            log[i] = log[i / 2] + 1;

        int k = log[n] + 1;
        st = new int[k * n];

        System.arraycopy(a, 0, st, 0, n);

        for (int j = 1; j < k; j++) {
            int len = 1 << j;
            int half = len >> 1;

            for (int i = 0; i + len <= n; i++) {
                st[j * n + i] =
                    Math.max(st[(j - 1) * n + i],
                             st[(j - 1) * n + i + half]);
            }
        }
    }

    static int query(int l, int r) {
        if (l > r) return 0;

        int n = log.length - 1;
        int k = log[r - l + 1];

        return Math.max(
            st[k * n + l],
            st[k * n + r - (1 << k) + 1]
        );
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        // Duplicate string for circular rotations
        String t = s + s;

        // Transform: #a#b#c#...
        StringBuilder p = new StringBuilder();

        for (int i = 0; i < t.length(); i++) {
            p.append('#');
            p.append(t.charAt(i));
        }
        p.append('#');

        int[] radius = manacher(p.toString());

        build(radius);

        StringBuilder out = new StringBuilder();

        for (int rotation = 0; rotation < n; rotation++) {

            int L = 2 * rotation + 1;
            int R = 2 * (rotation + n - 1) + 1;

            int lo = 1;
            int hi = n;
            int ans = 1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                int left = L + mid - 1;
                int right = R - mid + 1;

                if (left <= right && query(left, right) >= mid) {
                    ans = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}
