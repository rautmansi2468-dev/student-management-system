
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int rollNo;
    String name;
    int marks;
    String grade;

    Student(int rollNo, String name, int marks) {

        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;

        if (marks >= 90) {
            grade = "A+";
        } else if (marks >= 80) {
            grade = "A";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 60) {
            grade = "C";
        } else {
            grade = "Fail";
        }
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

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        students.add(new Student(roll, name, marks));

        System.out.println("Student Added Successfully!");
    }

    // Display Students
    public static void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Available.");
            return;
        }

        System.out.println("\n========== STUDENT LIST ==========");

        for (Student s : students) {

            System.out.println(
                    "Roll No: " + s.rollNo
                    + " | Name: " + s.name
                    + " | Marks: " + s.marks
                    + " | Grade: " + s.grade);
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.print("Enter Roll Number to Search: ");
        int roll = sc.nextInt();

        for (Student s : students) {

            if (s.rollNo == roll) {

                System.out.println("\n===== STUDENT FOUND =====");
                System.out.println("Roll No : " + s.rollNo);
                System.out.println("Name    : " + s.name);
                System.out.println("Marks   : " + s.marks);
                System.out.println("Grade   : " + s.grade);

                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Roll Number to Delete: ");
        int roll = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).rollNo == roll) {

                students.remove(i);

                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Roll Number to Update: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.rollNo == roll) {

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Marks: ");
                int newMarks = sc.nextInt();

                s.name = newName;
                s.marks = newMarks;

                if (newMarks >= 90) {
                    s.grade = "A+";
                } else if (newMarks >= 80) {
                    s.grade = "A";
                } else if (newMarks >= 70) {
                    s.grade = "B";
                } else if (newMarks >= 60) {
                    s.grade = "C";
                } else {
                    s.grade = "Fail";
                }

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

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
                    deleteStudent();
                    break;

                case 5:
                    updateStudent();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
