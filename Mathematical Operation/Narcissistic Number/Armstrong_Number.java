import java.util.Scanner;

public class Armstrong_Number {
    public static void main(String[] args) {
        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number to check if it's an Armstrong number: ");
        int number = scanner.nextInt();

        // Call the method to check if the number is an Armstrong number
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        // Close the scanner
        scanner.close();
    }

    // Method to check if a number is an Armstrong number
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int numDigits = String.valueOf(number).length(); // Find the number of digits

        // Calculate the sum of digits each raised to the power of numDigits
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, numDigits); // Raise digit to the power of numDigits and add to sum
            number /= 10;
        }

        // Check if the sum is equal to the original number
        return sum == originalNumber;
    }
}
