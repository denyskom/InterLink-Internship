package institution;

import person.Student;

import java.util.List;

public abstract class MassKnowledgeSource {
    protected List<Student> studentsList;
    protected double practicalKnowledge;
    protected double theoryKnowledge;

    public void setPracticalKnowledge(double practicalKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
    }

    public void setTheoryKnowledge(double theoryKnowledge) {
        this.theoryKnowledge = theoryKnowledge;
    }
}
