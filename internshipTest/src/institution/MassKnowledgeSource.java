package institution;

import person.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class MassKnowledgeSource implements KnowledgeSource {
    protected String name;
    protected List<Student> students;
    protected double practicalKnowledge = 0;
    protected double theoryKnowledge = 0;

    public MassKnowledgeSource(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void setPracticalKnowledge(double practicalKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
    }

    public void setTheoryKnowledge(double theoryKnowledge) {
        this.theoryKnowledge = theoryKnowledge;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean isPresent(Student student) {
        return students.stream()
                .anyMatch(universityStudent -> universityStudent.getName().equals(student.getName()));
    }

    @Override
    public void tutor(Student student) {
        if (isPresent(student)) {
            student.increaseTheoryKnowledge(theoryKnowledge);
            student.increasePracticalKnowledge(practicalKnowledge);
        }
    }
}
