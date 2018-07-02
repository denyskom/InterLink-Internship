package institution.interlink;

import institution.KnowledgeSource;
import institution.MassKnowledgeSource;
import person.Student;

public class MeetUp extends MassKnowledgeSource implements KnowledgeSource {
    private boolean isInteractive = false;
    private boolean isPractical = false;
    private double interactiveCoefficient = 2;

    public MeetUp(String name) {
        super(name);
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

    @Override
    public void tutor(Student student) {
        if(isPractical && student.hasNotebook()) {
            student.increasePracticalKnowledge(practicalKnowledge);
        }

        if(isInteractive) {
            student.increaseTheoryKnowledge(theoryKnowledge * interactiveCoefficient);
            return;
        }

        student.increaseTheoryKnowledge(theoryKnowledge);
    }
}
