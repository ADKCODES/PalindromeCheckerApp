import java.util.Stack;
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {
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
        UseCase13PalindromeCheckerApp app = new UseCase13PalindromeCheckerApp();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Testing Stack Strategy
        app.setStrategy(new StackStrategy());
        long startStack = System.nanoTime();
        boolean isPalindromeStack = app.validate(input);
        long endStack = System.nanoTime();

        System.out.println("Is Palindrome? : " + isPalindromeStack);
        System.out.println("Execution Time (Stack): " + (endStack - startStack) + " ns");

        // Testing Two-Pointer Strategy (For Comparison)
        app.setStrategy(new TwoPointerStrategy());
        long startTP = System.nanoTime();
        app.validate(input);
        long endTP = System.nanoTime();

        System.out.println("Execution Time (Two-Pointer): " + (endTP - startTP) + " ns");

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

class TwoPointerStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}