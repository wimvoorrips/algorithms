package algorithms.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> implements IStack {
    protected T[] sourceArray;

    ArrayStack(Class<T> c){
        sourceArray = (T[]) Array.newInstance(c, 1);
    }


    @Override
    public void push(Object data) {

    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public Object top() {
        return sourceArray[sourceArray.length - 1];
    }
}
