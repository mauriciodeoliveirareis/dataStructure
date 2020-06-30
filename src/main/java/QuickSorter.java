public class QuickSorter {

    public static int[] sort(int[] arr) {
        if(arr == null) return null;

        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int lastPivotPosition = placeLastElementInMiddleOfValues(arr, low, high);
            quickSort(arr, low, lastPivotPosition -1);
            quickSort(arr, lastPivotPosition + 1, high);
        }
    }

    //partition
    public static Integer placeLastElementInMiddleOfValues(int[] arr, int low, int high) {
        if(arr == null || arr.length == 0) return null;
        int pivot = arr[high];
        int indexOfSmallerElement = -1;
        for(int i = low; i <= high -1; i++) {
            if(arr[i] < pivot) {
                indexOfSmallerElement++;
                swap(arr, indexOfSmallerElement, i);
            }

        }
        int pivotResultPosition = indexOfSmallerElement + 1;
        swap(arr, pivotResultPosition, high);
        return pivotResultPosition;

    }

    private static void swap(int[] arr, int indexOfSmallerElement, int i) {
        int currentArrValue = arr[i];
        arr[i] = arr[indexOfSmallerElement];
        arr[indexOfSmallerElement] = currentArrValue;
    }

    private static boolean isPivotShouldMove(int arrayCurrentValue, int pivotCurrentPosition, int pivot, int i) {
        return isPivotSmallerAndOnTheRight(arrayCurrentValue, i, pivot, pivotCurrentPosition) || isPivotBiggerAndOnTheLeft(arrayCurrentValue, i, pivot, pivotCurrentPosition);
    }

    private static boolean isPivotSmallerAndOnTheRight(int arrayCurrentValue, int arrayCurrentPosition, int pivot, int pivotCurrentPosition) {
        return arrayCurrentValue > pivot && arrayCurrentPosition < pivotCurrentPosition;
    }
    private static boolean isPivotBiggerAndOnTheLeft(int arrayCurrentValue, int arrayCurrentPosition, int pivot, int pivotCurrentPosition) {
        return arrayCurrentValue < pivot && arrayCurrentPosition > pivotCurrentPosition;
    }
}
