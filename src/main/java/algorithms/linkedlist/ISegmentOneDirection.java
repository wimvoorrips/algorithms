package algorithms.linkedlist;

public interface ISegmentOneDirection <T>{

    ISegmentOneDirection<T> getNextSegment();

    void setNextSegment(ISegmentOneDirection<T> segment);
    T getData();
}
