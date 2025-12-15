package algorithms.graph;

public class WeightedDirectionalEdge<T> implements IWeightedDirectionalEdge<T> {
    int weight;
    IDirectionalVertex<T> target;

    WeightedDirectionalEdge(IDirectionalVertex<T> target, int weight){
        this.target = target;
        this.weight = weight;
    }

    public IDirectionalVertex<T> getTarget(){
        return target;
    }

    public int getWeight(){
        return weight;
    }
}
