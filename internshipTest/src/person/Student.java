package person;

import person.consciousness.Knowledge;

public class Student {
    private String name;
    private Knowledge practicalKnowledge;
    private Knowledge theoryKnowledge;
    private double skillCoefficient = 0.5;
    private boolean hasNotebook = true;

    public Student(String name) {
        this.name = name;
        this.practicalKnowledge = new Knowledge(0);
        this.theoryKnowledge = new Knowledge(0);
    }

    public void setPracticalKnowledge(Knowledge practicalKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
    }

    public void setTeoryKnowledge(Knowledge theoryKnowledge) {
        this.theoryKnowledge = theoryKnowledge;
    }

    public void setSkillCoefficient(double skillCoefficient) {
        this.skillCoefficient = skillCoefficient;
    }

    public void setHasNotebook(boolean hasNotebook) {
        this.hasNotebook = hasNotebook;
    }



    public String getName() {
        return name;
    }

    public Knowledge getFullExperience() {
        return new Knowledge(practicalKnowledge.getLevel() * 2 + theoryKnowledge.getLevel());
    }


    public void icreasePracticalKnowledge(double level) {
        practicalKnowledge.increaseKnowledge(level * skillCoefficient);
    }

    public void icreaseTheoryKnowledge(double level) {
        theoryKnowledge.increaseKnowledge(level * skillCoefficient);
    }

    public boolean hasNotebook() {
        return hasNotebook;
    }
}
