import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSorterTest {

    @Test
    void sortEmptyAndOneElement() {
        int[] arrEmpty = new int[0], arrEmpty2 = new int[0];
        int[] arrOne = {2}, arrOne2 = {2};

        QuickSorter.sort(arrEmpty);
    }
    @Test
    void sortTwoItems() {
        int[] arr = {5, 3};
        int[] sortedArr = {3,5};
        int[] sortedArr2 = {3,5};
        assertArrayEquals(sortedArr, QuickSorter.sort(arr));
        assertArrayEquals(sortedArr2, QuickSorter.sort(sortedArr));
    }
    @Test
    void pivotForNullAndEmpty() {
        int[] arrEmpty = new int[0], arrNull = null;
        Integer pivotPosition = QuickSorter.placeLastElementInMiddleOfValues(arrEmpty, 0, 0);
        assertNull(pivotPosition);
        pivotPosition = QuickSorter.placeLastElementInMiddleOfValues(arrNull, 0, 0);
        assertNull(pivotPosition);
    }

    @Test
    void pivotForOne() {
        int[] arrEmpty = {6};
        Integer pivotPosition = QuickSorter.placeLastElementInMiddleOfValues(arrEmpty, 0, 0);
        assertEquals(0,pivotPosition);
    }
    @Test
    void pivotForTwo() {
        int[] arrPivotRightPlaceOne = {6, 8};
        int[] arrPivotWrongPlaceZero = {8, 6};
        assertEquals(1,QuickSorter.placeLastElementInMiddleOfValues(arrPivotRightPlaceOne, 0, 1));
        assertEquals(0,QuickSorter.placeLastElementInMiddleOfValues(arrPivotWrongPlaceZero, 0, 1));
    }


    @Test
    void pivotForTree() {
        int[] arrPivotRightPlace = {3, 6, 8};
        int[] arrPivotMoveMiddle = {8, 3, 6};
        int[] arrPivotMoveLow = {8, 6, 3};
        assertEquals(2,QuickSorter.placeLastElementInMiddleOfValues(arrPivotRightPlace, 0, 2));
        assertEquals(1,QuickSorter.placeLastElementInMiddleOfValues(arrPivotMoveMiddle, 0, 2));
        assertEquals(0,QuickSorter.placeLastElementInMiddleOfValues(arrPivotMoveLow, 0, 2));
    }

    @Test
    void pivotForSix() {
        int[] arrPivotRightPlace = {3, 6, 8,12,14,16};
        int[] arrPivotMoveMiddle = {8, 3, 7, 5, 3, 6};
        int[] arrPivotMoveLow = {8, 6, 3, 7, 5, 1};
        assertEquals(5,QuickSorter.placeLastElementInMiddleOfValues(arrPivotRightPlace, 0, 5));
        assertEquals(3,QuickSorter.placeLastElementInMiddleOfValues(arrPivotMoveMiddle, 0, 5));
        assertEquals(0,QuickSorter.placeLastElementInMiddleOfValues(arrPivotMoveLow, 0, 5));
    }

}