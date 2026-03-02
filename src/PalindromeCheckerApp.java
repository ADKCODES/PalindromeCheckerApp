public class PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");

        String input = "madam";
        String reversed = "";

        // Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i); // String Concatenation
        }

        // Compare original and reversed using equals()
        if (input.equals(reversed)) {
            System.out.println("Input text: " + input);
            System.out.println("Reversed text: " + reversed);
            System.out.println("Is it a Palindrome? : true");
        } else {
            System.out.println("Input text: " + input);
            System.out.println("Reversed text: " + reversed);
            System.out.println("Is it a Palindrome? : false");
        }
    }
}