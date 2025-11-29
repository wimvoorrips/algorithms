package algorithms.hashtable;

public interface IBucket <T> {
    void update(String key, T data);
    String getKey();
    T getData();
    void removeKey();

}
