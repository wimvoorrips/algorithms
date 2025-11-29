package algorithms.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ComparableMergeSort<T extends Comparable<T>> implements IComparableMergeSort <T> {

    public ComparableMergeSort(){

    }

    public T[] sort(T[] arrayToMergeSort) {

        if(arrayToMergeSort.length < 2){
            return arrayToMergeSort;
        }

        int middle = arrayToMergeSort.length / 2;

        T[] firstSet = Arrays.copyOfRange(arrayToMergeSort, 0, middle);
        T[] secondSet = Arrays.copyOfRange(arrayToMergeSort, middle, arrayToMergeSort.length);

        T[] sortedFirstSet = this.sort(firstSet);
        T[] sortedSecondSet = this.sort(secondSet);

        return merge(sortedFirstSet, sortedSecondSet);
    }

    private T[] merge (T[] array1, T[] array2){
        T[] mergedArray = (T[]) Array.newInstance(array1.getClass().getComponentType(), array1.length + array2.length);
        //T[] mergedArray = (T[]) new Comparable[array1.length + array2.length];

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int mergedArrayIndex = 0;

        while (mergedArrayIndex < mergedArray.length){
            if(
                    firstArrayIndex < array1.length &&
                    (
                           secondArrayIndex >= array2.length ||
                           array1[firstArrayIndex].compareTo((T) array2[secondArrayIndex]) <= 0
                    )
            ) {
                mergedArray[mergedArrayIndex] = array1[firstArrayIndex];
                firstArrayIndex += 1;
            } else {
                mergedArray[mergedArrayIndex] = array2[secondArrayIndex];
                secondArrayIndex += 1;
            }
            mergedArrayIndex += 1;
        }

        return mergedArray;
    };
}
