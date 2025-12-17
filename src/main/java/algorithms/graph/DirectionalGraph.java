package algorithms.graph;

import algorithms.linkedlist.ILinkedListOneDirection;
import algorithms.linkedlist.LinkedListOneDirection;

import java.util.Arrays;
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
        addVertex(vertex);
    }

    @Override
    public void addEdge(int fromVertexId, int toVertexId){
        addEdge(fromVertexId, toVertexId, 1);
    }

    @Override
    public void addEdge(int fromVertexIndex, int toVertexIndex, int weight) {
        IDirectionalVertex<T> fromVertex = vertices.get(fromVertexIndex);
        IDirectionalVertex<T> toVertex = vertices.get(toVertexIndex);

        if(fromVertex == null || toVertex == null){
            throw new RuntimeException("vertex does not exist at this index");
        }

        fromVertex.addEdge(toVertex, weight);
    }

    public T find(Predicate<IDirectionalVertex<T>> condition){
        int index = vertices.find(condition);
        return vertices.get(index).getData();
    }

    public int findIndex(Predicate<IDirectionalVertex<T>> condition){
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

    public double dijkstra(int originIndex, int targetIndex){
        return dijkstra(originIndex)[targetIndex];
    }

    public double[] dijkstra(int originIndex){
        double[] distances = new double[vertices.getLength()];
        // status 0 if not reached, 1 if reached, 2 if done
        double[] vertexStatus = new double[vertices.getLength()];

        //then we set it to infinity
        Arrays.fill(distances, Double.POSITIVE_INFINITY);

        //dan de eerste vertex er in zetten
        distances[originIndex] = 0;
        vertexStatus[originIndex] = 1;

        int currentVertexIndex = originIndex;
        boolean done = false;
        while (! done){
            // do a thing with the vertex
            IDirectionalVertex<T> currentVertex = vertices.get(currentVertexIndex);
            for(int edgeIndex = 0; edgeIndex < currentVertex.getEdges().getLength(); edgeIndex++){
                IWeightedDirectionalEdge<T> edge = currentVertex.getEdges().get(edgeIndex);
                IDirectionalVertex<T> edgeTarget = edge.getTarget();

                System.out.println(currentVertexIndex);
                System.out.println(edgeIndex);

                System.out.println(currentVertex.getEdges().getLength());

                Predicate<IDirectionalVertex<T>> condition = vertex -> (vertex.equals(edgeTarget));
                int targetIndex = vertices.find(condition);

                if(targetIndex == -1){
                    throw new RuntimeException("vertex not found");
                }

                double weightToVertex = distances[currentVertexIndex] + edge.getWeight();
                if (weightToVertex < distances[targetIndex]){
                    distances[targetIndex] = weightToVertex;
                }

                //make sure to mark the targetvertex as visited
                if(vertexStatus[targetIndex] == 0){
                    vertexStatus[targetIndex] = 1;
                }
            }


            // set the vertex as done
            vertexStatus[currentVertexIndex] = 2;


            // find next vertex
            currentVertexIndex = -1;
            for(int i = 0; i < vertexStatus.length; i++){
                if (vertexStatus[i] == 1 ){
                    currentVertexIndex = i;
                }
            }
            if(currentVertexIndex == -1){
                done = true;
            }
        }
        return distances;
    }
}
