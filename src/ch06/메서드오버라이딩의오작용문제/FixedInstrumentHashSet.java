package ch06.메서드오버라이딩의오작용문제;

import java.util.Collection;
import java.util.HashSet;

public class FixedInstrumentHashSet<E> extends HashSet<E> {
    private int addCount;
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for(E e : c){
            if (add(e))
                modified = true;
        }
        return modified;
    }
}
