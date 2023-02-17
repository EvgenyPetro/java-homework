package Homework3;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 2, 6, 7, 0};

        mergeSort(arr);
        printArr(arr);


    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }

        int left = 0;
        int right = arr.length;
        int mid = (right - left) / 2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[i + mid];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }


    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
