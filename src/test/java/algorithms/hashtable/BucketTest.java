package algorithms.hashtable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BucketTest {

    @Test
    public void setGetDataTest(){
        IBucket<Integer> bucket = new Bucket<>("a", 1);
        Integer result = bucket.getData();
        Integer expected = 1;

        assertEquals(expected, result);
    }

    @Test
    public void setGetDataLongKeyTest(){
        String key = "";
        for(int i = 0; i < 100000; i++){
            key += "a";
        }
        IBucket<Integer> bucket = new Bucket<>(key, 1);
        Integer result = bucket.getData();
        Integer expected = 1;

        assertEquals(expected, result);
    }

    @Test
    public void setGetKeyTest(){
        IBucket<Integer> bucket = new Bucket<>("a", 1);
        String result = bucket.getKey();
        String expected = "a";

        assertEquals(expected, result);
    }

    @Test
    public void setGetLongKeyTest(){
        String key = "";
        for(int i = 0; i < 100000; i++){
            key += "a";
        }
        IBucket<Integer> bucket = new Bucket<>(key, 1);
        String result = bucket.getKey();
        String expected = key;

        assertEquals(expected, result);
    }

    @Test
    public void updateDataTest(){
        IBucket<Integer> bucket = new Bucket<>("a", 1);
        bucket.update("a", 2);
        Integer result = bucket.getData();
        Integer expected = 2;

        assertEquals(expected, result);
    }

    @Test
    public void updateKeyTest(){
        IBucket<Integer> bucket = new Bucket<>("a", 1);
        bucket.update("b", 1);
        String result = bucket.getKey();
        String expected = "b";

        assertEquals(expected, result);
    }

    @Test
    public void removeKeyGetDataTest(){
        IBucket<Integer> bucket = new Bucket<>("a", 1);
        bucket.removeKey();
        Integer result = bucket.getData();
        Integer expected = null;

        assertEquals(expected, result);
    }

    @Test
    public void removeKeyGetKeyTest(){
        IBucket<Integer> bucket = new Bucket<>("a", 1);
        bucket.removeKey();
        String result = bucket.getKey();
        String expected = null;

        assertEquals(expected, result);
    }

}
