package person.consciousness;

public class Knowledge {
    private double level;

    public Knowledge(double level) {
        if (level < 0) {
            this.level = 0;
            return;
        }

        this.level = level;
    }

    public double getLevel() {
        return level;
    }

    public void increaseKnowledge(double level) {
        this.level += level;
    }

}
