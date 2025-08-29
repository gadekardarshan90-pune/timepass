import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many subjects do you have? ");
        int subjectCount = scanner.nextInt();

        int total = 0;

        for (int i = 1; i <= subjectCount; i++) {
            int score;

            while (true) {
                System.out.print("Enter marks for subject " + i + " (0–100): ");
                score = scanner.nextInt();

                if (score >= 0 && score <= 100) {
                    break;
                }

                System.out.println("Invalid input. Please enter a number between 0 and 100.");
            }

            total += score;
        }

        double average = (double) total / subjectCount;
        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n=== Final Results ===");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
