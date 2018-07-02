package plan;

import java.time.LocalDate;

public class StudyPeriod {
    private LocalDate startDay;
    private LocalDate endDay;

    public StudyPeriod(LocalDate startDay, LocalDate endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }
}
