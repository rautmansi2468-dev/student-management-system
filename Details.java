
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int rollNo;
    String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }
}

public class Details {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    public static void addStudent() {

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.add(new Student(roll, name));

        System.out.println("Student Added Successfully!");
    }

    // Display Students
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            System.out.println(
                    "Roll No: " + s.rollNo
                    + " | Name: " + s.name);
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.print("Enter Roll Number to Search: ");
        int roll = sc.nextInt();

        boolean found = false;

        for (Student s : students) {

            if (s.rollNo == roll) {

                System.out.println("\n===== STUDENT FOUND =====");
                System.out.println("Roll No: " + s.rollNo);
                System.out.println("Name    : " + s.name);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found!");
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==========================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM");
            System.out.println("==========================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
