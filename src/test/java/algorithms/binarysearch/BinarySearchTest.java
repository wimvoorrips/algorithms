package algorithms.binarysearch;

import algorithms.hashtable.HashTable;
import algorithms.hashtable.IHashTable;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void addFindTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);

        int expected = 1;
        int result = binaryNode.find(1);

        assertEquals(expected, result);
    }

    @Test
    public void addFindTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);
        binaryNode.add(2);
        binaryNode.add(3);

        int expected = 2;
        int result = binaryNode.find(2);

        assertEquals(expected, result);
    }

    @Test
    public void addNodeFindTest2(){
        IBinaryNode<Integer> binaryNode1 = new BinaryNode<Integer>();
        binaryNode1.add(1);
        IBinaryNode<Integer> binaryNode2 = new BinaryNode<Integer>();
        binaryNode2.add(2);
        binaryNode1.add(binaryNode2);

        int expected = 2;
        int result = binaryNode1.find(2);

        assertEquals(expected, result);
    }

    @Test
    public void emptyTreeFindTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();

        Integer expected = null;
        Integer result = binaryNode.find(1);

        assertEquals(expected, result);
    }

    @Test
    public void addNullTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(1);


        Exception exception = assertThrows(RuntimeException.class, () -> {
            binaryNode.add((Integer) null);
        });

        String expectedMessage = "null not allowed";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
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
    public void RemoveNodeByNodeLeafTest1(){
        IBinaryNode<Integer> binaryNode1 = new BinaryNode<Integer>();
        binaryNode1.add(1);
        IBinaryNode<Integer> binaryNode2 = new BinaryNode<Integer>();
        binaryNode2.add(2);
        binaryNode1.add(binaryNode2);

        IBinaryNode<Integer> deletedNode = binaryNode1.remove(binaryNode2);

        IBinaryNode<Integer> expected = binaryNode2;
        IBinaryNode<Integer> result = deletedNode;

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
    public void removeFindLeafTest1(){
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
    public void removeFindRightChildTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(5);
        binaryNode.add(10);
        binaryNode.add(15);

        binaryNode = binaryNode.remove(10);

        Integer expected = null;
        Integer result = binaryNode.find(10);

        assertEquals(expected, result);
    }

    @Test
    public void removeFindLeftChildTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(15);
        binaryNode.add(10);
        binaryNode.add(5);

        binaryNode = binaryNode.remove(10);

        Integer expected = null;
        Integer result = binaryNode.find(10);

        assertEquals(expected, result);
    }

    @Test
    public void removeDepthRightChildTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(5);
        binaryNode.add(10);
        binaryNode.add(15);

        binaryNode = binaryNode.remove(10);

        Integer expected = 1;
        Integer result = binaryNode.getDepth(15);

        assertEquals(expected, result);
    }

    @Test
    public void removeDepthLeftChildTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(15);
        binaryNode.add(10);
        binaryNode.add(5);

        binaryNode = binaryNode.remove(10);

        Integer expected = 1;
        Integer result = binaryNode.getDepth(5);

        assertEquals(expected, result);
    }

    @Test
    public void removeFindTwoChildrenNoRootTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);
        binaryNode.add(23);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);
        binaryNode.add(31);

        binaryNode = binaryNode.remove(24);

        Integer expected = null;
        Integer result = binaryNode.find(24);

        assertEquals(expected, result);
    }

    @Test
    public void removeDepthTwoChildrenNoRootTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);
        binaryNode.add(23);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);
        binaryNode.add(31);

        binaryNode = binaryNode.remove(24);

        Integer expected = 2;
        Integer result = binaryNode.getDepth(20);

        assertEquals(expected, result);
    }

    @Test
    public void removeDepthTwoChildrenNoRootTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);
        binaryNode.add(23);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);
        binaryNode.add(31);

        //max van left child moet hierdoor de nieuwe depth 1 sjaak worden
        binaryNode = binaryNode.remove(24);

        Integer expected = 1;
        Integer result = binaryNode.getDepth(23);

        assertEquals(expected, result);
    }

    @Test
    public void removeFindTwoChildrenYesRootTest(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);
        binaryNode.add(23);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);
        binaryNode.add(31);

        binaryNode = binaryNode.remove(16);

        Integer expected = null;
        Integer result = binaryNode.find(16);

        assertEquals(expected, result);
    }

    @Test
    public void removeFindTwoChildrenMaxChildParentDeletedTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);
        binaryNode.add(23);

        binaryNode.add(31);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);


        binaryNode = binaryNode.remove(24);

        Integer expected = null;
        Integer result = binaryNode.find(24);

        assertEquals(expected, result);
    }

    @Test
    public void removeFindTwoChildrenMaxChildParentDeletedTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);
        binaryNode.add(23);

        binaryNode.add(31);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);


        binaryNode = binaryNode.remove(24);

        Integer expected = 28;
        Integer result = binaryNode.find(28);

        assertEquals(expected, result);
    }

    @Test
    public void removeDepthTwoChildrenMaxChildParentDeletedTest1(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(23);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);
        binaryNode.add(31);


        binaryNode = binaryNode.remove(24);

        Integer expected = 1;
        Integer result = binaryNode.getDepth(23);

        assertEquals(expected, result);
    }

    @Test
    public void removeDepthTwoChildrenMaxChildParentDeletedTest2(){
        IBinaryNode<Integer> binaryNode = new BinaryNode<Integer>();
        binaryNode.add(16);
        binaryNode.add(8);
        binaryNode.add(24);

        binaryNode.add(4);
        binaryNode.add(2);
        binaryNode.add(1);
        binaryNode.add(3);
        binaryNode.add(6);
        binaryNode.add(5);
        binaryNode.add(7);

        binaryNode.add(12);
        binaryNode.add(10);
        binaryNode.add(9);
        binaryNode.add(11);
        binaryNode.add(14);
        binaryNode.add(13);
        binaryNode.add(15);

        binaryNode.add(23);

        binaryNode.add(20);
        binaryNode.add(18);
        binaryNode.add(17);
        binaryNode.add(19);
        binaryNode.add(22);
        binaryNode.add(21);

        binaryNode.add(28);
        binaryNode.add(26);
        binaryNode.add(25);
        binaryNode.add(27);
        binaryNode.add(30);
        binaryNode.add(29);
        binaryNode.add(31);

        //System.out.println(binaryNode.findNode(18).getParent().getValue());
        //System.out.println(binaryNode.findNode(18).getParent().getParent().getValue());
        //System.out.println(binaryNode.findNode(18).getParent().getParent().getParent().getValue());
        //System.out.println(binaryNode.findNode(18).getParent().getParent().getParent().getParent().getValue());

        binaryNode = binaryNode.remove(24);

        //System.out.println(binaryNode.find(23));
        //System.out.println(binaryNode.getDepth(23));
        //System.out.println(binaryNode.find(28));
        //System.out.println(binaryNode.getDepth(28));
        //System.out.println(binaryNode.find(20));
        //System.out.println(binaryNode.getDepth(20));

        Integer expected = 3;
        Integer result = binaryNode.getDepth(18);

        System.out.println(binaryNode.findNode(18).getParent().getValue());
        System.out.println(binaryNode.findNode(18).getParent().getParent().getValue());
        //System.out.println(binaryNode.findNode(18).getParent().getParent().getParent().getValue());

        assertEquals(expected, result);
    }
}
