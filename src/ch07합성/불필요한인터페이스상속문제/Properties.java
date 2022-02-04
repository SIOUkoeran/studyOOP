package ch07합성.불필요한인터페이스상속문제;

import java.util.Hashtable;

public class Properties{

    private Hashtable<String, String> properties = new Hashtable<>();

    public Hashtable<String, String> getProperties() {
        return properties;
    }

    public String setProperty(String key) {
        return properties.get(key);
    }
}
