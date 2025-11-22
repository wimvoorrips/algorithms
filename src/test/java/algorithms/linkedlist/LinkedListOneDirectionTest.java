package algorithms.linkedlist;


import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListOneDirectionTest {

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
    public void testSettingGettingTooLow(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            linkedListOneDirection.get(-100);
        });

        String expectedMessage = "\"segmentBeforeIndex\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testSettingGettingTooHigh(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            linkedListOneDirection.get(100000);
        });

        String expectedMessage = "\"segmentBeforeIndex\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetHeader(){
        ILinkedListOneDirection<Integer> linkedListOneDirection = new LinkedListOneDirection<Integer>();
        for(int i = 0; i < 10000; i++){
            linkedListOneDirection.add(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            linkedListOneDirection.get(-1);
        });

        String expectedMessage = "\"segmentBeforeIndex\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
