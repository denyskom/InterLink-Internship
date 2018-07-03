package institution;

import person.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class MassKnowledgeSource {
    protected String name;
    protected List<Student> studentsList;
    protected double practicalKnowledge = 0;
    protected double theoryKnowledge = 0;

    public MassKnowledgeSource(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
    }

    public void setPracticalKnowledge(double practicalKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
    }

    public void setTheoryKnowledge(double theoryKnowledge) {
        this.theoryKnowledge = theoryKnowledge;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public boolean isPresent(Student student) {
        return studentsList.stream()
                .anyMatch(universityStudent -> universityStudent.getName().equals(student.getName()));
    }
}
