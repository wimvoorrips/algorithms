package algorithms.linkedlist;

public class SegmentOneDirection <T> implements ISegmentOneDirection<T>{
    T segmentData;
    ISegmentOneDirection<T> nextSegment;

    SegmentOneDirection(T segmentData){
        this.segmentData = segmentData;
    }

    @Override
    public ISegmentOneDirection<T> getNextSegment() {
        return nextSegment;
    }

    @Override
    public void setNextSegment(ISegmentOneDirection<T> segment) {
        this.nextSegment = segment;
    }

    @Override
    public T getData(){
        return segmentData;
    }
}
