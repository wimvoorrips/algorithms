package algorithms.graph;

import java.util.function.Predicate;

public interface IDirectionalGraph<T> {
    void addVertex(T data);
    void addVertex(IDirectionalVertex<T> vertex);
    void addEdge(int fromVertexIndex, int toVertexIndex);
    void addEdge(int fromVertexIndex, int toVertexIndex, int weight);
    int findIndex(Predicate<IDirectionalVertex<T>> condition);
    T find(Predicate<IDirectionalVertex<T>> condition);
    IDirectionalVertex<T> removeVertex(int vertexIndex);

    double[] dijkstra(int originIndex);
    double dijkstra(int originIndex, int targetIndex);

}
