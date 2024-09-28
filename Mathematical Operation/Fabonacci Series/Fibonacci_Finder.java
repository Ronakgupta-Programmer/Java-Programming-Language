import java.util.Scanner;

public class Fibonacci_Finder {
    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of terms
        System.out.print("Enter the number of terms for Fibonacci series: ");
        int terms = scanner.nextInt();

        // Variables to store the first two numbers in the series
        int first = 0, second = 1;

        // Display the first two terms
        System.out.println("Fibonacci series:");
        System.out.print(first + " " + second);

        // Calculate and display the Fibonacci series
        for (int i = 2; i < terms; i++) {
            int next = first + second;
            System.out.print(" " + next);
            first = second;
            second = next;
        }
        
        // Close the scanner
        scanner.close();
    }
}
