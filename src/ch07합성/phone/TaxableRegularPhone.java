package ch07합성.phone;

import ch05.Money;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone{

    private double taxRate;
    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.Times(taxRate));
    }
}
