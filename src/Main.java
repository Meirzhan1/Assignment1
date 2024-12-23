import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String studentsFilePath = "C:\\Users\\Asus\\IdeaProjects\\Assignment1\\src\\students.txt";
        String teachersFilePath = "C:\\Users\\Asus\\IdeaProjects\\Assignment1\\src\\teachers.txt";

        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        try {
            List<String> studentLines = Files.readAllLines(Paths.get(studentsFilePath));
            for (String line : studentLines) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                List<Integer> grades = new ArrayList<>();
                for (int i = 4; i < parts.length; i++) {
                    grades.add(Integer.parseInt(parts[i]));
                }
                students.add(new Student(name, surname, age, gender, grades));
            }

            List<String> teacherLines = Files.readAllLines(Paths.get(teachersFilePath));
            for (String line : teacherLines) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String surname = parts[1];
                int age = Integer.parseInt(parts[2]);
                boolean gender = parts[3].equalsIgnoreCase("Male");
                String subject = parts[4];
                int yearsOfExperience = Integer.parseInt(parts[5]);
                int salary = Integer.parseInt(parts[6]);
                Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

                if (yearsOfExperience > 10) {
                    teacher.giveRaise(10); // Повышение на 10%
                }
                teachers.add(teacher);
            }

            System.out.println("Students:");
            for (Student student : students) {
                System.out.println(student);
                System.out.println("GPA: " + student.calculateGPA());
            }

            System.out.println("\nTeachers:");
            for (Teacher teacher : teachers) {
                System.out.println(teacher);
            }

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
