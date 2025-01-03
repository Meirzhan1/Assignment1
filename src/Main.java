import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String studentsFilePath = "C:\\Users\\Asus\\IdeaProjects\\Assignment1\\src\\students.txt";
        String teachersFilePath = "C:\\Users\\Asus\\IdeaProjects\\Assignment1\\src\\teachers.txt";

        School school = new School();

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
                Student student = new Student(name, surname, age, gender, grades);
                school.addMember(student);
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
                    teacher.giveRaise(10);
                }
                school.addMember(teacher);
            }

            System.out.println("Task 3: Class Relationships");
            System.out.println(school);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }
}
