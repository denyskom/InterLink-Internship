package repository;

import person.Student;
import person.consciousness.Knowledge;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardcodedStudentsRepository implements StudentsRepository {
    @Override
    public List<Student> getStudentsList() {

        Student student1 = new Student("Andrew Kostenko", 20, 30);
        Student student2 = new Student("Julia Veselkina", 30, 40);
        Student student3 = new Student("Maria Perechrest", 10, 50);

        student1.setSkillCoefficient(0.8);
        student2.setHasNotebook(true);




        return new ArrayList<>(Arrays.asList(student1, student2, student3));
    }
}
