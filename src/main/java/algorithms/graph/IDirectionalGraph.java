package algorithms.graph;

import java.util.function.Predicate;

public interface IDirectionalGraph<T> {
    void addVertex(T data);
    void addVertex(IDirectionalVertex<T> vertex);
    void addEdge(int fromVertexIndex, int toVertexIndex);
    void addEdge(int fromVertexIndex, int toVertexIndex, int weight);
    int find(Predicate<IDirectionalVertex<T>> condition);
    IDirectionalVertex<T> removeVertex(int vertexIndex);

}
