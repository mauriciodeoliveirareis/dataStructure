import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public static List<Integer> bubbleSort(List<Integer> arr){
        for (int x = 0; x < arr.size(); x++) {
            for (int y = 0; y < arr.size() - 1 - x; y++) {
                if(arr.get(y) > arr.get(y+1)) {
                    Integer current = arr.get(y);
                    arr.set(y, arr.get(y+1));
                    arr.set(y+1, current);
                }
            }
        }
        return arr;
    }


    public static int[] mergeSort(int[] arr) {
        mergeSortArrayPartition(arr, 0, arr.length -1);
        return arr;
    }

    private static int[] mergeSortArrayPartition(int[] arr, int start, int end) {
        int subArrayLength = end - start + 1;
        if (subArrayLength == 1) {
            return arr;
        } else if (subArrayLength == 2) {
            if (arr[start] > arr[end]) swapStartEndItems(arr, start, end);
            return arr;
        }
        int endOfFirstArray = start + subArrayLength / 2;
        mergeSortArrayPartition(arr, start, endOfFirstArray);
        int startOfSecondArray = endOfFirstArray + 1;
        mergeSortArrayPartition(arr, startOfSecondArray, end);
        int[] tempArray = new int[subArrayLength];
        int firstCounter = start, secondCounter = startOfSecondArray, tempCounter = 0;
        while(firstCounter <= endOfFirstArray && secondCounter <= end) {
            if(arr[firstCounter] < arr[secondCounter]) {
                tempArray[tempCounter] = arr[firstCounter];
                firstCounter++;
            } else {
                tempArray[tempCounter] = arr[secondCounter];
                secondCounter++;
            }
            tempCounter++;
        }
        while (firstCounter <= endOfFirstArray) {
            tempArray[tempCounter] = arr[firstCounter];
            firstCounter++;
            tempCounter++;
        }

        while (secondCounter <= end) {
            tempArray[tempCounter] = arr[secondCounter];
            secondCounter++;
            tempCounter++;
        }
        for (int i =0; i < tempArray.length; i++) {
            arr[start + i] = tempArray[i];
        }
        return arr;
    }

    private static void swapStartEndItems(int[] arr, int start, int end) {
        int firstItemCopy = arr[start];
        arr[start] = arr[end];
        arr[end] = firstItemCopy;
    }
}
