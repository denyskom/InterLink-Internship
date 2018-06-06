package main;

import institution.University;
import institution.interlink.Internship;
import repository.HardcodedStudentsRepository;
import repository.StudentsRepository;

public class Application {
    public static void main(String[] args) {
        StudentsRepository repository = new HardcodedStudentsRepository();

        University university = new University("CH.U.I.");
        repository.getStudentsList().forEach(university::addStudent);

        Internship internship = new Internship("Interlink");
        internship.recruitStudents(university);

        System.out.println("List of internship's students:");
        System.out.println(internship.getStudents());
    }
}