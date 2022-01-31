package ch05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AmountDiscountPolicy implements DiscountPolicy {
    private Money discountAmount;

    private List<DiscountCondition> conditions = new ArrayList<>();

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions ){
        this.conditions = Arrays.asList(conditions);
        this.discountAmount = discountAmount;
    }

    public Money calculateDiscountAmount(Screening screening){
        for (DiscountCondition each : conditions){
            if (each.isSatisfiedBy(screening)){
                System.out.println("discount!");
                return calculateDiscount(screening);
            }
        }
        return Money.ZERO;
    }
    private Money calculateDiscount(Screening screening){
        return discountAmount;
    }


}
