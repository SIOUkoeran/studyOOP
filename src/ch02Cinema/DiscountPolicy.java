package ch02Cinema;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
