package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;

import java.util.function.Predicate;

public interface IDirectionalVertex<T> {

    T getData();
    void addEdge(IDirectionalVertex<T> targetVertex, int weight);
    void removeEdge(Predicate<IWeightedDirectionalEdge<T>> condition);
    ILinkedListOneDirection<IWeightedDirectionalEdge<T>> getEdges();
}
