import java.util.*;

public class Solution {

    public static boolean repeatedSubstringPattern(String s) {

        String doubled = s + s;

        return doubled.substring(1, doubled.length() - 1).contains(s);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(repeatedSubstringPattern(s));

        sc.close();
    }
}
