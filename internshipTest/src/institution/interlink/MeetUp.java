package institution.interlink;

import institution.KnowledgeSource;
import person.Student;

public class MeetUp implements KnowledgeSource {
    private boolean isInteractive = false;
    private boolean isPractical = false;
    private double interactiveCoefficient = 2;
    private double practicalKnowledge;
    private double theoryKnowledge;
    private String name;

    public MeetUp(String name) {
        this.name = name;
        practicalKnowledge = 20;
        theoryKnowledge = 10;
    }

    public void setInteractive(boolean interactive) {
        isInteractive = interactive;
    }

    public void setPractical(boolean practical) {
        isPractical = practical;
    }

    public double getInteractiveCoefficient() {
        return interactiveCoefficient;
    }

    public void setInteractiveCoefficient(double interactiveCoefficient) {
        this.interactiveCoefficient = interactiveCoefficient;
    }

    public void setPracticalKnowledge(double practicalKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
    }

    public void setTheoryKnowledge(double theoryKnowledge) {
        this.theoryKnowledge = theoryKnowledge;
    }

    @Override
    public void tutor(Student student) {
        if (isPractical && student.hasNotebook()) {
            student.increasePracticalKnowledge(practicalKnowledge);
        }

        if (isInteractive) {
            student.increaseTheoryKnowledge(theoryKnowledge * interactiveCoefficient);
            return;
        }

        student.increaseTheoryKnowledge(theoryKnowledge);
    }
}
