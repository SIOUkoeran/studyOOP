package ch05;


import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        System.out.println(screening.getWhenScreened().toLocalTime());
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) && (
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0);
    }
}
