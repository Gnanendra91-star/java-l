import java.util.*;

public class Solution {

    public static boolean matches(String word, String pattern) {

        // pattern -> word
        Map<Character, Character> map1 = new HashMap<>();

        // word -> pattern
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // Check pattern -> word mapping
            if (map1.containsKey(p)) {
                if (map1.get(p) != w) {
                    return false;
                }
            } else {
                map1.put(p, w);
            }

            // Check word -> pattern mapping
            if (map2.containsKey(w)) {
                if (map2.get(w) != p) {
                    return false;
                }
            } else {
                map2.put(w, p);
            }
        }

        return true;
    }

    public static List<String> findAndReplacePattern(
            String[] words, String pattern) {

        List<String> answer = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                answer.add(word);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String pattern = sc.next();

        List<String> answer =
                findAndReplacePattern(words, pattern);

        for (String word : answer) {
            System.out.print(word + " ");
        }

        sc.close();
    }
}
