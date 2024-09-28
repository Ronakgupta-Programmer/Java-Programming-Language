import java.util.Scanner;

public class String_Palindrome_Checker {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        String continueChoice = "yes";  // Initialize continueChoice to enter the loop

        // Loop until the user decides to exit
        while (continueChoice.equalsIgnoreCase("yes")) {
            // Prompt the user to enter a word
            System.out.print("Enter a word to verify if it's a palindrome: ");
            String userInput = inputScanner.next();
            String reversedInput = new StringBuilder(userInput).reverse().toString();

            // Check if the word is a palindrome
            if (userInput.equalsIgnoreCase(reversedInput)) {
                System.out.println("The word " + userInput + " is a Palindrome.");
            } else {
                System.out.println("The word " + userInput + " is not a Palindrome.");
            }

            // Ask if the user wants to check another word
            System.out.print("Do you want to check another palindrome? (yes to continue, no to exit): ");
            continueChoice = inputScanner.next();
        }

        // Close the scanner
        System.out.println("Exiting the program. Goodbye!");
        inputScanner.close();
    }
}
