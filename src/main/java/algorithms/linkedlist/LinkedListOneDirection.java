package algorithms.linkedlist;

import java.util.function.Predicate;

public class LinkedListOneDirection <T> implements ILinkedListOneDirection <T> {
    protected ISegmentOneDirection<T> head;

    public LinkedListOneDirection(){
        head = new SegmentOneDirection<T>(null);
    }

    /**
     * add data to end of list
     * @param data
     */
    @Override
    public void add(T data) {
        ISegmentOneDirection<T> lastSegment = walkToLastElement();
        ISegmentOneDirection<T> newSegment = new SegmentOneDirection<T>(data);
        lastSegment.setNextSegment(newSegment);
    }

    public void add(T data, int index) {
        ISegmentOneDirection<T> segmentBeforeIndex = getPreviousSegment(index);
        ISegmentOneDirection<T> segmentAfterIndex = segmentBeforeIndex.getNextSegment();

        ISegmentOneDirection<T> newSegment = new SegmentOneDirection<T>(data);
        segmentBeforeIndex.setNextSegment(newSegment);
        newSegment.setNextSegment(segmentAfterIndex);
    }

    /**
     * add data to any point of list
     * @param data
     * @param index
     */
    @Override
    public void set(T data, int index) {
        ISegmentOneDirection<T> segmentBeforeIndex = getPreviousSegment(index);
        ISegmentOneDirection<T> segmentAfterIndex = segmentBeforeIndex.getNextSegment();

        ISegmentOneDirection<T> newSegment = new SegmentOneDirection<T>(data);
        newSegment.setNextSegment(segmentAfterIndex);
        segmentBeforeIndex.setNextSegment(newSegment);

    }

    /**
     * get data at index
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        ISegmentOneDirection<T> segmentBeforeIndex = getPreviousSegment(index);
        if(segmentBeforeIndex == null){
            return null;
        }
        return segmentBeforeIndex.getNextSegment().getData();
    }

    /**
     * remove item from list
     * @param index
     * @return
     */
    @Override
    public T remove(int index) {
        ISegmentOneDirection<T> segmentBeforeIndex = getPreviousSegment(index);
        ISegmentOneDirection<T> segmentToBeRemoved = segmentBeforeIndex.getNextSegment();
        ISegmentOneDirection<T> segmentAfterIndex = segmentToBeRemoved.getNextSegment();

        segmentBeforeIndex.setNextSegment(segmentAfterIndex);
        return segmentToBeRemoved.getData();
    }

    /**
     * find first occurence of data
     * @param data
     * @return
     */
    public int find(T data){
        int currentSegmentNumber = -1;
        ISegmentOneDirection<T> segment = head;

        while(segment.getNextSegment() != null){
            currentSegmentNumber += 1;
            segment = segment.getNextSegment();
            if(segment.getData().equals(data)){
                return currentSegmentNumber;
            };
        }
        return -1;
    }

    /**
     * find based on condition
     * @param condition
     * @return
     */
    public int find(Predicate<T> condition){
        int currentSegmentNumber = -1;
        ISegmentOneDirection<T> segment = head;

        while(segment.getNextSegment() != null){
            currentSegmentNumber += 1;
            segment = segment.getNextSegment();
            if(condition.test(segment.getData())){
                return currentSegmentNumber;
            };
        }
        return -1;
    }

    private boolean isEmpty(){
        if(head.getNextSegment() == null){
            return true;
        }
        return false;
    }

    private ISegmentOneDirection<T> getPreviousSegment(int index){
        if(index < 0){
            return null;
        }

        ISegmentOneDirection<T> segmentBeforeIndex = head;
        for(int counter = 0; counter < index; counter++){
            if(segmentBeforeIndex == null){
                return null;
                //throw new RuntimeException("index does not exist");
            }
            segmentBeforeIndex = segmentBeforeIndex.getNextSegment();
        }
        return segmentBeforeIndex;
    }

    protected ISegmentOneDirection<T> walkToLastElement(){
        ISegmentOneDirection<T> segment = head;
        while(segment.getNextSegment() != null){
            segment = segment.getNextSegment();
        }
        return segment;
    }

    @Override
    public int getLength() {
        int currentSegmentNumber = -1;
        ISegmentOneDirection<T> segment = head;

        while(segment.getNextSegment() != null){
            currentSegmentNumber += 1;
            segment = segment.getNextSegment();
            ;
        }
        return currentSegmentNumber + 1;
    }
}
