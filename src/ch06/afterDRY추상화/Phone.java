package ch06.afterDRY추상화;

import ch05.Money;

import java.time.Duration;

public class Phone extends AbstractPhone{
    private Money amount;
    private Duration seconds;

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.Times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
