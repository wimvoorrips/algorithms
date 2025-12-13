package algorithms.binarysearch;

import algorithms.hashtable.HashTable;
import algorithms.hashtable.IHashTable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void simpleTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);

        int expected = 1;
        int result = binaryNode.find(1);

        assertEquals(expected, result);
    }

    @Test
    public void simpleTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        int expected = 2;
        int result = binaryNode.find(2);

        assertEquals(expected, result);
    }

    @Test
    public void emptyFindTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();

        Integer expected = null;
        Integer result = binaryNode.find(1);

        assertEquals(expected, result);
    }

    @Test
    public void addNullTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add((Integer) null);

        Integer expected = 1;
        Integer result = binaryNode.find(1);

        assertEquals(expected, result);
    }

    @Test
    public void findTestNotExists(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        Integer expected = null;
        Integer result = binaryNode.find(4);

        assertEquals(expected, result);
    }

    @Test
    public void findNodeTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        Integer expected = 3;
        Integer result = binaryNode.findNode(3).getValue();

        assertEquals(expected, result);
    }

    @Test
    public void findNodeNotExistsTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        IBinaryNode<Integer> expected = null;
        IBinaryNode<Integer> result = binaryNode.findNode(4);

        assertEquals(expected, result);
    }

    @Test
    public void RemoveNodeLeafTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(10);
        binaryNode.add(5);
        binaryNode.add(15);

        binaryNode = binaryNode.remove(15);

        Integer expected = null;
        Integer result = binaryNode.find(15);

        assertEquals(expected, result);
    }

    @Test
    public void RemoveNodeSoleRootTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(10);

        binaryNode = binaryNode.remove(10);

        Integer expected = null;
        Integer result = binaryNode.find(10);

        assertEquals(expected, result);
    }

    @Test
    public void RemoveNodeRootTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(10);
        binaryNode.add(5);
        binaryNode.add(15);

        binaryNode = binaryNode.remove(10);

        Integer expected = null;
        Integer result = binaryNode.find(10);

        assertEquals(expected, result);
    }

    @Test
    public void depthTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        int expected = 2;
        int result = binaryNode.getDepth(3);

        assertEquals(expected, result);
    }

    @Test
    public void depthTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);

        int expected = 1;
        int result = binaryNode.getDepth(3);

        assertEquals(expected, result);
    }

    @Test
    public void findMaxLast(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        int expected = 3;
        int result = binaryNode.findMax();

        assertEquals(expected, result);
    }

    @Test
    public void findMaxFirst(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(3);
        binaryNode.add(2);
        binaryNode.add(1);

        int expected = 3;
        int result = binaryNode.findMax();

        assertEquals(expected, result);
    }

    @Test
    public void findMaxMiddle(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(2);

        int expected = 3;
        int result = binaryNode.findMax();

        assertEquals(expected, result);
    }

    @Test
    public void findMaxBranches(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(10);
        binaryNode.add(5);
        binaryNode.add(15);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(17);
        binaryNode.add(16);
        binaryNode.add(6);

        int expected = 17;
        int result = binaryNode.findMax();

        assertEquals(expected, result);
    }

    @Test
    public void removeFindTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(10);
        binaryNode.add(5);
        binaryNode.add(15);

        binaryNode.remove(15);

        Integer expected = null;
        Integer result = binaryNode.find(15);

        assertEquals(expected, result);
    }

    @Test
    public void removeFindTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(10);
        binaryNode.add(5);
        binaryNode.add(15);

        binaryNode.remove(10);

        Integer expected = 15;
        Integer result = binaryNode.find(15);

        assertEquals(expected, result);
    }
}
