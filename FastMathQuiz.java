package work;
import java.util.Random;
import java.util.Scanner;

public class FastMathQuiz {
    public static void main(String[] args) {
        final int TOTAL_QUESTIONS = 100;
        int correctAnswers = 0;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Fast Math Quiz!");
        System.out.println("You will be asked 100 random math questions.");
        System.out.println("Select the type of math questions you want to practice:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Mix of all");
        System.out.print("Enter your choice (1-5): ");

        int choice = scanner.nextInt();

        System.out.println("Let's start!");

        // Loop through 100 questions
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            // Initialize variables to be used in the switch statement
            int num1 = 0, num2 = 0, correctAnswer = 0;
            String operation = "";

            // Determine question type based on user choice
            int questionType = (choice == 5) ? random.nextInt(4) : (choice - 1);

            switch (questionType) {
                case 0: // Addition
                    num1 = random.nextInt(100) + 1;
                    num2 = random.nextInt(100) + 1;
                    correctAnswer = num1 + num2;
                    operation = "+";
                    break;
                case 1: // Subtraction
                    num1 = random.nextInt(100) + 1;
                    num2 = random.nextInt(100) + 1;
                    // Ensure num1 is greater to avoid negative results
                    if (num2 > num1) {
                        int temp = num1;
                        num1 = num2;
                        num2 = temp;
                    }
                    correctAnswer = num1 - num2;
                    operation = "-";
                    break;
                case 2: // Multiplication
                    num1 = random.nextInt(12) + 1;
                    num2 = random.nextInt(12) + 1;
                    correctAnswer = num1 * num2;
                    operation = "x";
                    break;
                case 3: // Division
                    num1 = random.nextInt(12) + 1;
                    num2 = random.nextInt(12) + 1;
                    // Ensure whole number result for division
                    int product = num1 * num2; // This is the product
                    num1 = product; // The product becomes the dividend
                    correctAnswer = num1 / num2; // The division yields one of the factors
                    operation = "/";
                    break;
                default:
                    System.out.println("Invalid choice. Please restart the quiz.");
                    return;
            }

            // Ask the question
            System.out.printf("Question %d: What is %d %s %d? ", i + 1, num1, operation, num2);

            // Capture the user's answer
            int userAnswer = scanner.nextInt();

            // Check if the answer is correct
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("Wrong! The correct answer is %d.\n", correctAnswer);
            }
        }

        // Calculate the percentage score
        double percentage = ((double) correctAnswers / TOTAL_QUESTIONS) * 100;

        // Provide the final score
        System.out.printf("Quiz complete! You got %d out of %d correct.\n", correctAnswers, TOTAL_QUESTIONS);
        System.out.printf("Your score: %.2f%%\n", percentage);

        // Optionally, you could provide a grade based on the percentage
        if (percentage >= 90) {
            System.out.println("Grade: A");
        } else if (percentage >= 80) {
            System.out.println("Grade: B");
        } else if (percentage >= 70) {
            System.out.println("Grade: C");
        } else if (percentage >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }

        scanner.close();
    }
}
