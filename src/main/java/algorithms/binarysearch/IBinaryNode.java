package algorithms.binarysearch;

public interface IBinaryNode<T extends Comparable<T>> {

    IBinaryNode<T> add(T data);
    IBinaryNode<T> add(IBinaryNode<T> newNode);
    IBinaryNode<T> remove(T data);
    IBinaryNode<T> remove(IBinaryNode<T> nodeToBeDeleted);

    void setParent(IBinaryNode<T> parent);

    IBinaryNode<T> getParent();

    T find (T data);
    IBinaryNode<T> findNode( T data );
    T findMax();
    IBinaryNode<T> findMaxNode();
    T findMin();

    T getValue();

    int getDepth();
    int getDepth(T data);

    IBinaryNode<T> getChild(int direction);

    void setLeft(IBinaryNode<T> left);
    void setRight(IBinaryNode<T> right);
}
