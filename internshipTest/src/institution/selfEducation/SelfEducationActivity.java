package institution.selfEducation;

public enum SelfEducationActivity {
    READING(0, 4),
    CODE_PRACTICE(5, 1),
    WATCHING_VIDEO(0, 3);

    private final double practicalKnowledge;
    private final double theoryKnowledge;

    SelfEducationActivity(double practicalKnowledge, double theoryKnowledge) {
        this.practicalKnowledge = practicalKnowledge;
        this.theoryKnowledge = theoryKnowledge;
    }

    public double getPracticalKnowledge() {
        return practicalKnowledge;
    }

    public double getTheoryKnowledge() {
        return theoryKnowledge;
    }
}
