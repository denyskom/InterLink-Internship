package plan;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;

public enum PresetConditions {
    WEEKDAY_CONDITION(localDate -> !weekDayCondition(localDate)),
    SUMMER_CONDITION(PresetConditions::summerCondition),
    WEEKEND_CONDITION(PresetConditions::weekendCondition);

    private final Predicate<LocalDate> condition;

    PresetConditions(Predicate<LocalDate> condition) {
        this.condition = condition;
    }

    public Predicate<LocalDate> getValue() {
       return condition;
    }

    private static boolean weekDayCondition(LocalDate testDay) {

        DayOfWeek dayOfWeek = testDay.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return false;
        }

        return true;
    }

    private static boolean weekendCondition(LocalDate testDay){
        DayOfWeek dayOfWeek = testDay.getDayOfWeek();

        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return true;
        }
        return false;
    }

    private static boolean summerCondition(LocalDate testDay) {
        Month month = testDay.getMonth();

        if(month.equals(Month.JUNE)
                || month.equals(Month.JULY)
                || month.equals(Month.AUGUST)) {
            return false;
        }
        return true;
    }
}
