package algorithms.mergesort;

public interface IComparableMergeSort <T extends Comparable<T>> {
    T[] sort(T[] arrayToMergeSort);
}
