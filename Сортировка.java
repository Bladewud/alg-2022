import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static final int ARRAY_SIZE = 50000;

    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[ARRAY_SIZE];
        int[] checkArray = new int[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        System.arraycopy(array, 0, checkArray, 0, ARRAY_SIZE);
        System.out.println("Start user sort");
        long time = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        System.out.format("sorted: %.3f seconds\r\n", (System.currentTimeMillis() - time) / 1000d);
        System.out.println("Start java lib sort");
        time = System.currentTimeMillis();
        Arrays.sort(checkArray);
        System.out.format("sorted: %.3f seconds\r\n", (System.currentTimeMillis() - time) / 1000d);
        System.out.println("Check result");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != checkArray[i]) {
                throw new RuntimeException("Error in index: " + i);
            }
        }
        System.out.println("OK");
    }

    public static void quickSort(int[] arr, int begin, int end) {

        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {

        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }

}