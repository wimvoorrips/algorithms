package algorithms.stack;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ListStackTest {
    @Test
    public void PushPop(){
        IStack<Integer> listStack = new ListStack<Integer>();
        for(int i = 0; i < 10000; i++){
            listStack.push(i);
        }
        listStack.pop();
        int result = listStack.pop();
        int expected = 9998;
        assertEquals(expected, result);
    }

    @Test
    public void PushTop(){
        IStack<Integer> listStack = new ListStack<Integer>();
        for(int i = 0; i < 10000; i++){
            listStack.push(i);
        }
        listStack.top();
        int result = listStack.top();
        int expected = 9999;
        assertEquals(expected, result);
    }

    @Test
    public void PopMoreThanExists(){
        IStack<Integer> listStack = new ListStack<Integer>();
        for(int i = 0; i < 10000; i++){
            listStack.push(i);
        }

        Exception exception = assertThrows(NullPointerException.class, () -> {
            for(int i = 0; i < 100000; i++){
                listStack.pop();
            }
        });

        String expectedMessage = "\"segmentToBeRemoved\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
