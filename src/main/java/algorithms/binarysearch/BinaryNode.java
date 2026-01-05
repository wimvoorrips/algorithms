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
        if(data == null){
            throw new RuntimeException("null not allowed");
        }


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
        if(newNode == null || newNode.getValue() == null){
            return this;
        }

        if(value.compareTo(newNode.getValue()) > -1){
            if(left == null){
                left = newNode;
                left.setParent(this);
            } else {
                left.add(newNode);
            }
        } else {
            if(right == null){
                right = newNode;
                right.setParent(this);
            } else {
                right.add(newNode);
            }
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

            if(parent.getChild(-1) != null && parent.getChild(-1).equals(nodeToBeDeleted)) {
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

        // situation 3, node to be deleted has 2 children

        // fuck it, even alles apart schrijven
        // case 1: deletedNode is NIET root en is NIET de parent van de max node
        IBinaryNode<T> maxNodeOnLeft = leftChild.findMaxNode();
        IBinaryNode<T> maxNodeOnLeftParent = maxNodeOnLeft.getParent();
        //if(nodeToBeDeleted.equals(maxNodeOnLeftParent)){
        //    maxNodeOnLeftParent = maxNodeOnLeftParent.getParent();
        //}
        IBinaryNode<T> maxNodeOnLeftChild = maxNodeOnLeft.getChild(-1);
        //System.out.println("maxnodeonleft value: " + maxNodeOnLeft.getValue());
        //System.out.println("maxnodeonleftchild value: " + maxNodeOnLeftChild.getValue());
        //System.out.println("maxnodeonleftparent value: " + maxNodeOnLeftParent.getValue());

        //if(nodeToBeDeleted.equals(maxNodeOnLeftParent)){
        //    maxNodeOnLeftParent = nodeToBeDeleted.getParent();
        //}

        // parent en child aan elkaar plakken
        if(maxNodeOnLeftParent != null) {
            maxNodeOnLeftParent.setRight(maxNodeOnLeftChild);
        }
        if(maxNodeOnLeftChild != null && ! nodeToBeDeleted.equals(maxNodeOnLeftParent)) {
            System.out.println("setparent");
            maxNodeOnLeftChild.setParent(maxNodeOnLeftParent);
        }

        // nu de maxnode op de plek van de deletednode plaatsen
        if(! maxNodeOnLeft.equals(leftChild)) {
            maxNodeOnLeft.setLeft(leftChild);
            leftChild.setParent(maxNodeOnLeft);
        } else {
            // in dit geval is de direct parent van de maxnode de deletednode
            maxNodeOnLeft.setParent(nodeToBeDeleted.getParent());
            if(nodeToBeDeleted.getParent() != null){
                nodeToBeDeleted.getParent().setLeft(maxNodeOnLeft);
            }
        }
        maxNodeOnLeft.setRight(rightChild);
        rightChild.setParent(maxNodeOnLeft);

        maxNodeOnLeft.setParent(parent);
        if(parent != null) {
            if (nodeToBeDeleted.equals(parent.getChild(-1))) {
                parent.setLeft(maxNodeOnLeft);
            } else {
                parent.setRight(maxNodeOnLeft);
            }
        }

        // en als laatste de references van de deleted node verwijderen
        nodeToBeDeleted.setParent(null);
        nodeToBeDeleted.setLeft(null);
        nodeToBeDeleted.setRight(null);

        if(this.equals(nodeToBeDeleted)){
            return maxNodeOnLeft;
        }
        return this;






        // situation 3, node to be deleted has 2 children


        // get max from left, and put it at the deleted spot
        // max can only have 1 child, on the left, cause if it has an item on the right it wouldn't be the max
        // attach child of max to the parent of max to the right
        // attach max as the left child of the parent of deleted
        // attach children of deleted to max
        // that should make sense in some way
        /*
                      P
              O               D
          A       B        M       C
        E   F   G    H   I       K    L
        */

        // Laten we er een boodschappenlijstje van maken
        // deleted node hebben we
        // parent hebben we

        // case 1: deletednode is root
        // in dit geval halen we leftmax op, gooien we deze op de plek van root, en attachen we de children
        // niet anders dan normaal eigenlijk







    /*
        //so first we find the max child on the left side of the nodetobedeleted
        IBinaryNode<T> nodeLeftMax = nodeToBeDeleted.getChild(-1).findMaxNode();

        // then we connect the child of the max node to the parent of the max node
        IBinaryNode<T> parentOfNodeLeftMax = nodeLeftMax.getParent();
        IBinaryNode<T> childOfNodeLeftMax = nodeLeftMax.getChild(-1);
        if(childOfNodeLeftMax != null) {
            // if parent of max got deleted
            if (parentOfNodeLeftMax.equals(nodeToBeDeleted)) {
                parentOfNodeLeftMax = parent;
                // nu kan het voo
            }

            if(parentOfNodeLeftMax != null) {
                parentOfNodeLeftMax.setRight(childOfNodeLeftMax);
                childOfNodeLeftMax.setParent(parentOfNodeLeftMax);

            }

            // nu de standaard dingen
            //nodeLeftMax.setLeft(null);
            nodeLeftMax.setRight(nodeToBeDeleted.getChild(1));
            nodeLeftMax.setLeft(nodeToBeDeleted.getChild(-1));



        }

        ////


        // then we put


        IBinaryNode<T> childOfNodeLeftMax = nodeLeftMax.getChild(-1);

        parentOfNodeLeftMax.remove(nodeToBeDeleted.getValue());
        parentOfNodeLeftMax.add(childOfNodeLeftMax);

        return this;*/
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

    public int getDepth(IBinaryNode<T> root){
        //if(this.parent == null){
        //    return 0;
        //}
        if(this.equals(root)){
            return 0;
        }
        if(this.parent == null){
            throw new RuntimeException("Item not in this root");
        }
        return parent.getDepth(root) + 1;
    }

    public int getDepth(T data){

        IBinaryNode<T> node = findNode(data);
        return node.getDepth(this);
    }

    @Override
    public T findMin() {
        if(left != null){
            return left.findMin();
        };
        return value;
    }

    public void setParent(IBinaryNode<T> parent){
        if(this.equals(parent)){
            throw new RuntimeException("Can't set self as parent");
        }
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
        if(this.equals(left)){
            throw new RuntimeException("Can't set self as child");
        }
        this.left = left;
    }

    public void setRight(IBinaryNode<T> right){
        if(this.equals(right)){
            throw new RuntimeException("Can't set self as child");
        }
        this.right = right;
    }

    public T getValue(){
        return value;
    }
}
