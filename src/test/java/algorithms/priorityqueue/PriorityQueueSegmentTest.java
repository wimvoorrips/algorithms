package algorithms.priorityqueue;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueSegmentTest {

    @Test
    public void setGetNextSegmentTest(){
        IPriorityQueueSegment<Integer> priorityQueueSegment1 = new PriorityQueueSegment<>(1, 10);
        IPriorityQueueSegment<Integer> priorityQueueSegment2 = new PriorityQueueSegment<>(2, 11);

        priorityQueueSegment1.setNextSegment(priorityQueueSegment2);

        IPriorityQueueSegment<Integer> result = priorityQueueSegment1.getNextSegment();
        IPriorityQueueSegment<Integer> expected = priorityQueueSegment2;
        assertEquals(expected, result);
    }

    @Test
    public void setGetPreviousSegmentTest(){
        IPriorityQueueSegment<Integer> priorityQueueSegment1 = new PriorityQueueSegment<>(1, 10);
        IPriorityQueueSegment<Integer> priorityQueueSegment2 = new PriorityQueueSegment<>(2, 11);

        priorityQueueSegment1.setPreviousSegment(priorityQueueSegment2);

        IPriorityQueueSegment<Integer> result = priorityQueueSegment1.getPreviousSegment();
        IPriorityQueueSegment<Integer> expected = priorityQueueSegment2;
        assertEquals(expected, result);
    }

    @Test
    public void getDataTest(){
        IPriorityQueueSegment<Integer> priorityQueueSegment1 = new PriorityQueueSegment<>(1, 10);

        Integer result = priorityQueueSegment1.getData();
        Integer expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void getNullDataTest(){
        IPriorityQueueSegment<Integer> priorityQueueSegment1 = new PriorityQueueSegment<>(null, 10);

        Integer result = priorityQueueSegment1.getData();
        Integer expected = null;
        assertEquals(expected, result);
    }

    @Test
    public void getPriorityTest(){
        IPriorityQueueSegment<Integer> priorityQueueSegment1 = new PriorityQueueSegment<>(1, 10);

        Integer result = priorityQueueSegment1.getPriority();
        Integer expected = 10;
        assertEquals(expected, result);
    }


    @Test
    public void getNegativePriorityTest(){
        IPriorityQueueSegment<Integer> priorityQueueSegment1 = new PriorityQueueSegment<>(1, -10);

        int result = priorityQueueSegment1.getPriority();
        int expected = -10;
        assertEquals(expected, result);
    }

}
