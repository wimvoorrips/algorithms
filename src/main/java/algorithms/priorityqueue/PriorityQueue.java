package algorithms.priorityqueue;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.ISegmentOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;

public class PriorityQueue <T> implements IPriorityQueue{

    ILinkedListOneDirection<T> list;
    ISegmentOneDirection lastSegmentInList;

    PriorityQueue(){
        list  = new LinkedListOneDirection<T>();
       // lastSegmentInList =
    }
    @Override
    public void enqueue(Object data, int priority) {
        //lastSegmentInList
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }
}
