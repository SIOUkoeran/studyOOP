package ch06.afterDRY추상화;

import ch05.Money;

import java.time.Duration;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));

    }
}
