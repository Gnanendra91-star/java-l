import java.util.*;

public class Solution {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {

            // Add current character
            windowCount[s.charAt(i) - 'a']++;

            // Remove character outside the window
            if (i >= windowSize) {
                windowCount[s.charAt(i - windowSize) - 'a']--;
            }

            // Compare frequencies
            if (i >= windowSize - 1 && Arrays.equals(pCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String p = sc.nextLine();

        List<Integer> result = findAnagrams(s, p);

        System.out.println(result);

        sc.close();
    }
}
