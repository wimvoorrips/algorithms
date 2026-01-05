package algorithms.insertionsort;
import algorithms.mergesort.ComparableMergeSort;
import algorithms.mergesort.IComparableMergeSort;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {

    @Test
    public void simpleTest1(){
        IInsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer[] unsortedArray = {2, 1, 3};


        insertionSort.sort(unsortedArray);
        Integer[] expected = {1, 2, 3};
        Integer[] result = unsortedArray;
        assertArrayEquals(expected, result);
    }

    @Test
    public void simpleTest2(){
        IInsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer[] unsortedArray = {2, 1, 3, 5, 9, 4};


        insertionSort.sort(unsortedArray);
        Integer[] expected = {1, 2, 3, 4, 5, 9};
        Integer[] result = unsortedArray;
        assertArrayEquals(expected, result);
    }

    @Test
    public void simpleTest3(){
        IInsertionSort<String> insertionSort = new InsertionSort<String>();
        String[] unsortedArray = {"a","d","b","e","c",};


        insertionSort.sort(unsortedArray);
        String[] expected = {"a","b","c","d","e",};
        String[] result = unsortedArray;
        assertArrayEquals(expected, result);
    }

    @Test
    public void nullValuesTest(){
        IInsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer[] unsortedArray = {null, 1, 2, null, 1, 2};


        insertionSort.sort(unsortedArray);
        Integer[] expected = {null, null, 1, 1, 2, 2};
        Integer[] result = unsortedArray;
        assertArrayEquals(expected, result);
    }

    @Test
    public void doubleValuesTest(){
        IInsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer[] unsortedArray = {1, 2, 1, 2, 1, 2};


        insertionSort.sort(unsortedArray);
        Integer[] expected = {1, 1, 1, 2, 2, 2};
        Integer[] result = unsortedArray;
        assertArrayEquals(expected, result);
    }


    @Test
    public void performanceTestSorted(){
        IInsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer[] unsortedArray = new Integer[10000];
        for(int i = 0; i < unsortedArray.length; i++){
            unsortedArray[i] = i;
        }


        insertionSort.sort(unsortedArray);
        Integer result = unsortedArray[0];
        Integer expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void performanceTestUnsorted(){
        IInsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
        Integer[] unsortedArray = new Integer[10000];
        for(int i = 0; i < unsortedArray.length; i++){
            unsortedArray[i] = -i;
        }

        insertionSort.sort(unsortedArray);
        Integer result = unsortedArray[0];
        Integer expected = -9999;
        assertEquals(expected, result);
    }
}
