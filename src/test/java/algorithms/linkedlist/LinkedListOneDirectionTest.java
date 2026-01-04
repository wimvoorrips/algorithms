package algorithms.linkedlist;


import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListOneDirectionTest {

    @Test
    public void addGetTest1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10; i++){
            linkedListOneDirection.add(i);
        }
        int result = linkedListOneDirection.get(0);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void addGetTest2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10; i++){
            linkedListOneDirection.add(i);
        }
        int result = linkedListOneDirection.get(9);
        int expected = 9;
        assertEquals(expected, result);
    }

    @Test
    public void addRemoveTest1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10; i++){
            linkedListOneDirection.add(i);
        }

        int result = linkedListOneDirection.remove(0);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void addRemoveTest2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10; i++){
            linkedListOneDirection.add(i);
        }

        linkedListOneDirection.remove(0);

        int result = linkedListOneDirection.get(0);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void removeNonExistingTest(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10; i++){
            linkedListOneDirection.add(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            linkedListOneDirection.remove(20);
        });

        String expectedMessage = "\"segmentBeforeIndex\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void fillingGettingLinkedList1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }
        int result = linkedListOneDirection.get(0);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void fillingGettingLinkedList2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }
        int result = linkedListOneDirection.get(5000);
        int expected = 5000;
        assertEquals(expected, result);
    }

    @Test
    public void fillingGettingLinkedList3(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }
        int result = linkedListOneDirection.get(9999);
        int expected = 9999;
        assertEquals(expected, result);
    }

    @Test
    public void fillingGettingLinkedList4(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }
        Integer result = linkedListOneDirection.get(100000);
        Integer expected = null;
        assertEquals(expected, result);
    }


    @Test
    public void testFillingFindingLinkedList1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        int foundLocation = linkedListOneDirection.find(0);
        int expectedLocation = 0;
        assertEquals(expectedLocation, foundLocation);
    }

    @Test
    public void testFillingFindingLinkedList2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        int foundLocation = linkedListOneDirection.find(5000);
        int expectedLocation = 5000;
        assertEquals(expectedLocation, foundLocation);
    }

    @Test
    public void testFillingFindingLinkedList3(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        int foundLocation = linkedListOneDirection.find(9999);
        int expectedLocation = 9999;
        assertEquals(expectedLocation, foundLocation);
    }

    @Test
    public void testFillingFindingLinkedList4(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Predicate<Integer> tostringtest = item -> (item.toString().equals("9999"));
        int foundLocation = linkedListOneDirection.find(tostringtest);
        int expectedLocation = 9999;
        assertEquals(expectedLocation, foundLocation);
    }

    @Test
    public void testSettingFindingLinkedList1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        linkedListOneDirection.set(-50, 5000);

        int foundLocation = linkedListOneDirection.find(-50);
        int expectedLocation = 5000;
        assertEquals(expectedLocation, foundLocation);
    }

    @Test
    public void testSettingFindingLinkedList2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        linkedListOneDirection.set(50000, 5000);

        int foundLocation = linkedListOneDirection.find(50000);
        int expectedLocation = 5000;
        assertEquals(expectedLocation, foundLocation);
    }

    @Test
    public void testSettingGettingList1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        linkedListOneDirection.set(-50, 5000);

        int foundData = linkedListOneDirection.get(5000);
        int expectedData = -50;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void testSettingTooLow(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            linkedListOneDirection.set(1, -100);
        });

        String expectedMessage = "\"segmentBeforeIndex\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSettingTooHigh(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            linkedListOneDirection.set(1, 100000);
        });

        String expectedMessage = "\"segmentBeforeIndex\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGettingTooLow(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Integer foundData = linkedListOneDirection.get(-100);
        Integer expectedData = null;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void testGettingTooHigh(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Integer foundData = linkedListOneDirection.get(100000);
        Integer expectedData = null;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void testGetHeader(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Integer foundData = linkedListOneDirection.get(-1);
        Integer expectedData = null;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void testGetLength1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        linkedListOneDirection.add(1);


        int foundData = linkedListOneDirection.getLength();
        int expectedData = 1;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void testGetLength2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();

        int foundData = linkedListOneDirection.getLength();
        int expectedData = 0;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void testGetLength3(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        int foundData = linkedListOneDirection.getLength();
        int expectedData = 10000;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void addOnIndexTest1(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        linkedListOneDirection.add(10, 5000);

        int foundData = linkedListOneDirection.get(5000);
        int expectedData = 10;
        assertEquals(expectedData, foundData);
    }

    @Test
    public void addOnIndexTest2(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        linkedListOneDirection.add(10, 5000);

        int foundData = linkedListOneDirection.get(5001);
        int expectedData = 5000;
        assertEquals(expectedData, foundData);
    }
}
