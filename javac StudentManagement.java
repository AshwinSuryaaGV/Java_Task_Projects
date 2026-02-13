import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {

    private int id;
    private String name;
    private int age;
    private String department;

    // Constructor
    public Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Display Student
    public void display() {
        System.out.println("--------------------------------");
        System.out.println("ID         : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Department : " + department);
    }
}


// Main Class
public class StudentManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check Duplicate ID
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        students.add(new Student(id, name, age, dept));

        System.out.println("Student Added Successfully!");
    }

    // View Students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    public static Student findStudent(int id) {

        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student Not Found!");
            return;
        }

        System.out.print("Enter New Name: ");
        s.setName(sc.nextLine());

        System.out.print("Enter New Age: ");
        s.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter New Department: ");
        s.setDepartment(sc.nextLine());

        System.out.println("Student Updated Successfully!");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);

        if (s == null) {
            System.out.println("Student Not Found!");
            return;
        }

        students.remove(s);

        System.out.println("Student Deleted Successfully!");
    }

    // Menu
    public static void showMenu() {

        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            showMenu();

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to Search: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Student s = findStudent(id);

                    if (s != null)
                        s.display();
                    else
                        System.out.println("Student Not Found!");
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank You! Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
