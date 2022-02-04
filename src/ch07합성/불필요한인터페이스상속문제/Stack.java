package ch07합성.불필요한인터페이스상속문제;

import java.util.EmptyStackException;
import java.util.Vector;

public class Stack<E> {
    private Vector<E> elements = new Vector<>();

    public E push(E item){
        elements.add(item);
        return item;
    }

    public E pop(E item){
        if (elements.isEmpty())
            throw  new EmptyStackException();
        return elements.remove(elements.size() - 1);
    }
}
