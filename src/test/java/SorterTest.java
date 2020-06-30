import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @Test
    @Ignore
    void bubbleSort() {
        List<Integer> integers = Arrays.asList(5, 3, 4, 1, 2);
        Integer[] ints = {1, 2, 3, 4, 5};
        Integer[] ts = Sorter.bubbleSort(integers).toArray(new Integer[0]);
        assertArrayEquals( ints, ts);
    }

    @Test
    void mergeSortOneElement() {
        int[] arr = {1};
        int[] sortedArr = {1};
        assertArrayEquals(sortedArr, Sorter.mergeSort(arr));
    }

    @Test
    void mergeSortTwo() {
            int[] arr = {5, 3};
            int[] sortedArr = {3,5};
            int[] sortedArr2 = {3,5};
            assertArrayEquals(sortedArr, Sorter.mergeSort(arr));
            assertArrayEquals(sortedArr2, Sorter.mergeSort(sortedArr));
        }
    @Test
    void mergeSort() {
        int[] arr = {3, 1, 2};
        int[] sortedArr = {1,2,3};
        int[] sortedArr2 = {1,2,3};
        assertArrayEquals(sortedArr, Sorter.mergeSort(arr));
        assertArrayEquals(sortedArr2, Sorter.mergeSort(sortedArr));
    }



    @Test
    void mergeSortFib() {
        int[] arr = {8,1,2,3,5,1,13,34,21,55};
        int[] sortedArr = {1,1,2,3,5,8,13,21,34,55};
        int[] sortedArr2 = {1,1,2,3,5,8,13,21,34,55};
        assertArrayEquals(sortedArr, Sorter.mergeSort(arr));
        assertArrayEquals(sortedArr2, Sorter.mergeSort(sortedArr));
    }
}