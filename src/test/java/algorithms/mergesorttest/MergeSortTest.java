package algorithms.mergesorttest;

import algorithms.mergesort.IMergeSort;
import algorithms.mergesort.MergeSort;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    @Test
    public void simpleTest1(){
        IMergeSort<Integer> mergeSort = new MergeSort<Integer>();
        Integer[] unsortedArray = {2, 1, 3};


        Integer[] result = mergeSort.sort(Integer.class, unsortedArray);
        Integer[] expected = {1, 2, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void simpleTest2(){
        IMergeSort<Integer> mergeSort = new MergeSort<Integer>();
        Integer[] unsortedArray = {2, 1, 3, 5, 9, 4};


        Integer[] result = mergeSort.sort(Integer.class, unsortedArray);
        Integer[] expected = {1, 2, 3, 4, 5, 9};
        assertArrayEquals(expected, result);
    }

    @Test
    public void dubbelewaarden(){
        IMergeSort<Integer> mergeSort = new MergeSort<Integer>();
        Integer[] unsortedArray = {1, 2, 1, 2, 1, 2};


        Integer[] result = mergeSort.sort(Integer.class, unsortedArray);
        Integer[] expected = {1, 1, 1, 2, 2, 2};
        assertArrayEquals(expected, result);
    }
}
