package institution.interlink;

import institution.KnowledgeSource;
import institution.MassKnowledgeSource;
import institution.University;
import person.Student;

import java.util.ArrayList;
import java.util.List;

public class Internship extends MassKnowledgeSource implements KnowledgeSource {

    private String students;

    public Internship(String name) {
        super(name);
        this.students = "There is no students";
        super.practicalKnowledge = 10;
        super.theoryKnowledge = 3;
    }

    public String getStudents() {
        return students;
    }


    public void recruitStudents(University university) {
        this.studentsList = new ArrayList<>();
        List<Student> studentsList = university.getStudentsList();

        if (studentsList.isEmpty()) {
            return;
        }

        double average = countAverageKnowledge(studentsList);

        StringBuilder passedStudents = new StringBuilder();
        studentsList.stream()
                .filter(student -> student.getFullExperience().getLevel() > average)
                .forEach(student -> {
                    passedStudents.append(student.getName()).append("\n");
                    this.studentsList.add(student);

                });

        students = passedStudents.toString();
    }

    private double countAverageKnowledge(List<Student> studentsList) {
        return studentsList.stream()
                .mapToDouble(student -> student.getFullExperience().getLevel())
                .average().orElse(0);
    }

}
