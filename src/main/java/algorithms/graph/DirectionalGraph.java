package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;

public class DirectionalGraph implements IDirectionalGraph {

    ILinkedListOneDirection<IDirectionalVertex> vertices = new LinkedListOneDirection<IDirectionalVertex>();

    public DirectionalGraph(){

    }
    @Override
    public void addVertex(IDirectionalVertex vertex, int vertexId) {

    }

    @Override
    public void addEdge(int fromVertexId, int toVertexId){
        addEdge(fromVertexId, toVertexId, 1);
    }

    //@Override
    public void addEdge(int fromVertexId, int toVertexId, int weight) {
        int fromVertexIndex = vertices.find(vertex -> vertex.getId() == fromVertexId);
        IDirectionalVertex fromVertex = vertices.get(fromVertexIndex);

        int toVertexIndex = vertices.find(vertex -> vertex.getId() == toVertexId);
        IDirectionalVertex toVertex = vertices.get(toVertexIndex);

        fromVertex.addEdge();
    }

    @Override
    public IDirectionalVertex removeVertex(int vertexId) {
        return null;
    }
}
