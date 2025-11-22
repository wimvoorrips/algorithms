package algorithms.priorityqueue;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.ISegmentOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;

public class PriorityQueue <T> implements IPriorityQueue<T> {

    protected IPriorityQueueSegment<T> head;
    protected IPriorityQueueSegment<T> tail;


    PriorityQueue(){
        head = new PriorityQueueSegment<T>(null, 0);
        tail = new PriorityQueueSegment<T>(null, 0);
        head.setNextSegment(tail);
        tail.setPreviousSegment(head);
    }

    /**
     * plaats het nieuwe item als laatste in de lijst van die priority
     * @param data
     * @param priority
     */
    @Override
    public void enqueue(T data, int priority) {
        // find last occurence of certain priority
        IPriorityQueueSegment<T> previousSegment = tail.getPreviousSegment();
        while(
                previousSegment.getPriority() > priority && previousSegment != head
        ){
            previousSegment = previousSegment.getPreviousSegment();
        }

        IPriorityQueueSegment<T> nextSegment = previousSegment.getNextSegment();
        IPriorityQueueSegment<T> newSegment = new PriorityQueueSegment<T>(data, priority);
        previousSegment.setNextSegment(newSegment);
        nextSegment.setPreviousSegment(newSegment);
        newSegment.setPreviousSegment(previousSegment);
        newSegment.setNextSegment(nextSegment);
    }

    @Override
    public T dequeue() {
        if(head.getNextSegment() == tail){
            return null;
        }

        IPriorityQueueSegment<T> segment = head.getNextSegment();
        head.setNextSegment(segment.getNextSegment());
        head.getNextSegment().setPreviousSegment(head);

        return segment.getData();
    }

    @Override
    public T getFirst() {
        return head.getNextSegment().getData();
    }

    private IPriorityQueueSegment<T> getLastSegment(){
        return tail.getPreviousSegment();
    }
}
