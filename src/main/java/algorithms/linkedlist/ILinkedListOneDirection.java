package algorithms.linkedlist;

import java.util.function.Predicate;

public interface ILinkedListOneDirection <T> {
    void add(T data);
    void add(T data, int index);
    void set(T data, int index);
    T get(int index);
    T remove(int index);
    int find(T data);
    int find(Predicate<T> condition);

    int getLength();

}
