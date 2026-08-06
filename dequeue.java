import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            // Add current element
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Remove element if window size exceeds m
            if (deque.size() > m) {
                int removed = deque.removeFirst();
                map.put(removed, map.get(removed) - 1);

                if (map.get(removed) == 0) {
                    map.remove(removed);
                }
            }

            // Update maximum unique count
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
            }
        }

        System.out.println(maxUnique);

        sc.close();
    }
}
