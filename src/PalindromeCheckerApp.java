import java.util.Stack;
import java.util.Scanner;

public class UseCase12PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.check(input);
    }

    public static void main(String[] args) {
        UseCase12PalindromeCheckerApp app = new UseCase12PalindromeCheckerApp();
        Scanner scanner = new Scanner(System.in);

        app.setStrategy(new StackStrategy());

        System.out.print("Input : ");
        String input = scanner.nextLine();

        boolean isPalindrome = app.validate(input);
        System.out.println("Is Palindrome? : " + isPalindrome);

        scanner.close();
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}