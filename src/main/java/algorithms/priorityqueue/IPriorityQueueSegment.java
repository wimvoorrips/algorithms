package algorithms.priorityqueue;

import algorithms.linkedlist.ISegmentOneDirection;

public interface IPriorityQueueSegment<T> {
    IPriorityQueueSegment<T> getNextSegment();
    IPriorityQueueSegment<T> getPreviousSegment();

    void setNextSegment(IPriorityQueueSegment<T> segment);
    void setPreviousSegment(IPriorityQueueSegment<T> segment);
    T getData();
    int getPriority();
}
