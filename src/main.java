// Generate random numbers in an array after having random numbers
// use the bubble sort and insertion sort algo from least to greatest
// then do a linear search of a value in the array
// give output of unsorted array, the sorted array and pairs of array index

import java.util.Random;

public class main {

    void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }
    }

    void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;

            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }


    public static void main(String[] args) {
        // object
        main obj = new main();
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        int n = arr.length;
        printArray(arr);
        obj.bubbleSort(arr,n);
        printArray(arr);
        obj.insertionSort(arr);
        printArray(arr);

        int x = 30;
        int result = obj.binarySearch(arr, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println(
                    "Element is present at index " + result);
    }

}
