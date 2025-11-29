package algorithms.hashtable;

public class Bucket<T> implements IBucket<T> {
    String key;
    T data;

    Bucket(String key, T data){
        update(key, data);
    }

    @Override
    public void update(String key, T data){
        this.key = key;
        this.data = data;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void removeKey() {
        key = null;
        data = null;
    }
}
