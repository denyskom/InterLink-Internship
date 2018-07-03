package person;

import institution.KnowledgeSource;
import person.consciousness.Knowledge;

public class Student implements KnowledgeSource {
    private String name;
    private Knowledge practicalKnowledge;
    private Knowledge theoryKnowledge;
    private double maxGivenKnowledge = 3;
    private double skillCoefficient = 0.5;
    private boolean hasNotebook = true;

    public Student(String name) {
        this.name = name;
        this.practicalKnowledge = new Knowledge(0);
        this.theoryKnowledge = new Knowledge(0);
    }

    public Student(String name, double practical, double theory) {
        this.name = name;
        this.practicalKnowledge = new Knowledge(practical);
        this.theoryKnowledge = new Knowledge(theory);
    }

    public void setSkillCoefficient(double skillCoefficient) {
        this.skillCoefficient = skillCoefficient;
    }

    public void setHasNotebook(boolean hasNotebook) {
        this.hasNotebook = hasNotebook;
    }

    public void setMaxGivenKnowledge(double maxGivenKnowledge) {
        this.maxGivenKnowledge = maxGivenKnowledge;
    }

    public String getName() {
        return name;
    }

    public Knowledge getFullExperience() {
        return new Knowledge(practicalKnowledge.getLevel() * 2 + theoryKnowledge.getLevel());
    }


    public void increasePracticalKnowledge(double level) {
        practicalKnowledge.increaseKnowledge(level * skillCoefficient);
    }

    public void increaseTheoryKnowledge(double level) {
        theoryKnowledge.increaseKnowledge(level * skillCoefficient);
    }

    public boolean hasNotebook() {
        return hasNotebook;
    }

    private double getGivenKnowledge(double knowledge){
        double knowledgePercentage = knowledge * 0.1;
        if (maxGivenKnowledge > knowledgePercentage){
            return knowledgePercentage;
        }
        return  maxGivenKnowledge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", practicalKnowledge=" + practicalKnowledge.getLevel() +
                ", theoryKnowledge=" + theoryKnowledge.getLevel() +
                '}';
    }


    @Override
    public void tutor(Student student) {
        if (student.getName().equals(this.name)){
            return;
        }

        if((practicalKnowledge.getLevel() > 0 && theoryKnowledge.getLevel() > 0)) {
            student.increasePracticalKnowledge(getGivenKnowledge(practicalKnowledge.getLevel()));
            student.increaseTheoryKnowledge(getGivenKnowledge(theoryKnowledge.getLevel()));
        }
    }
}
