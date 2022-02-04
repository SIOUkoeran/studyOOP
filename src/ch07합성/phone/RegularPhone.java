package ch07합성.phone;

import ch05.Money;
import ch06.afterDRY추상화.AbstractPhone;

import java.time.Duration;

public class RegularPhone extends Phone {
    private Money amount;
    private Duration seconds;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.Times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
