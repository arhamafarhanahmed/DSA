public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";  // Example string

        boolean isPalindrome = true;  // Flag to track if the string is a palindrome

        // Loop to compare characters from both ends
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;  // Set the flag to false if characters don't match
                break;  // Exit the loop if the string is not a palindrome
            }
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}