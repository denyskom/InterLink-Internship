package institution.interlink;

import institution.KnowledgeSource;
import institution.MassKnowledgeSource;
import institution.University;
import person.Student;

import java.util.ArrayList;
import java.util.List;

public class Internship extends MassKnowledgeSource implements KnowledgeSource {

    public Internship(String name) {
        super(name);
        super.practicalKnowledge = 10;
        super.theoryKnowledge = 3;
    }


    public void recruitStudents(University university) {
        this.students = new ArrayList<>();
        List<Student> studentsList = university.getStudents();

        if (studentsList.isEmpty()) {
            return;
        }

        double average = countAverageKnowledge(studentsList);
        studentsList.stream()
                .filter(student -> student.getFullExperience().getLevel() > average)
                .forEach(student ->
                    this.students.add(student));
    }

    private double countAverageKnowledge(List<Student> studentsList) {
        return studentsList.stream()
                .mapToDouble(student -> student.getFullExperience().getLevel())
                .average().orElse(0);
    }

}
