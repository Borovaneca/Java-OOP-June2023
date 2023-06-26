package WorkingWithAbstraction.Lab.StudentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();
        executeProgram(scanner, studentsList);
    }

    private static void executeProgram(Scanner scanner, List<Student> studentsList) {
        String input = scanner.nextLine();

        while (!"Exit".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    addStudent(studentsList, tokens);
                    break;

                case "Show":
                    String nameToCheck = tokens[1];
                    printStudentIfExist(studentsList, nameToCheck);
                    break;
            }


            input = scanner.nextLine();
        }
    }

    private static void addStudent(List<Student> studentsList, String[] tokens) {
        String nameStudent = tokens[1];
        int ageStudent = Integer.parseInt(tokens[2]);
        double gradeStudent = Double.parseDouble(tokens[3]);
        Student currentStudent = new Student(nameStudent, ageStudent, gradeStudent);
        studentsList.add(currentStudent);
    }

    private static void printStudentIfExist(List<Student> studentsList, String nameToCheck) {
        StringBuilder sb = new StringBuilder();
        for (Student student : studentsList) {
            if (student.getName().equals(nameToCheck)) {
                printStudent(sb, student);
                System.out.println(sb.toString());
                break;
            }
        }
    }

    private static void printStudent(StringBuilder sb, Student student) {
        sb.append(String.format("%s is %d years old.", student.getName(), student.getAge()));

        if (student.getGrade() >= 5.00) {
            sb.append(" Excellent student.");
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            sb.append(" Average student.");
        } else {
            sb.append(" Very nice person.");
        }
    }
}
