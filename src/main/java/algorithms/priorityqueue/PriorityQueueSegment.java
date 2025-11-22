package algorithms.priorityqueue;

import algorithms.linkedlist.SegmentOneDirection;

public class PriorityQueueSegment<T> implements IPriorityQueueSegment<T> {

    private T data;
    private int priority;

    IPriorityQueueSegment<T> nextSegment;
    IPriorityQueueSegment<T> previousSegment;

    PriorityQueueSegment(T data, int priority){
        this.data = data;
        this.priority = priority;
    }

    @Override
    public IPriorityQueueSegment<T> getNextSegment() {
        return nextSegment;
    }

    @Override
    public IPriorityQueueSegment<T> getPreviousSegment() {
        return previousSegment;
    }

    @Override
    public void setNextSegment(IPriorityQueueSegment<T> segment) {
        nextSegment = segment;
    }

    @Override
    public void setPreviousSegment(IPriorityQueueSegment<T> segment) {
        previousSegment = segment;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
