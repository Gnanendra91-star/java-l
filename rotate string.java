import java.util.*;

public class Solution {

    public static boolean rotateString(String s, String goal) {

        // Different lengths can never match
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is a rotation of s
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String goal = sc.nextLine();

        System.out.println(rotateString(s, goal));

        sc.close();
    }
}
