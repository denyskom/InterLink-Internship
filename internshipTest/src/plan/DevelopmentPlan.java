package plan;

import institution.KnowledgeSource;
import person.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class DevelopmentPlan {
    private Map<KnowledgeSource, Schedule> records;
    private String name;

    public String getName() {
        return name;
    }

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
        LocalTime currentTime = LocalTime.now();
        LocalDate executionEnd = specifyEndDate();
        LocalDate testDay = specifyStartDate();

        Map<KnowledgeSource, Schedule> recordsCopy = new HashMap<>(records);
        do {
            Iterator<Map.Entry<KnowledgeSource, Schedule>> iterator = recordsCopy.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<KnowledgeSource, Schedule> entry = iterator.next();
                Schedule schedule = entry.getValue();

                if (testDay.isBefore(schedule.getStartDate()) ||
                        testDay.isAfter(schedule.getEndDate())) {
                    continue;
                }

                if (testDay.equals(executionEnd)) {
                    if (schedule.getEndTime().isAfter(currentTime)) {
                        continue;
                    }
                }

                KnowledgeSource source = entry.getKey();
                if (schedule.isSatisfyingCondition(testDay)) {
                    students.forEach(source::tutor);
                }

                if (testDay.equals(schedule.getEndDate())) {
                    iterator.remove();
                }
            }

            testDay = testDay.plusDays(1);
        } while (!testDay.isAfter(executionEnd));
    }


    private LocalDate specifyStartDate() {
        LocalDate startDay = LocalDate.now();
        for (Map.Entry<KnowledgeSource, Schedule> entry : records.entrySet()) {
            LocalDate sourceStartDate = entry.getValue().getStartDate();
            if (sourceStartDate.isBefore(startDay)) {
                startDay = sourceStartDate;
            }
        }
        return startDay;
    }

    private LocalDate specifyEndDate() {
        LocalDate today = LocalDate.now();
        LocalDate executionEnd = LocalDate.now();
        for (Map.Entry<KnowledgeSource, Schedule> entry : records.entrySet()) {
            LocalDate sourceEndDate = entry.getValue().getEndDate();
            if (sourceEndDate.isAfter(today)) {
                return today;
            }

            if (sourceEndDate.isBefore(executionEnd)) {
                executionEnd = sourceEndDate;
                System.out.println(executionEnd);
            }
        }
        return executionEnd;
    }
}
