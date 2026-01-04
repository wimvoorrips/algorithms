package algorithms.linkedlist;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentOneDirectionTest {

    @Test
    public void setGetNextSegmentTest(){
        ISegmentOneDirection<Integer> segmentOneDirection1 = new SegmentOneDirection<>(1);
        ISegmentOneDirection<Integer> segmentOneDirection2 = new SegmentOneDirection<>(2);

        segmentOneDirection1.setNextSegment(segmentOneDirection2);

        ISegmentOneDirection<Integer> result = segmentOneDirection1.getNextSegment();
        ISegmentOneDirection<Integer> expected = segmentOneDirection2;
        assertEquals(expected, result);
    }

    @Test
    public void GetNoNextSegmentTest(){
        ISegmentOneDirection<Integer> segmentOneDirection1 = new SegmentOneDirection<>(1);

        ISegmentOneDirection<Integer> result = segmentOneDirection1.getNextSegment();
        ISegmentOneDirection<Integer> expected = null;
        assertEquals(expected, result);
    }

    @Test
    public void GetDataTest(){
        ISegmentOneDirection<Integer> segmentOneDirection1 = new SegmentOneDirection<>(1);

        Integer result = segmentOneDirection1.getData();
        Integer expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void GetNoDataTest(){
        ISegmentOneDirection<Integer> segmentOneDirection1 = new SegmentOneDirection<>(null);

        Integer result = segmentOneDirection1.getData();
        Integer expected = null;
        assertEquals(expected, result);
    }


}
