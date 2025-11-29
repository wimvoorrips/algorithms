package algorithms.hashtable;

public class HashTable<T> implements IHashTable<T> {
    IBucket<T>[] array;// = new IBucket<T>[];

    HashTable(){
        array = (IBucket<T>[]) new IBucket[5];
    }

    private int hash(String key) {
        int base = baseHash(key);
        int index = lineairProbing(key, base);
        return index;
    };

    private int baseHash(String key){
        int totalValue = 0;
        for(int i = 0; i < key.length(); i++){
            totalValue += (int) key.charAt(i);
        }
        return totalValue % array.length;
    }

    private int lineairProbing(String key, int startPosition) {
        //lastig ding. Prioriteitenlijst
        //1. We willen door alle aangemaakte buckets heen vanaf de orginele index tot we de key vinden of een lege plek
        //2. Als de key is gevonden kunnen we die locatie returnen
        //3. Als we de key niet vinden returnen we de eerste lege plek
        int index = startPosition;
        int firstValidPosition = -1;

        while (true){
            //als een cirkel door de array
            if(index == array.length){
                index = 0;
            }
            //als er niks meer is
            if(array[index] != null){

                //de eerste plek vinden waar technisch gezien plek is
                if(firstValidPosition == -1 && array[index].getKey() == null){
                    firstValidPosition = index;
                }
                //prioriteit 1 waar we moeten wezen
                if(array[index].getKey() != null &&array[index].getKey().equals(key)){
                    return index;
                }
            } else {
                //nooit gebruikte bucket
                if(firstValidPosition == -1){
                    firstValidPosition = index;
                }
                break;
            }

            index += 1;
            //hele rondje om
            if(index == startPosition){
                break;
            }
        }

        // als we hier zijn is er hopelijk een firstValidPosition
        if(firstValidPosition == -1){
            System.out.println("De hele hashmap zit vol");
            rebuildHashTable();
            return hash(key);
            //throw new Exception("De hele hashmap zit vol");
        }
        return firstValidPosition;

        /*
        int index = startPosition;
        int firstValidLocation = -1
        while(array[index] != null && ! array[index].getKey().equals(key)){
            if(array[index].getKey() == null && firstValidLocation == -1){
                firstValidLocation = index;
            }
            index += 1;
        }
        return index;*/
    }

    void rebuildHashTable(){
        //System.out.println("rebuild");
        //System.out.println(array.length);
        IBucket<T>[] oldArray = array.clone();
        array = (IBucket<T>[]) new IBucket[oldArray.length * 2];


        //IBucket<T>[] newArray = (IBucket<T>[]) new IBucket[oldArray.length * 2];
        for(int i = 0; i < oldArray.length; i++){
            if(oldArray[i] != null && oldArray[i].getKey() != null) {
                String key = oldArray[i].getKey();
                T value = oldArray[i].getData();

                store(key, value);
                //int newIndex = hash(key);
                //IBucket<T> bucket = new Bucket<T>(key, value);
                //array[newIndex] = bucket;
            }
        }
        //array = newArray;
    }

    @Override
    public void store(String key, T value) {
        //System.out.println("Store " + key + ": " + value);
        //System.out.println(key);
        int index = hash(key);
        //System.out.println(index);
        IBucket<T> bucket = new Bucket<T>(key, value);
        array[index] = bucket;
    }

    @Override
    public T get(String key) {
        int index = hash(key);
        //System.out.println(key);
        //System.out.println(index);
        if(array[index] == null){
            return null;
        }

        return array[index].getData();
    }

    public void removeKey(String key){
        int index = hash(key);
        array[index].removeKey();
    }
}
