package plan;

import institution.KnowledgeSource;
import person.Student;
import person.consciousness.Knowledge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

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
        executePlan(Collections.singletonList(student));
    }

    public void executePlan(List<Student> students) {
        LocalDate startDay = LocalDate.now();
        LocalDateTime today = LocalDateTime.now();
        LocalDate executionEnd = today.toLocalDate();

        for (Map.Entry<KnowledgeSource, Schedule> entry : records.entrySet()) {
            LocalDate sourceStartDate = entry.getValue().getStartDate();

            if(sourceStartDate.isBefore(startDay)){
                startDay = sourceStartDate;
            }

        }
        for (Map.Entry<KnowledgeSource, Schedule> entry : records.entrySet()) {
            LocalDate sourceEndDate = entry.getValue().getEndDate();
            if(sourceEndDate.isAfter(today.toLocalDate())){
                executionEnd = LocalDate.now();
                break;
            }

            if(sourceEndDate.isBefore(executionEnd)){
                executionEnd = sourceEndDate;
            }

        }

        LocalDate testDay = startDay;
        Map<KnowledgeSource, Schedule> recordsCopy = new HashMap<>(records);
        do {
            Map<KnowledgeSource, Schedule> dayCopy = new HashMap<>(recordsCopy);

            for (Map.Entry<KnowledgeSource, Schedule> entry : dayCopy.entrySet()){
                Schedule schedule = entry.getValue();

                if (testDay.isBefore(schedule.getStartDate()) ||
                        testDay.isAfter(schedule.getEndDate())) {
                    continue;
                }

                if (testDay.equals(executionEnd)) {
                    if(schedule.getEndTime().isAfter(today.toLocalTime())) {
                        continue;
                    }
                }

                KnowledgeSource source = entry.getKey();
                if (schedule.isSatisfyingCondition(testDay)){
                    students.forEach(source::tutor);
                }

                if(testDay.equals(schedule.getEndDate())){
                    recordsCopy.remove(source);

                }
            }

            testDay = testDay.plusDays(1);
        } while (testDay.isBefore(executionEnd));
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
