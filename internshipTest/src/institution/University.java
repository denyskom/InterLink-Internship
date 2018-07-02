package institution;

import person.Student;

import java.util.ArrayList;
import java.util.List;

public class University extends MassKnowledgeSource implements KnowledgeSource {
    private String name;
//    private List<Student> studentsList;

    public University(String name) {
        this.name = name;
        this.studentsList = new ArrayList<>();
    }

    public University(String name, double practicalKnowledge, double theoryKnowledge ) {
        this.name = name;
        this.studentsList = new ArrayList<>();
        super.practicalKnowledge = practicalKnowledge;
        super.theoryKnowledge = theoryKnowledge;
    }



    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    @Override
    public void givePracticalSkills(Student student) {
        if(isPresent(student)) {
            student.icreasePracticalKnowledge(practicalKnowledge);
        }
    }

    @Override
    public void giveTheorySkills(Student student) {
        if(isPresent(student)) {
            student.icreaseTheoryKnowledge(theoryKnowledge);
        }

    }

    private boolean isPresent(Student student) {
        return studentsList.stream()
                .anyMatch(universityStudent -> universityStudent.getName().equals(student.getName()));
    }


}
