package org.makefun.sorting;

import java.util.ArrayList;
import java.util.List;

public final class Sorting {

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] arr = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        int low = 0;
        int high = arr.length - 1;

        sorting.quickSort(arr, low, high);
    }

    public void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy the remaining elements of left[], if there are any */
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        /* Copy the remaining elements of right[], if there are any */
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Same as (l+r)/2, but avoids overflow for large l and h
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return; 

        if (low >= high)
            return; 

        int middle = low + (high - low) / 2;
        int opora = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) { 
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public List<Integer> fib(int n) { // 0 1 1 2 3 5 8 13 21 34 55
        List<Integer> res = new ArrayList<>();
        int acc = 0;
        int prev = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            res.add(acc);
            acc = prev + next;
            prev = next;
            next = acc;
        }
        return res;
    }

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private void print(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}
