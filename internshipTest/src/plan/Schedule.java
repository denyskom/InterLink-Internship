package plan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Schedule {
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Function<LocalDate, Boolean>> conditions;

    public Schedule() {
        this.conditions = new ArrayList<>();
    }

    public Schedule(LocalDate startDate,
                    LocalDate endDate,
                    LocalTime startTime,
                    LocalTime endTime,
                    List<Function<LocalDate,
                            Boolean>> conditions) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.conditions = conditions;
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

    public List<Function<LocalDate, Boolean>> getConditions() {
        return conditions;
    }

    public void addCondition(Function<LocalDate, Boolean> condition) {
        conditions.add(condition);
    }
}
