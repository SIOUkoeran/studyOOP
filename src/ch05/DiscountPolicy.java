package ch05;


public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
