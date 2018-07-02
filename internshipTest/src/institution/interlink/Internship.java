package institution.interlink;

import institution.University;
import person.Student;

import java.util.List;

public class Internship {
    private String name;
    private String students;

    public Internship(String name) {
        this.name = name;
        this.students = "There is no students";
    }

    public String getStudents() {
        return students;
    }


    public void recruitStudents(University university) {
        List<Student> studentsList = university.getStudentsList();

        if (studentsList.isEmpty()) {
            return;
        }

        double average = countAverageKnowledge(studentsList);

        StringBuilder passedStudents = new StringBuilder();
        studentsList.stream()
                .filter(student -> student.getFullExperience().getLevel() > average)
                .forEach(student -> passedStudents.append(student.getName()).append("\n"));

        students = passedStudents.toString();
    }

    private double countAverageKnowledge(List<Student> studentsList) {
        return studentsList.stream()
                .mapToDouble(student -> student.getFullExperience().getLevel())
                .average().orElse(0);
    }
}
