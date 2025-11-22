package algorithms.stack;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListStackTest {
    @Test
    public void PushPop(){
        IStack<Integer> listStack = new ListStack<Integer>();
        for(int i = 0; i < 10000; i++){
            listStack.push(i);
        }
        int result = listStack.pop();
        int expected = 9999;
        assertEquals(expected, result);
    }
}
