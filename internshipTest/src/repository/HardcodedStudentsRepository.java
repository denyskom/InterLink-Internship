package repository;

import person.Student;
import person.consciousness.Knowledge;


import java.util.Arrays;
import java.util.List;

public class HardcodedStudentsRepository implements StudentsRepository {
    @Override
    public List<Student> getStudentsList() {

        Student student1 = new Student("Andrew Kostenko");
        Student student2 = new Student("Julia Veselkina");
        Student student3 = new Student("Maria Perechrest");

        student1.setKnowledge(new Knowledge(3));
        student2.setKnowledge(new Knowledge(7));
        student3.setKnowledge(new Knowledge(9));


        return Arrays.asList(student1, student2, student3);
    }
}
