import java.util.Scanner;

public class Factorial_Recursive {
    // Recursive method to calculate factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: factorial of 0 or 1 is 1
        } else {
            return n * factorial(n - 1); // Recursive case
        }
    }

    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number to find its factorial: ");
        int number = scanner.nextInt();

        // Call the recursive factorial method
        long result = factorial(number);

        // Display the result
        System.out.println("Factorial of " + number + " is: " + result);

        // Close the scanner
        scanner.close();
    }
}
