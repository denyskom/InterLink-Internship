package institution.selfEducation;

import institution.KnowledgeSource;
import person.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class SelfStudy implements KnowledgeSource {
    private Set<SelfEducationActivity> activities;

    public SelfStudy(SelfEducationActivity activity) {
        this.activities = new HashSet<>();
        activities.add(activity);
    }

    public SelfStudy(SelfEducationActivity firstActivity, SelfEducationActivity secondActivity) {
        activities.addAll(Arrays.asList(firstActivity, secondActivity));
    }


    @Override
    public void tutor(Student student) {
        double practicalKnowledge = getGeneralKnowledge(SelfEducationActivity::getPracticalKnowledge);
        student.increasePracticalKnowledge(practicalKnowledge);

        double theoryKnowledge = getGeneralKnowledge(SelfEducationActivity::getTheoryKnowledge);
        student.increaseTheoryKnowledge(theoryKnowledge);
    }

    public double getGeneralKnowledge(Function<SelfEducationActivity, Double> mappingFunction) {
        return activities.stream()
                .map(mappingFunction)
                .reduce((a1, a2) -> a1 + a2).orElseGet(() -> (double) 0);
    }
}
