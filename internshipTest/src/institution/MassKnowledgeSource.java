package institution;

import person.Student;

import java.util.ArrayList;
import java.util.List;

public abstract class MassKnowledgeSource {
    protected List<Student> studentsList = new ArrayList<>();
    protected double practicalKnowledge = 0;
    protected double theoryKnowledge = 0;

    public void setPracticalKnowledge(double practicalKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
    }

    public void setTheoryKnowledge(double theoryKnowledge) {
        this.theoryKnowledge = theoryKnowledge;
    }
}
