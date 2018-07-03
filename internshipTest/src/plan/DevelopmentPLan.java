package plan;

import institution.KnowledgeSource;
import person.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class DevelopmentPLan {
    private Map<KnowledgeSource, Schedule> record;


    public DevelopmentPLan() {

        record = new HashMap<>();
    }

    public void addRecord(KnowledgeSource source, Schedule schedule) {
        record.put(source, schedule);
    }

    public void executePlan(Student student) {
        for (Map.Entry<KnowledgeSource, Schedule> entry : record.entrySet()) {
            executeSingleSourcePlan(entry, student);
        }

    }

    public void executePlan(List<Student> students) {
        students.forEach(this::executePlan);
    }

    public String getScheduleForToday() {
        return null;
    }

    public boolean isSatisfyingCondition(LocalDate testDay, Schedule schedule) {
        List<BiFunction<LocalDate, Schedule, Boolean>> conditions = schedule.getConditions();
        for (BiFunction<LocalDate, Schedule, Boolean> condition : conditions){
            if(!condition.apply(testDay, schedule)) {
                return false;
            }
        }

        return true;
    }

    private void executeSingleSourcePlan(Map.Entry<KnowledgeSource, Schedule> entry,
                                         Student student) {
        Schedule schedule = entry.getValue();
        LocalDateTime today = LocalDateTime.now();
        LocalDate currentDate = today.toLocalDate();
        LocalTime currentTime = today.toLocalTime();
        LocalDate startDate = schedule.getStartDate();

        if(currentDate.isBefore(startDate)) {
            return;
        }

        LocalDate executionEnd;
        LocalDate endDate = schedule.getEndDate();
        if(currentDate.isAfter(endDate)) {
            executionEnd = endDate;
        }

        LocalTime endTime = schedule.getEndTime();
        if(currentTime.isBefore(endTime)) {
            executionEnd = currentDate.minusDays(1);
        }

        executionEnd = currentDate;

        LocalDate testDay = startDate;
        do {
            if(isSatisfyingCondition(testDay, schedule)) {
                entry.getKey().tutor(student);
            }
        } while (testDay.isBefore(endDate));

    }
}
