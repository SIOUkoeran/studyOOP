package ch07합성.phone;

import ch05.Money;

import java.time.Duration;

public class TaxableNightDiscountPhone extends NightlyDiscountPhone{
    private double taxRate;

    public TaxableNightDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate){
        super(nightlyAmount, regularAmount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.Times(taxRate));
    }
}
