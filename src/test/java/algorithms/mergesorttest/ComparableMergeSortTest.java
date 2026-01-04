package algorithms.mergesorttest;

import algorithms.insertionsort.IInsertionSort;
import algorithms.insertionsort.InsertionSort;
import algorithms.mergesort.ComparableMergeSort;
import algorithms.mergesort.IComparableMergeSort;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComparableMergeSortTest {

    @Test
    public void simpleTest1(){
        IComparableMergeSort<Integer> comparableMergeSort = new ComparableMergeSort<>();
        Integer[] unsortedArray = {2, 1, 3};


        Integer[] result = comparableMergeSort.sort(unsortedArray);
        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void simpleTest2(){
        IComparableMergeSort<Integer> comparableMergeSort = new ComparableMergeSort<Integer>();
        Integer[] unsortedArray = {2, 1, 3, 5, 9, 4};


        Integer[] result =  comparableMergeSort.sort(unsortedArray);
        Integer[] expected = {1, 2, 3, 4, 5, 9};
        assertArrayEquals(expected, result);
    }

    @Test
    public void stringTest(){
        IComparableMergeSort<String> comparableMergeSort = new ComparableMergeSort<String>();
        String[] unsortedArray = {"a","d","b","e","c",};


        String[] result = comparableMergeSort.sort(unsortedArray);
        String[] expected = {"a","b","c","d","e",};
        assertArrayEquals(expected, result);
    }

    @Test
    public void dubbeleWaarden(){
        IComparableMergeSort<Integer> comparableMergeSort = new ComparableMergeSort<Integer>();
        Integer[] unsortedArray = {1, 2, 1, 2, 1, 2};


        Integer[] result = (Integer[]) comparableMergeSort.sort(unsortedArray);
        Integer[] expected = {1, 1, 1, 2, 2, 2};
        assertArrayEquals(expected, result);
    }

    @Test
    public void nullValuesTest(){
        IComparableMergeSort<Integer> comparableMergeSort = new ComparableMergeSort<>();
        Integer[] unsortedArray = {null, 1, 2, null, 1, 2};

        Integer[] result = comparableMergeSort.sort(unsortedArray);
        Integer[] expected = {null, null, 1, 1, 2, 2};

        assertArrayEquals(expected, result);
    }
}
