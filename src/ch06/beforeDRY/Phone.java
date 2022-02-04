package ch06.beforeDRY;



import ch05.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration second;
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration second, double taxRate) {
        this.amount = amount;
        this.second = second;
        this.taxRate  = taxRate;
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
           result =  result.plus(amount.Times(call.getDuration().getSeconds() / second.getSeconds()));
        }
        return result.plus(result.Times(taxRate));
    }
}
