package algorithms.insertionsort;

public class InsertionSort <T extends Comparable<T>> implements IInsertionSort<T> {

    InsertionSort(){

    }

    public void sort(T[] arrayToBeSorted){
        for(int i = 1; i < arrayToBeSorted.length; i++){
            sortOneValue(arrayToBeSorted, i);
        }
    }

    void sortOneValue(T[] arrayToBeSorted, int mainIndex){
        for(int i = mainIndex; i > 0; i--){
            if(arrayToBeSorted[i -1] != null){
                if( arrayToBeSorted[i] == null || arrayToBeSorted[i].compareTo(arrayToBeSorted[i-1]) < 0 ){
                    T valueToGetHigherIndex = arrayToBeSorted[i-1];
                    arrayToBeSorted[i-1] = arrayToBeSorted[i];
                    arrayToBeSorted[i] = valueToGetHigherIndex;
                }
            }
        }
    }
}
