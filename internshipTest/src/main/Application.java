package main;

import institution.University;
import institution.interlink.Internship;
import institution.selfEducation.SelfEducationActivity;
import institution.selfEducation.SelfStudy;
import person.Student;
import plan.DevelopmentPLan;
import plan.PresetConditions;
import plan.Schedule;
import repository.HardcodedStudentsRepository;
import repository.StudentsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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

        SelfStudy study = new SelfStudy(SelfEducationActivity.READING,
                SelfEducationActivity.CODE_PRACTICE);


        DevelopmentPLan plan = new DevelopmentPLan();
        Schedule universitySchedule = new Schedule(LocalDate.of(2016, Month.SEPTEMBER, 1),
                LocalDate.of(2016, Month.SEPTEMBER, 2),
                LocalTime.of(9,0),
                LocalTime.of(15, 0),
                Arrays.asList(PresetConditions.SUMMER_CONDITION.getValue(),
                        PresetConditions.WEEKDAY_CONDITION.getValue()));
        plan.addRecord(study, universitySchedule);

        plan.executePlan(studentsList);

        System.out.println("\n");
        studentsList.forEach(System.out::println);



//        System.out.println("List of internship's students:");
//        System.out.println(internship.getStudents());
    }

}