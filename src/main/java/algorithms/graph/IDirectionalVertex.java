package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;

public interface IDirectionalVertex {
    int getId();

    void addEdge();
    void removeEdge();
    ILinkedListOneDirection getEdges();
}
