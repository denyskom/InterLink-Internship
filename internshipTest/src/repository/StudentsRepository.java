package repository;

import person.Student;

import java.util.List;

public interface StudentsRepository {
    List<Student> getStudentsList();
}
