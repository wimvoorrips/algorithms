package algorithms.graph;

public interface IDirectionalGraph {
    void addVertex(IDirectionalVertex vertex, int vertexId);
    void addEdge(int fromVertexId, int toVertexId);
    IDirectionalVertex removeVertex(int vertexId);

}
