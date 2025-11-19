package algorithms.linkedlist;

public interface ILinkedListOneDirection <T> {
    void add(T data);
    void set(T data, int index);
    T get(int index);
    T remove(int index);
    int find(T data);

}
