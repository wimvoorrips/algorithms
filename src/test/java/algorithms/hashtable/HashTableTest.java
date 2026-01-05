package algorithms.hashtable;
import org.junit.Test;

import static org.junit.Assert.*;


public class HashTableTest {
    @Test
    public void simpleTest1(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        int expected = 1;
        int result = hashTable.get("Een");

        assertEquals(expected, result);
    }

    @Test
    public void simpleTest2(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        hashTable.store("Twee", 2);
        int expected = 1;
        int result = hashTable.get("Een");

        assertEquals(expected, result);
    }

    @Test
    public void simpleTest3(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        hashTable.store("Twee", 2);
        int expected = 2;
        int result = hashTable.get("Twee");

        assertEquals(expected, result);
    }

    @Test
    public void nonExisting(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        hashTable.store("Twee", 2);
        Integer expected = null;
        Integer result = hashTable.get("Drie");

        assertEquals(expected, result);
    }

    @Test
    public void expanding1(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        hashTable.store("Twee", 2);
        hashTable.store("Drie", 3);
        hashTable.store("Vier", 4);
        hashTable.store("Vijf", 5);
        hashTable.store("Zes", 6);
        Integer expected = 1;
        Integer result = hashTable.get("Een");

        assertEquals(expected, result);
    }

    @Test
    public void expanding2(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        hashTable.store("Twee", 2);
        hashTable.store("Drie", 3);
        hashTable.store("Vier", 4);
        hashTable.store("Vijf", 5);
        hashTable.store("Zes", 6);
        Integer expected = 6;
        Integer result = hashTable.get("Zes");

        assertEquals(expected, result);
    }

    @Test
    public void expanding3(){
        IHashTable<Integer> hashTable = new HashTable<>();
        for(int i = 32; i < 255; i++){
            hashTable.store(Character.toString((char) i), i);
        }

        Integer expected = 52;
        Integer result = hashTable.get("4");

        assertEquals(expected, result);
    }

    @Test
    public void overwriting(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("Een", 1);
        hashTable.store("Een", 2);
        Integer expected = 2;
        Integer result = hashTable.get("Een");

        assertEquals(expected, result);
    }

    @Test
    public void duplicateHashes1(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("A", 1); //101 modulo 5 = 1
        hashTable.store("F", 2); //106 modulo 5 = 1
        Integer expected = 1;
        Integer result = hashTable.get("A");

        assertEquals(expected, result);
    }

    @Test
    public void duplicateHashes2(){
        IHashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("A", 1); //101 modulo 5 = 1
        hashTable.store("F", 2); //106 modulo 5 = 1
        Integer expected = 2;
        Integer result = hashTable.get("F");

        assertEquals(expected, result);
    }

    @Test
    public void removal1(){
        HashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("A", 1); //101 modulo 5 = 1
        hashTable.store("B", 2);
        hashTable.removeKey("A");
        Integer expected = null;
        Integer result = hashTable.get("A");

        assertEquals(expected, result);
    }

    @Test
    public void removal2(){
        HashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("A", 1); //101 modulo 5 = 1
        hashTable.store("F", 2); //106 modulo 5 = 1
        hashTable.store("I", 3); //111 modulo 5 = 1
        hashTable.removeKey("A");
        Integer expected = 2;
        Integer result = hashTable.get("F");

        assertEquals(expected, result);
    }

    @Test
    public void removal3(){
        HashTable<Integer> hashTable = new HashTable<>();
        hashTable.store("A", 1); //101 modulo 5 = 1
        hashTable.store("F", 2); //106 modulo 5 = 1
        hashTable.store("I", 3); //111 modulo 5 = 1
        hashTable.removeKey("A");
        hashTable.removeKey("F");
        hashTable.store("F", 2); //106 modulo 5 = 1
        Integer expected = 2;
        Integer result = hashTable.get("F");

        assertEquals(expected, result);
    }

    @Test
    public void nullKeyTest(){
        HashTable<Integer> hashTable = new HashTable<>();

        Exception exception = assertThrows(NullPointerException.class, () -> {
            hashTable.store(null, 1); //101 modulo 5 = 1
        });

        String expectedMessage = "\"key\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void nullDataTest(){
        HashTable<Integer> hashTable = new HashTable<>();

        hashTable.store("A", null); //101 modulo 5 = 1

        Integer expected = null;
        Integer result = hashTable.get("A");

        assertEquals(expected, result);
    }


}
