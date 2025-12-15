package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;

import java.util.function.Predicate;

public class DirectionalVertex<T> implements IDirectionalVertex<T> {

    ILinkedListOneDirection<IWeightedDirectionalEdge<T>> edges = new LinkedListOneDirection<IWeightedDirectionalEdge<T>>();
    T data;

    public DirectionalVertex(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void addEdge(IDirectionalVertex<T> targetVertex, int weight){
        IWeightedDirectionalEdge<T> edge = new WeightedDirectionalEdge<T>(targetVertex, weight);
        edges.add(edge);
    }

    @Override
    public void removeEdge(Predicate<IWeightedDirectionalEdge<T>> condition) {
        boolean go = true;
        while(go) {
            int index = edges.find(condition);
            if(index >= 0){
                edges.remove(index);
            } else {
                go = false;
            }
        }
    }

    @Override
    public ILinkedListOneDirection<IWeightedDirectionalEdge<T>> getEdges() {
        return edges;
    }
}
