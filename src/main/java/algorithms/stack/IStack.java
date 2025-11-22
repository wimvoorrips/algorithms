package algorithms.stack;

public interface IStack<T> {
    void push(T data);

    T pop();

    T top();
}
