package algorithms.binarysearch;

public interface IBinaryNode<T extends Comparable<T>> {

    void add(T data);
    void remove(T data);

    T find (T data);
    T findMax();
    T findMin();

    T getValue();
}
