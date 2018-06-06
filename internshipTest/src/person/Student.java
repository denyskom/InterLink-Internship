package person;

import person.consciousness.Knowledge;

public class Student {
    private String name;
    private Knowledge knowledge;

    public Student(String name) {
        this.name = name;
        this.knowledge = new Knowledge(0);
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public String getName() {
        return name;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }
}
