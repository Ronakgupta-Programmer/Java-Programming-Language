package MultithreadingConcepts;
import java.util.Arrays;

public class Multi_Threaded_Sort {
    private int[] array;

    public Multi_Threaded_Sort(int[] array) {
        this.array = array;
    }

    public void sort() {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            Thread leftSort = new Thread(() -> sort(array, low, pi - 1));
            Thread rightSort = new Thread(() -> sort(array, pi + 1, high));
            leftSort.start();
            rightSort.start();
            try {
                leftSort.join();
                rightSort.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        Multi_Threaded_Sort sorter = new Multi_Threaded_Sort(array);
        sorter.sort();
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
