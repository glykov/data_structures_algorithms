import java.util.Random;
import java.util.Arrays;

public class Homework02 {
    // создаем массив на 100 000 элементов
    // т.к. окончания сортировки массива из 1 000 000 элементов слишком долго ждать
    // :)
    private static int[] arr = new int[100_000];

    // заполняем массив случайными числами
    private static void fillArray() {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100000);
        }
    }

    // вспомогательный метод для обмена
    private static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // пузырькова сортировка
    public static void bubbleSort() {
        for (int i = arr.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    // сортировка выбором
    public static void selectionSort() {
        int i, j, min;
        int maxIndex = arr.length - 1;

        for (i = 0; i < maxIndex - 1; i++) {
            min = i;
            for (j = i; j < maxIndex; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            swap(min, i);
        }
    }

    // сортирвка вставками
    public static void insertionSort() {
        int i, j, temp;
        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        long start, duration;

        fillArray();
        start = System.currentTimeMillis();
        bubbleSort();
        duration = System.currentTimeMillis() - start;
        System.out.println("Time spent for bubble sort is " + duration / 1000 + " seconds"); // 20 sec

        fillArray();
        start = System.currentTimeMillis();
        selectionSort();
        duration = System.currentTimeMillis() - start;
        System.out.println("Time spent for selection sort is " + duration / 1000 + " seconds"); // 6 sec

        fillArray();
        start = System.currentTimeMillis();
        insertionSort();
        duration = System.currentTimeMillis() - start;
        System.out.println("Time spent for insertion sort is " + duration / 1000 + " seconds"); // 1 sec

    }
}