package algorithms.priorityqueue;

public interface IPriorityQueue<T> {
    public void enqueue(T data, int priority);
    public T dequeue();
    public T getFirst();
}
