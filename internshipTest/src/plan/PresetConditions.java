package plan;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.Function;

public enum PresetConditions {
    WEEKDAY_CONDITION(PresetConditions::weekDayCondition),
    SUMMER_CONDITION(PresetConditions::summerCondition),
    WEEKEND_CONDITION(PresetConditions::weekendCondition);

    private final Function<LocalDate, Boolean> condition;

    PresetConditions(Function<LocalDate, Boolean> condition) {
        this.condition = condition;
    }

    public Function<LocalDate, Boolean> getValue() {
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
