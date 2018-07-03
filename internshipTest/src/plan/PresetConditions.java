package plan;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.function.BiFunction;

public enum PresetConditions {
    WEEKDAY_CONDITION(PresetConditions::weekDayCondition),
    SUMMER_CONDITION(PresetConditions::summerCondition),
    WEEKEND_CONDITION(PresetConditions::weekendCondition);

    private final BiFunction<LocalDate, Schedule, Boolean>  condition;

    PresetConditions(BiFunction<LocalDate, Schedule, Boolean> condition) {
        this.condition = condition;
    }

    public BiFunction<LocalDate, Schedule, Boolean> getValue() {
       return condition;
    }

    private static boolean weekDayCondition(LocalDate testDay, Schedule schedule) {


        if(testDay.isBefore(schedule.getStartDate())){
            return false;
        }

        DayOfWeek dayOfWeek = testDay.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return false;
        }

        return true;
    }

    private static boolean weekendCondition(LocalDate testDay,Schedule schedule){
        DayOfWeek dayOfWeek = testDay.getDayOfWeek();

        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return true;
        }
        return false;
    }

    private static boolean summerCondition(LocalDate testDay, Schedule schedule) {
        Month month = testDay.getMonth();

        if(month.equals(Month.JUNE)
                || month.equals(Month.JULY)
                || month.equals(Month.AUGUST)) {
            return false;
        }
        return true;
    }

}
