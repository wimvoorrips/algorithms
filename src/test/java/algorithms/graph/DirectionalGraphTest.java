package algorithms.graph;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionalGraphTest {

    @Test
    public void addFindVertexTest1(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);

        Predicate<IDirectionalVertex<Integer>> condition = target -> (target.getData() == 1);

        int result = directionalGraph.findIndex(condition);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void addFindVertexTest2(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        Predicate<IDirectionalVertex<Integer>> condition = target -> (target.getData() == 2);

        int result = directionalGraph.findIndex(condition);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void addFindEdgeTest1(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1);

        Predicate<IDirectionalVertex<Integer>> condition = target -> (target.getEdges().get(0).getWeight() == 1);

        int result = directionalGraph.findIndex(condition);
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void addFindEdgeTest2(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(1, 2, 10);

        Predicate<IDirectionalVertex<Integer>> condition = target -> (target.getEdges().get(0).getWeight() == 10);

        int result = directionalGraph.findIndex(condition);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void addFindNonexistingEdgeTest2(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(1, 3, 10);

        Predicate<IDirectionalVertex<Integer>> condition = target -> (target.getEdges().get(0).getWeight() == 10);

        int result = directionalGraph.findIndex(condition);
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraTest1(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(1, 2, 10);

        double result = directionalGraph.dijkstra(0,1);
        double expected = 15;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraTest2(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(1, 2, 10);

        double result = directionalGraph.dijkstra(0,2);
        double expected = 25;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraTest3(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(1, 2, 10);

        double result = directionalGraph.dijkstra(1,0);
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraTest4(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(0, 1, 10);
        directionalGraph.addEdge(0, 1, 12);

        double result = directionalGraph.dijkstra(0,1);
        double expected = 10;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraTest5(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);

        directionalGraph.addEdge(0, 1, 15);
        directionalGraph.addEdge(0, 1, 10);
        directionalGraph.addEdge(0, 1, 12);

        double result = directionalGraph.dijkstra(0,0);
        double expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraLoopTest1(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 2);
        directionalGraph.addEdge(1, 2, 2);
        directionalGraph.addEdge(2, 0, -10);

        double result = directionalGraph.dijkstra(0,0);
        double expected = -6;
        assertEquals(expected, result);
    }

    @Test
    public void dijkstraLoopTest2(){
        IDirectionalGraph<Integer> directionalGraph = new DirectionalGraph<>();
        directionalGraph.addVertex(1);
        directionalGraph.addVertex(2);
        directionalGraph.addVertex(3);

        directionalGraph.addEdge(0, 1, 3);
        directionalGraph.addEdge(1, 2, 2);
        directionalGraph.addEdge(2, 0, 1);

        double result = directionalGraph.dijkstra(0,2);
        double expected = 5;
        assertEquals(expected, result);
    }
}
