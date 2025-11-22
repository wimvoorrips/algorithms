package algorithms.stack;

import algorithms.linkedlist.LinkedListOneDirection;


public class ListStack<T> extends LinkedListOneDirection<T> implements IStack<T> {

    @Override
    public void push(T data) {
        add(data, 0);
    }

    @Override
    public T pop() {
        return remove(0);
    }

    @Override
    public T top() {
        return get(0);
    }
}
