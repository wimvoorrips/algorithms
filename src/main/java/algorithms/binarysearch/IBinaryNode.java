package algorithms.binarysearch;

public interface IBinaryNode<T extends Comparable<T>> {

    /**
     * create a new node with given data
     * @param data value of new node
     * @return new node
     */
    IBinaryNode<T> add(T data);

    /**
     * add an already created node to this node
     * @param newNode existing node
     * @return new node
     */
    IBinaryNode<T> add(IBinaryNode<T> newNode);

    /**
     * remove node containing this value
     * @param data
     * @return deleted node
     */
    IBinaryNode<T> remove(T data);

    /**
     * remove specific node
     * @param nodeToBeDeleted
     * @return deleted node
     */
    IBinaryNode<T> remove(IBinaryNode<T> nodeToBeDeleted);


    T find (T data);

    /**
     * find a node based on the data
     * @param data
     * @return
     */
    IBinaryNode<T> findNode( T data );

    /**
     * find maximum value
     * @return
     */
    T findMax();

    /**
     * find node with the maximum value
     * @return
     */
    IBinaryNode<T> findMaxNode();

    /**
     * find minimal value
     * @return
     */
    T findMin();

    /**
     * get distance from this node to specific node
     * @param root
     * @return
     */
    int getDepth(IBinaryNode<T> root);

    /**
     * get total depth of node
     * @param data
     * @return
     */
    int getDepth(T data);


    // getters en setters
    void setParent(IBinaryNode<T> parent);
    IBinaryNode<T> getParent();
    T getValue();
    IBinaryNode<T> getChild(int direction);
    void setLeft(IBinaryNode<T> left);
    void setRight(IBinaryNode<T> right);
}
