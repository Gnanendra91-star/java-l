import java.util.*;

public class Solution {

    public static List<String> stringMatching(String[] words) {

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words.length; j++) {

                if (i != j && words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
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

        List<String> answer = stringMatching(words);

        for (String word : answer) {
            System.out.print(word + " ");
        }

        sc.close();
    }
}
