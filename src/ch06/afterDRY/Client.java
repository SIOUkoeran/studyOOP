package ch06.afterDRY;

import ch05.Money;

import java.time.Duration;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));

    }
}
