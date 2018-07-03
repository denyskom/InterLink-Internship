package main;

import institution.University;
import institution.interlink.Internship;
import institution.interlink.MeetUp;
import institution.selfEducation.SelfEducationActivity;
import institution.selfEducation.SelfStudy;
import person.Student;
import plan.DevelopmentPlan;
import plan.PresetConditions;
import plan.Schedule;
import repository.HardcodedStudentsRepository;
import repository.StudentsRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        StudentsRepository repository = new HardcodedStudentsRepository();

        University university = new University("CH.U.I.");
        List<Student> studentsList = repository.getStudentsList();
        studentsList.forEach(university::addStudent);
        studentsList.forEach(System.out::println);

        Internship internship = new Internship("Interlink");
        internship.recruitStudents(university);

        SelfStudy selfStudy = new SelfStudy(SelfEducationActivity.READING,
                SelfEducationActivity.CODE_PRACTICE);
        MeetUp meetUp = new MeetUp("InterLinkMeetUp");
        meetUp.setPractical(true);

        System.out.println("List of internship's students:");
        internship.getStudentsList().forEach(System.out::println);


        DevelopmentPlan plan = new DevelopmentPlan("Excellent");

        Schedule universitySchedule = new Schedule(LocalDate.of(2016, Month.SEPTEMBER, 20),
                LocalDate.of(2020, Month.MAY, 20),
                LocalTime.of(9,0),
                LocalTime.of(15, 0),
                Arrays.asList(PresetConditions.WEEKDAY_CONDITION.getValue(),
                        PresetConditions.SUMMER_CONDITION.getValue()));

        Schedule meetUpSchedule = new Schedule(LocalDate.of(2016, Month.SEPTEMBER, 20),
                LocalDate.of(2020, Month.MAY, 20),
                LocalTime.of(9,0),
                LocalTime.of(15, 0),
                Arrays.asList(PresetConditions.WEEKDAY_CONDITION.getValue(), Application::isLastThursday));

        Schedule internshipSchedule = new Schedule(LocalDate.of(2018, Month.JUNE, 1),
                LocalDate.of(2018, Month.AUGUST, 25),
                LocalTime.of(9,0),
                LocalTime.of(18, 0),
                PresetConditions.WEEKDAY_CONDITION.getValue());

        Schedule studySchedule = new Schedule(LocalDate.of(2016, Month.JANUARY, 1),
                LocalDate.of(2018, Month.DECEMBER, 31),
                LocalTime.of(16,0),
                LocalTime.of(18, 0),
                new ArrayList<>());


        plan.addRecord(university, universitySchedule);
        plan.addRecord(meetUp, meetUpSchedule);
        plan.addRecord(internship, internshipSchedule);
        plan.addRecord(selfStudy, studySchedule);
        plan.executePlan(studentsList);

        System.out.println("\n");
        studentsList.forEach(System.out::println);
        internship.recruitStudents(university);

        System.out.println("\nList of 2 internship's students:");
        internship.getStudentsList().forEach(System.out::println);
    }

    private static boolean isLastThursday(LocalDate testDay){
        if(!testDay.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
            return false;
        }
        int monthLength = testDay.lengthOfMonth();
        int monthDay = testDay.getDayOfMonth();

        return monthLength - monthDay < 7;
    }

}