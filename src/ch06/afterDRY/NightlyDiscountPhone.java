package ch06.afterDRY;

import ch05.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration second) {
        super(regularAmount, second);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee(){
        Money result = super.calculateFee();
        Money nightlyFee = Money.ZERO;

        for (Call call : getCalls()){
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR){
                nightlyFee = nightlyFee.plus(getAmount().minus(nightlyAmount)
                        .Times(call.getDuration().getSeconds()/getSecond().getSeconds()));
            }
        }
        return result.minus(nightlyAmount);
    }
}
