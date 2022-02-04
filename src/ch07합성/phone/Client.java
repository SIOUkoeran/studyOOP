package ch07합성.phone;

import ch05.Money;

import java.time.Duration;

public class Client {
    public static void main(String[] args) {
        AbstractPhone phone = new AbstractPhone(Money.wons(5), Duration.ofSeconds(10));

    }
}
