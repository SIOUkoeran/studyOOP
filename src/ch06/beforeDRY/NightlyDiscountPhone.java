package ch06.beforeDRY;

import ch05.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private double taxRate;
    private Duration second;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconde, double taxRate) {
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.second = seconde;
        this.taxRate = taxRate;
    }

    public Money calculateFee(){
        Money result = Money.ZERO;

        for (Call call : calls){
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR){
                result = result.plus(nightlyAmount.Times(call.getDuration().getSeconds() / second.getSeconds()));
            }else{
                result = result.plus(regularAmount.Times(call.getDuration().getSeconds() / second.getSeconds()));
            }
        }
        return result.plus(result.Times(taxRate));
    }
}
