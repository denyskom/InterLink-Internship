package plan;

import institution.KnowledgeSource;
import person.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevelopmentPlan {
    private Map<KnowledgeSource, Schedule> records;
    private String name;
    public DevelopmentPlan(String name) {
        this.name = name;
        records = new HashMap<>();
    }

    public void addRecord(KnowledgeSource source, Schedule schedule) {
        records.put(source, schedule);
    }

    public void executePlan(Student student) {
        for (Map.Entry<KnowledgeSource, Schedule> entry : records.entrySet()) {
            executeSingleSourcePlan(entry, student);
        }

    }

    public void executePlan(List<Student> students) {
        students.forEach(this::executePlan);
    }

    private void executeSingleSourcePlan(Map.Entry<KnowledgeSource, Schedule> entry,
                                         Student student) {
        Schedule schedule = entry.getValue();
        LocalDateTime today = LocalDateTime.now();
        LocalDate startDate = schedule.getStartDate();

        if(today.toLocalDate().isBefore(startDate)) {
            return;
        }

        LocalDate executionEnd = getExecutionEnd(schedule);


        LocalDate testDay = startDate;
        do {
            if(schedule.isSatisfyingCondition(testDay)) {
                entry.getKey().tutor(student);
            }
            testDay = testDay.plusDays(1);
        } while (testDay.isBefore(executionEnd));

    }

    private LocalDate getExecutionEnd(Schedule schedule) {
        LocalDateTime today =  LocalDateTime.now();
        LocalDate currentDate = today.toLocalDate();
        LocalDate executionEnd = currentDate;
        LocalTime currentTime = today.toLocalTime();
        LocalDate endDate = schedule.getEndDate();

        if(currentDate.isAfter(endDate)) {
            executionEnd = endDate;
        }


        LocalTime endTime = schedule.getEndTime();
        if(currentTime.isBefore(endTime)
                && (currentDate.isBefore(endDate) || currentDate.equals(endDate))) {
            executionEnd = currentDate.minusDays(1);
        }

        return executionEnd;
    }

    public String getScheduleForToday(Student student) {
        StringBuilder builder = new StringBuilder(student.getName()).append("'s schedule for today:\n");
        boolean hasRecords = false;
        for (Map.Entry<KnowledgeSource, Schedule> entry : records.entrySet()) {
            Schedule schedule = entry.getValue();
            if(schedule.isSatisfyingCondition(LocalDate.now())) {
                builder.append(schedule)
                        .append(" Begins: ")
                        .append(schedule.getStartTime())
                        .append(" ends: ")
                        .append(schedule.getEndTime());
                hasRecords = true;
            }
        }

        if(!hasRecords) {
            return builder.append("No records").toString();
        }

        return builder.toString();
    }
}
