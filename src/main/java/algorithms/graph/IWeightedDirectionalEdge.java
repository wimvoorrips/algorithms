package algorithms.graph;

public interface IWeightedDirectionalEdge<T> {
    public IDirectionalVertex<T> getTarget();
    public int getWeight();
}
