package plan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Schedule {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Predicate<LocalDate>> conditions;


    public Schedule(LocalDate startDate,
                    LocalDate endDate,
                    LocalTime startTime,
                    LocalTime endTime,
                    List<Predicate<LocalDate>> conditions) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.conditions = conditions;
    }

    public Schedule(LocalDate startDate,
                    LocalDate endDate,
                    LocalTime startTime,
                    LocalTime endTime,
                    Predicate<LocalDate> condition) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.conditions = new ArrayList<>();
        this.conditions.add(condition);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Predicate<LocalDate>> getConditions() {
        return conditions;
    }

    public void addCondition(Predicate<LocalDate> condition) {
        conditions.add(condition);
    }

    public boolean isSatisfyingCondition(LocalDate testDay) {
        return getConditions().stream()
                .allMatch(c -> c.test(testDay));

    }
}
