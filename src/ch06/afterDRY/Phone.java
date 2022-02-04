package ch06.afterDRY;

import ch05.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    enum PhoneType {REGULAR, NIGHTLY};
    private PhoneType phoneType;
    private Money amount;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration second;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration second) {
        this.phoneType = PhoneType.REGULAR;
        this.amount = amount;
        this.nightlyAmount = Money.ZERO;
        this.regularAmount = Money.ZERO;
        this.second = second;
    }

    public Phone(Money nightlyAmount, Money regularAmount, Duration second) {
        this.phoneType = PhoneType.NIGHTLY;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.second = second;
    }

    public Phone(PhoneType phoneType, Money amount, Money nightlyAmount, Money regularAmount, Duration second) {
        this.phoneType = phoneType;
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.second = second;
    }

    public void call(Call call){
        calls.add(call);
    }



    public List<Call> getCalls() {
        return calls;
    }
    public Money getAmount(){
        return this.amount;
    }

    public Duration getSecond() {
        return second;
    }
    public Money calculateFee(){
        Money result = Money.ZERO;
        for (Call call : calls){
            if (phoneType == PhoneType.REGULAR){
                result =  result.plus(amount.Times(call.getDuration().getSeconds() / second.getSeconds()));
            }else{
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR){
                    result =  result.plus(nightlyAmount.Times(call.getDuration().getSeconds() / second.getSeconds()));
                }else{
                    result = result.plus(regularAmount.Times(call.getDuration().getSeconds() / second.getSeconds()));
                }
            }
        }
        return result;
    }
}
