package algorithms.mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort <T> implements IMergeSort <T> {

    public MergeSort(){

    }

    public T[] sort(Class<T> clazz, T[] arrayToMergeSort){
        //System.out.println("lengte");
        //System.out.println(arrayToMergeSort.length);

        if(arrayToMergeSort.length < 2){
            return arrayToMergeSort;
        }

        int middle = arrayToMergeSort.length / 2;
        //System.out.println(middle);

        T[] firstSet = Arrays.copyOfRange(arrayToMergeSort, 0, middle);
        T[] secondSet = Arrays.copyOfRange(arrayToMergeSort, middle, arrayToMergeSort.length);

        //System.out.println(firstSet[0]);
        //System.out.println(secondSet[0] +","+secondSet[1]);

        T[] sortedFirstSet = this.sort(clazz, firstSet);
        T[] sortedSecondSet = this.sort(clazz, secondSet);

        return merge(clazz, sortedFirstSet, sortedSecondSet);

    }

    private T[] merge(Class<T> clazz, T[] firstArray, T[] secondArray){
        //System.out.println("merge lengte " + firstArray.length + " en " + secondArray.length);
        //System.out.println(firstArray.length);
        //System.out.println(secondArray.length);

        Comparable<T>[] firstComparableArray = arrayToComparable(firstArray);

        //T[] mergedArray = (T[]) new Comparable[firstArray.length + secondArray.length];
        //T[] mergedArray = (T[]) Array.newInstance(,[firstArray.length + secondArray.length];
        T[] mergedArray = (T[]) Array.newInstance(clazz, firstArray.length + secondArray.length);

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int mergedArrayIndex = 0;

        //System.out.println("lengte van mergedArray: " + mergedArray.length);

        while (mergedArrayIndex < mergedArray.length){
            //System.out.println("index:" + firstArrayIndex);
            if(
                firstArrayIndex < firstArray.length &&
                (
                        secondArrayIndex >= secondArray.length ||
                        firstComparableArray[firstArrayIndex].compareTo( secondArray[secondArrayIndex] ) <= 0
                )

            ) {
                mergedArray[mergedArrayIndex] = firstArray[firstArrayIndex];
                firstArrayIndex += 1;
            } else {
                mergedArray[mergedArrayIndex] = secondArray[secondArrayIndex];
                secondArrayIndex += 1;
            }
            //System.out.println(mergedArrayIndex);
            //System.out.println(mergedArray[mergedArrayIndex]);
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
