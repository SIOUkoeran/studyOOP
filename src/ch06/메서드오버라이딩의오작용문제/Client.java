package ch06.메서드오버라이딩의오작용문제;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        InstrumentHashSet<String> languages = new InstrumentHashSet<>();
        languages.addAll(Arrays.asList("JAVA", "RUBY", "Scala"));
        System.out.println(languages.getAddCount());
    }
}
