package algorithms.binarysearch;

public class BinaryNode<T extends Comparable<T>> implements IBinaryNode<T> {
    IBinaryNode<T> left;
    IBinaryNode<T> right;

    T value;

    BinaryNode(){

    }


    @Override
    public void add(T data) {
        if(value == null){
            value = data;
        }

        if(value.compareTo(data) > -1){
            if(left == null){
                left = new BinaryNode<T>();
            }
            left.add(data);
        } else {
            if(right == null){
                right = new BinaryNode<T>();
            }
            right.add(data);
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public T find(T data) {
        if(value == data){
            return value;
        };

        if(value.compareTo(data) > -1){
            return left.find(data);
        }
        return right.find(data);
    }

    @Override
    public T findMax() {
        if(right != null){
            return right.findMax();
        };
        return value;
    }

    @Override
    public T findMin() {
        if(left != null){
            return left.findMin();
        };
        return value;
    }

    public T getValue(){
        return value;
    }
}
