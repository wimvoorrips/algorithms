package algorithms.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort <T> implements IMergeSort <T> {

    MergeSort(){

    }

    public T[] sort(T[] arrayToMergeSort){
        if(arrayToMergeSort.length < 2){
            return arrayToMergeSort;
        }

        int middle = arrayToMergeSort.length / 2;
        T[] firstSet = Arrays.copyOfRange(arrayToMergeSort, 0, middle);
        T[] secondSet = Arrays.copyOfRange(arrayToMergeSort, middle + 1, arrayToMergeSort.length);

        T[] sortedFirstSet = this.sort(firstSet);
        T[] sortedSecondSet = this.sort(secondSet);

        return merge(sortedFirstSet, sortedSecondSet);

    }

    private T[] merge(T[] firstArray, T[] secondArray){

        Comparable<T>[] firstComparableArray = arrayToComparable(firstArray);

        T[] mergedArray = (T[]) new Comparable[firstArray.length + secondArray.length];


        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int mergedArrayIndex = 0;

        while (mergedArrayIndex <= mergedArray.length){
            if(
                firstArrayIndex <= firstArray.length &&
                firstComparableArray[firstArrayIndex].compareTo( secondArray[secondArrayIndex] ) <= 0
            ) {
                mergedArray[mergedArrayIndex] = firstArray[firstArrayIndex];
                firstArrayIndex += 1;
            } else {
                mergedArray[mergedArrayIndex] = secondArray[secondArrayIndex];
                secondArrayIndex += 1;
            }
            mergedArrayIndex += 1;
        }

        return mergedArray;
    }

    private Comparable<T>[] arrayToComparable(T[] originalArray){
        Comparable<T>[] comparableArray = new Comparable[originalArray.length];
        for(int i = 0; i < originalArray.length; i++){
            comparableArray[i] = (Comparable<T>) originalArray[i];
        }
        return comparableArray;
    }

}
