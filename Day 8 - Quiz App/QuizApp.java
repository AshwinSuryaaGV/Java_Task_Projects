import java.util.Scanner;

// Question Class
class Question {

    String questionText;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    char correctAnswer;

    Question(String questionText, String optionA, String optionB,
             String optionC, String optionD, char correctAnswer) {

        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    boolean checkAnswer(char userAnswer) {
        return Character.toUpperCase(userAnswer) ==
               Character.toUpperCase(correctAnswer);
    }

    void displayQuestion() {
        System.out.println("\n" + questionText);
        System.out.println("A. " + optionA);
        System.out.println("B. " + optionB);
        System.out.println("C. " + optionC);
        System.out.println("D. " + optionD);
        System.out.print("Your Answer (A/B/C/D): ");
    }
}

// Main Class
public class QuizApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Question[] questions = {
            new Question(
                "1. What is the size of int in Java?",
                "2 bytes",
                "4 bytes",
                "8 bytes",
                "Depends on OS",
                'B'
            ),
            new Question(
                "2. Which keyword is used for inheritance?",
                "this",
                "super",
                "extends",
                "implements",
                'C'
            ),
            new Question(
                "3. Which method starts program execution?",
                "start()",
                "run()",
                "main()",
                "init()",
                'C'
            )
        };

        int score = 0;

        System.out.println("===== ONLINE QUIZ =====");

        for (int i = 0; i < questions.length; i++) {

            questions[i].displayQuestion();

            char answer = sc.next().charAt(0);

            if (questions[i].checkAnswer(answer)) {
                System.out.println("Correct! ✅");
                score++;
            } else {
                System.out.println("Wrong ❌");
            }
        }

        System.out.println("\n===== QUIZ RESULT =====");
        System.out.println("Your Score: " + score + "/" + questions.length);

        double percentage = (score * 100.0) / questions.length;
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 70) {
            System.out.println("Result: PASS 🎉");
        } else {
            System.out.println("Result: FAIL");
        }

        sc.close();
    }
}