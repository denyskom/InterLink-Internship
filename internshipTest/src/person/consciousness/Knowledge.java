package person.consciousness;

public class Knowledge {
    private int level;

    public Knowledge(int level) {
        if (level < 0) {
            this.level = 0;
            return;
        }

        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
