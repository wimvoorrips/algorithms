package algorithms.priorityqueue;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTest {
    @Test
    public void EnqueueGetFirst1(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10000; i++){
            priorityQueue.enqueue(i, i);
        }
        priorityQueue.getFirst();
        int result = priorityQueue.getFirst();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void EnqueueGetFirst2(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10000; i++){
            priorityQueue.enqueue(i, 10000 - i);
        }
        priorityQueue.getFirst();
        int result = priorityQueue.getFirst();
        int expected = 9999;
        assertEquals(expected, result);
    }

    @Test
    public void EnqueueDequeue1(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10000; i++){
            priorityQueue.enqueue(i, i);
        }
        priorityQueue.dequeue();
        int result = priorityQueue.dequeue();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void EnqueueDequeue2(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10000; i++){
            priorityQueue.enqueue(i, 10000 - i);
        }
        priorityQueue.dequeue();
        int result = priorityQueue.dequeue();
        int expected = 9998;
        assertEquals(expected, result);
    }

    @Test
    public void EnqueueInFront(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10000; i++){
            priorityQueue.enqueue(i, 10000);
        }
        priorityQueue.enqueue(12345,0);
        int result = priorityQueue.dequeue();
        int expected = 12345;
        assertEquals(expected, result);
    }

    @Test
    public void EnqueueNegative(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10000; i++){
            priorityQueue.enqueue(i, 0);
        }
        priorityQueue.enqueue(12345,-10);
        int result = priorityQueue.dequeue();
        int expected = 12345;
        assertEquals(expected, result);
    }

    @Test
    public void EnqueueEquals(){
        IPriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10; i++){
            priorityQueue.enqueue(i, 0);
        }
        priorityQueue.enqueue(12345,0);
        for(int i = 0; i < 10; i++){
            priorityQueue.dequeue();
        }

        int result = priorityQueue.dequeue();
        int expected = 12345;
        assertEquals(expected, result);
    }
}
