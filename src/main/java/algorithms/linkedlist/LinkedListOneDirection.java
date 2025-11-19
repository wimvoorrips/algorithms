package algorithms.linkedlist;

public class LinkedListOneDirection <T> implements ILinkedListOneDirection <T> {
    ISegmentOneDirection<T> head;

    LinkedListOneDirection(){
        head = new SegmentOneDirection<T>(null);
    }

    /**
     * add data to end of list
     * @param data
     */
    @Override
    public void add(T data) {
        ISegmentOneDirection<T> segment = head;
        while(segment.getNextSegment() != null){
            segment = segment.getNextSegment();
        }

        ISegmentOneDirection<T> newSegment = new SegmentOneDirection<T>(data);
        segment.setNextSegment(newSegment);
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

    private boolean isEmpty(){
        if(head.getNextSegment() == null){
            return true;
        }
        return false;
    }

    private ISegmentOneDirection<T> getPreviousSegment(int index){
        ISegmentOneDirection<T> segmentBeforeIndex = head;

        for(int counter = 0; counter < index; counter++){
            segmentBeforeIndex = segmentBeforeIndex.getNextSegment();
        }
        return segmentBeforeIndex;
    }
}
