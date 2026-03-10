class PalindromeService {
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = cleanInput.length() - 1;

        while (start < end) {
            if (cleanInput.charAt(start) != cleanInput.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

public class UseCase11PalindromeCheckerApp {
    public static void main(String[] args) {
        PalindromeService service = new PalindromeService();

        String[] testStrings = {"madam", "java", "Race Car"};

        for (String str : testStrings) {
            System.out.println(str + ": " + service.checkPalindrome(str));
        }
    }
}