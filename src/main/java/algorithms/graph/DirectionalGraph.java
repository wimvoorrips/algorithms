package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;

import java.util.function.Predicate;

public class DirectionalGraph<T> implements IDirectionalGraph<T> {

    ILinkedListOneDirection<IDirectionalVertex<T>> vertices = new LinkedListOneDirection<IDirectionalVertex<T>>();

    public DirectionalGraph(){

    }
    @Override
    public void addVertex(IDirectionalVertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addVertex(T data) {
        IDirectionalVertex<T> vertex = new DirectionalVertex<T>(data);
    }

    @Override
    public void addEdge(int fromVertexId, int toVertexId){
        addEdge(fromVertexId, toVertexId, 1);
    }

    @Override
    public void addEdge(int fromVertexIndex, int toVertexIndex, int weight) {
        IDirectionalVertex<T> fromVertex = vertices.get(fromVertexIndex);
        IDirectionalVertex<T> toVertex = vertices.get(toVertexIndex);

        fromVertex.addEdge(toVertex, weight);
    }

    public int find(Predicate<IDirectionalVertex<T>> condition){
        int index = vertices.find(condition);
        return index;
    }

    @Override
    public IDirectionalVertex<T> removeVertex(int vertexIndex) {
        IDirectionalVertex<T> deletedVertex = vertices.get(vertexIndex);

        // in elke vertex de edges checken
        for(int i = 0; i < vertices.getLength(); i++){
            IDirectionalVertex<T> currentVertex = vertices.get(i);

            Predicate<IWeightedDirectionalEdge<T>> condition = edge -> (edge.getTarget().equals(deletedVertex));
            currentVertex.removeEdge( condition );
        }

        // en daarna de echte vertex deleten
        vertices.remove(vertexIndex);

        return null;
    }
}
