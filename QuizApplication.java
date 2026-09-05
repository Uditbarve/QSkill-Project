import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

    static Scanner sc = new Scanner(System.in);
    static int score = 0;
    static boolean timeUp = false;

    public static void main(String[] args) {

        String[] questions = {
                "1. Which language is used for Android Development?",
                "2. Which keyword is used to inherit a class in Java?",
                "3. Which company developed Java?",
                "4. Which method is the entry point of a Java program?",
                "5. Which collection allows duplicate elements?"
        };

        String[][] options = {
                {"A. Java", "B. Python", "C. C", "D. PHP"},
                {"A. this", "B. implements", "C. extends", "D. import"},
                {"A. Microsoft", "B. Sun Microsystems", "C. Google", "D. IBM"},
                {"A. run()", "B. start()", "C. main()", "D. init()"},
                {"A. Set", "B. HashSet", "C. ArrayList", "D. TreeSet"}
        };

        char[] answers = {'A', 'C', 'B', 'C', 'C'};
        char[] userAnswers = new char[questions.length];

        System.out.println("===== Welcome to Java Quiz =====");

        for (int i = 0; i < questions.length; i++) {

            timeUp = false;

            System.out.println("\n" + questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            Timer timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's Up!");
                }
            }, 10000); // 10 seconds

            System.out.print("Enter your answer (A/B/C/D): ");

            long start = System.currentTimeMillis();
            String input = sc.nextLine();
            long end = System.currentTimeMillis();

            timer.cancel();

            if ((end - start) > 10000 || timeUp || input.isEmpty()) {
                userAnswers[i] = '-';
                System.out.println("Answer not accepted.");
            } else {
                userAnswers[i] = Character.toUpperCase(input.charAt(0));

                if (userAnswers[i] == answers[i]) {
                    score++;
                }
            }
        }

        // Result
        System.out.println("\n===== Quiz Result =====");
        System.out.println("Total Questions : " + questions.length);
        System.out.println("Correct Answers : " + score);
        System.out.println("Wrong Answers   : " + (questions.length - score));
        System.out.println("Final Score     : " + score + "/" + questions.length);

        System.out.println("\n===== Answer Summary =====");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1));

            System.out.println("Your Answer    : " + userAnswers[i]);
            System.out.println("Correct Answer : " + answers[i]);

            if (userAnswers[i] == answers[i]) {
                System.out.println("Result : Correct");
            } else {
                System.out.println("Result : Incorrect");
            }
        }

        sc.close();
    }
}