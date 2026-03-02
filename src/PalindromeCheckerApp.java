import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");

        String input = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}