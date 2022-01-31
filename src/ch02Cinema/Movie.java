package ch02Cinema;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy defaultDiscountPolicy;

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){
        this.defaultDiscountPolicy = discountPolicy;
    }

    public Movie(String title, Duration runningTime, Money fee, DefaultDiscountPolicy defaultDiscountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.defaultDiscountPolicy = defaultDiscountPolicy;
    }

    public Money getFee(){
        return this.fee;
    }
    public Money calculateMovieFee(Screening screening){
        return fee.minus(defaultDiscountPolicy.calculateDiscountAmount(screening));
    }
}
