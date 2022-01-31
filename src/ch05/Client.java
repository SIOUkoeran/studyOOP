package ch05;





import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Client {
    public static void main(String[] args) {
        DiscountCondition discountCondition = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 20), LocalTime.of(12,00));
        ServiceLocator.provide(new AmountDiscountPolicy(Money.wons(1000), discountCondition));
        Movie avatar = new Movie("아바타", Duration.ofMinutes(100), Money.wons(10000));

        Screening screening = new Screening(avatar, 1, LocalDateTime.of(2022,1,31,10,20));
        System.out.println(avatar.calculateMovieFee(screening));
    }
}
