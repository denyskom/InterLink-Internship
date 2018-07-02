package institution;

import person.Student;

import java.util.ArrayList;
import java.util.List;

public class University extends MassKnowledgeSource implements KnowledgeSource {
    private String name;
//    private List<Student> studentsList;

    public University(String name) {
        this.name = name;
        this.studentsList = new ArrayList<>();
        super.practicalKnowledge = 250;
        super.theoryKnowledge = 1000;
    }

    public University(String name, double practicalKnowledge, double theoryKnowledge ) {
        this.name = name;
        this.studentsList = new ArrayList<>();
        super.practicalKnowledge = practicalKnowledge;
        super.theoryKnowledge = theoryKnowledge;
    }



    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }



    private boolean isPresent(Student student) {
        return studentsList.stream()
                .anyMatch(universityStudent -> universityStudent.getName().equals(student.getName()));
    }


    @Override
    public void tutor(Student student) {
        student.increasePracticalKnowledge(practicalKnowledge);
        student.increaseTheoryKnowledge(theoryKnowledge);
    }
}
