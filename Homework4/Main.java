package Homework4;

public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 12, 22, 12, 20, 15, 6, 3, 8, 13, 10};
        sortHeap(arr);
        printArray(arr);
    }

    static void buildHeap(int[] arr) {
        int mid = arr.length / 2;
        for (int i = mid; i > 0; i--) {
            heapify(arr, i - 1, arr.length - 1);
        }
    }

    static void heapify(int[] arr, int index, int lengthArray) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int maxElementIndex = index;


        if (rightChild <= lengthArray && arr[rightChild] > arr[maxElementIndex]) {
            maxElementIndex = rightChild;
        }
        if (leftChild <= lengthArray && arr[leftChild] > arr[maxElementIndex]) {
            maxElementIndex = leftChild;
        }

        if (maxElementIndex == index) {
            return;
        } else {
            int temp = arr[maxElementIndex];
            arr[maxElementIndex] = arr[index];
            arr[index] = temp;
            heapify(arr, maxElementIndex, lengthArray - 1);
        }
    }

    static void sortHeap(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, 0, i - 1);
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.printf("%d ", arr[arr.length - 1]);
    }
}
