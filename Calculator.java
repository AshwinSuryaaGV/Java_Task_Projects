import java.util.Scanner;

public class Calculator {

    // Addition
    static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    static String divide(double a, double b) {
        if (b == 0) {
            return "Error: Division by zero is not allowed";
        }
        return String.valueOf(a / b);
    }

    // Modulo
    static String modulo(double a, double b) {
        if (b == 0) {
            return "Error: Modulo by zero is not allowed";
        }
        return String.valueOf(a % b);
    }

    // Square
    static double square(double a) {
        return a * a;
    }

    // Menu
    static void showMenu() {
        System.out.println("\n===== Calculator Menu =====");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulo (%)");
        System.out.println("6. Square (x²)");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Java CLI Calculator");

        while (true) {

            showMenu();

            System.out.print("Enter your choice (1-7): ");
            int choice = sc.nextInt();

            if (choice == 7) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            }

            try {

                double num1, num2;

                if (choice == 6) {
                    // Square needs only one number
                    System.out.print("Enter number: ");
                    num1 = sc.nextDouble();

                    double result = square(num1);
                    System.out.println("Result: " + result);
                }

                else if (choice >= 1 && choice <= 5) {

                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();

                    switch (choice) {

                        case 1:
                            System.out.println("Result: " + add(num1, num2));
                            break;

                        case 2:
                            System.out.println("Result: " + subtract(num1, num2));
                            break;

                        case 3:
                            System.out.println("Result: " + multiply(num1, num2));
                            break;

                        case 4:
                            System.out.println("Result: " + divide(num1, num2));
                            break;

                        case 5:
                            System.out.println("Result: " + modulo(num1, num2));
                            break;
                    }

                } else {
                    System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: Please enter valid numbers.");
                sc.next(); // clear invalid input
            }

        }

        sc.close();
    }
}
