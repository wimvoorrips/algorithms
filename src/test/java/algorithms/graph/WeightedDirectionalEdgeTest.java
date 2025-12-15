package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightedDirectionalEdgeTest {
    @Test
    public void weightTest(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(1);
        IWeightedDirectionalEdge<Integer> weightedDirectionalEdge = new WeightedDirectionalEdge<Integer>(directionalVertex, 2);

        int result = weightedDirectionalEdge.getWeight();
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    public void targetTest(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(1);
        IWeightedDirectionalEdge<Integer> weightedDirectionalEdge = new WeightedDirectionalEdge<Integer>(directionalVertex, 2);

        IDirectionalVertex<Integer> result = weightedDirectionalEdge.getTarget();
        IDirectionalVertex<Integer> expected = directionalVertex;
        assertEquals(expected, result);
    }
}
