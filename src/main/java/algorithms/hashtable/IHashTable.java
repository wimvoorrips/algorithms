package algorithms.hashtable;

public interface IHashTable <T> {
    void store(String key, T value);
    T get(String key);
    void removeKey(String key);
}
