package algorithms.binarysearch;

public class BinaryNode<T extends Comparable<T>> implements IBinaryNode<T> {
    IBinaryNode<T> left;
    IBinaryNode<T> right;

    IBinaryNode<T> parent;

    T value;

    BinaryNode(){

    }


    @Override
    public IBinaryNode<T> add(T data) {
        //do we want to deal with duplicates?


        if(value == null){
            value = data;
            return this;
        }

        if(value.compareTo(data) > -1){
            if(left == null){
                left = new BinaryNode<T>();
                left.setParent(this);
            }
            left.add(data);
        } else {
            if(right == null){
                right = new BinaryNode<T>();
                right.setParent(this);
            }
            right.add(data);
        }
        return this;
    }

    public IBinaryNode<T> add(IBinaryNode<T> newNode){
        if(newNode == null){
            return this;
        }

        if(value.compareTo(newNode.getValue()) > -1){
            if(left == null){
                left = newNode;
                left.setParent(this);
            }
            left.add(newNode);
        } else {
            if(right == null){
                right = newNode;
                right.setParent(this);
            }
            right.add(newNode);
        }
        return this;
    }

    /**
     * returns a reference to the new tree
     * @param data
     * @return
     */
    @Override
    public IBinaryNode<T> remove(T data) {

        IBinaryNode<T> nodeToBeDeleted = findNode(data);
        IBinaryNode<T> leftChild = nodeToBeDeleted.getChild(-1);
        IBinaryNode<T> rightChild = nodeToBeDeleted.getChild(1);
        IBinaryNode<T> parent = nodeToBeDeleted.getParent();

        // Situation 1: node to be deleted has 0 children
        if(rightChild == null && leftChild == null){
            if(this.equals(nodeToBeDeleted)){
                return new BinaryNode<T>();
            }

            if(parent.getChild(-1).equals(nodeToBeDeleted)) {
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }

            nodeToBeDeleted.setParent(null);
            nodeToBeDeleted.setLeft(null);
            nodeToBeDeleted.setRight(null);


            return this;
        }


        // Situation 2: node to be deleted has one child
        if(rightChild == null ^ leftChild == null){
            IBinaryNode<T> actualChild;
            if(rightChild != null){
                actualChild = rightChild;
            } else {
                actualChild = leftChild;
            }

            // root situation
            if(this.equals(nodeToBeDeleted)){
                actualChild.setParent(null);
                return actualChild;
            }

            if(parent.getChild(-1).equals(nodeToBeDeleted)) {
                parent.setLeft(actualChild);
            }
            else{
                parent.setRight(actualChild);
            }
            actualChild.setParent(parent);

            nodeToBeDeleted.setParent(null);
            nodeToBeDeleted.setLeft(null);
            nodeToBeDeleted.setRight(null);

            return this;
        }



        // get max from left, and put it at the deleted spot
        // max can only have 1 child, on the left, cause if it has an item on the right it wouldn't be the max
        // attach child of max to the parent of max to the right
        // attach max as the left child of the parent of deleted
        // attach children of deleted to max
        // that should make sense in some way



        IBinaryNode<T> nodeLeftMax = this.left.findMaxNode();

        IBinaryNode<T> parentOfNodeLeftMax = nodeLeftMax.getParent();
        if(parentOfNodeLeftMax.equals(nodeToBeDeleted)){
            parentOfNodeLeftMax = parent;
        }


        IBinaryNode<T> childOfNodeLeftMax = nodeLeftMax.getChild(-1);

        parentOfNodeLeftMax.remove(nodeToBeDeleted.getValue());
        parentOfNodeLeftMax.add(childOfNodeLeftMax);

        return this;
    }

    /**
     * returns reference to the new tree
     * @param nodeToBeDeleted
     * @return
     */
    public IBinaryNode<T> remove(IBinaryNode<T> nodeToBeDeleted){
        IBinaryNode<T> parent = nodeToBeDeleted.getParent();
        if(parent.getChild(-1).getValue().equals(nodeToBeDeleted.getValue())){
            parent.setLeft(null);
            nodeToBeDeleted.setParent(null);
        }
        parent.setRight(null);
        return this;
    }

    /**
     * returns null if value not found
     * @param data
     * @return
     */
    @Override
    public T find(T data) {
        if( value == null){
            return null;
        }

        if(value == data){
            return value;
        };

        if(value.compareTo(data) > -1){
            if(left == null){
                return null;
            }
            return left.find(data);
        }
        if(right == null){
            return null;
        }
        return right.find(data);
    }

    /**
     * returns null if node not found
     * @param data
     * @return
     */
    public IBinaryNode<T> findNode( T data ){
        if(value == data){
            return this;
        };

        if(value.compareTo(data) > -1){
            if(left == null){
                return null;
            }
            return left.findNode(data);
        }
        if(right == null){
            return null;
        }
        return right.findNode(data);
    }

    @Override
    public T findMax() {
        if(right != null){
            return right.findMax();
        };
        return value;
    }

    public IBinaryNode<T> findMaxNode(){
        if(right != null){
            return right.findMaxNode();
        };
        return this;
    }

    public int getDepth(){
        if(this.parent == null){
            return 0;
        }
        return parent.getDepth() + 1;
    }

    public int getDepth(T data){
        IBinaryNode<T> node = findNode(data);
        return node.getDepth();
    }

    @Override
    public T findMin() {
        if(left != null){
            return left.findMin();
        };
        return value;
    }

    public void setParent(IBinaryNode<T> parent){
        this.parent = parent;
    }

    public IBinaryNode<T> getParent(){
        return parent;
    }

    public IBinaryNode<T> getChild(int direction){
        if(direction >= 0){
            return right;
        }
        return left;
    }

    public void setLeft(IBinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(IBinaryNode<T> right){
        this.right = right;
    }

    public T getValue(){
        return value;
    }
}
