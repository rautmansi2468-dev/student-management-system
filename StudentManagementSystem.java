
import java.io.*;
import java.util.*;

class Student {

    int rollNo;
    String name;
    int math, science, english;
    int total;
    double percentage;
    String grade;

    public Student(int rollNo, String name, int math, int science, int english) {
        this.rollNo = rollNo;
        this.name = name;
        this.math = math;
        this.science = science;
        this.english = english;

        calculateResult();
    }

    void calculateResult() {
        total = math + science + english;
        percentage = total / 3.0;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else {
            grade = "F";
        }
    }

    public String toCSV() {
        return rollNo + "," + name + "," + math + "," + science + "," + english + "," + total + "," + percentage + "," + grade;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
        System.out.println("Math   : " + math);
        System.out.println("Science: " + science);
        System.out.println("English: " + english);
        System.out.println("Total  : " + total);
        System.out.println("Percent: " + percentage);
        System.out.println("Grade  : " + grade);
        System.out.println("------------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Math Marks: ");
        int m = sc.nextInt();

        System.out.print("Enter Science Marks: ");
        int s = sc.nextInt();

        System.out.print("Enter English Marks: ");
        int e = sc.nextInt();

        students.add(new Student(roll, name, m, s, e));
        System.out.println("Student Added Successfully!");
    }

    public static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // ⭐ VERSION 7 FEATURE - SAVE TO FILE
    public static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("students.txt");

            for (Student s : students) {
                fw.write(s.toCSV() + "\n");
            }

            fw.close();
            System.out.println("Data saved to file successfully!");

        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("\n===== STUDENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Save Data to File");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    saveToFile();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
