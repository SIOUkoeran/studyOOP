package ch06.메서드오버라이딩의오작용문제;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentHashSet<E> extends HashSet {
    private int addCount = 0;

    public int getAddCount() {
        return addCount;
    }

    @Override
    public boolean add(Object o) {
        addCount++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }
}
