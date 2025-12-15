package algorithms.graph;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionalVertexTest {
    @Test
    public void dataTest(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(2);

        int result = directionalVertex.getData();
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    public void addEdgeTest1(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(2);

        int result = directionalVertex.getEdges().getLength();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void addEdgeTest2(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(2);
        directionalVertex.addEdge(directionalVertex, 1);

        int result = directionalVertex.getEdges().getLength();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void addEdgeTest3(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(2);
        for(int i = 0; i < 10000; i++) {
            directionalVertex.addEdge(directionalVertex, 1);
        }

        int result = directionalVertex.getEdges().getLength();
        int expected = 10000;
        assertEquals(expected, result);
    }

    @Test
    public void removeEdgeTest1(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(2);
        for(int i = 0; i < 10000; i++) {
            directionalVertex.addEdge(directionalVertex, 1);
        }

        Predicate<IWeightedDirectionalEdge<Integer>> condition = edge -> (edge.getWeight() == 1);
        directionalVertex.removeEdge( condition );

        int result = directionalVertex.getEdges().getLength();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void removeEdgeTest2(){
        IDirectionalVertex<Integer> directionalVertex = new DirectionalVertex<Integer>(2);
        for(int i = 0; i < 10000; i++) {
            IDirectionalVertex<Integer> newVertex = new DirectionalVertex<Integer>(i);
            directionalVertex.addEdge(newVertex, 1);
        }

        Predicate<IWeightedDirectionalEdge<Integer>> condition = edge -> (edge.getTarget().getData() == 1);
        directionalVertex.removeEdge( condition );

        int result = directionalVertex.getEdges().getLength();
        int expected = 9999;
        assertEquals(expected, result);
    }
}
