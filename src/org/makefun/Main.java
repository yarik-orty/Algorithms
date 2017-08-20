package org.makefun;

public class Main {

    public static void main(String[] args) {
        Main sorting = new Main();
        int[] arr = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        int left = 0;
        int right = arr.length - 1;

        sorting.print(arr);

        sorting.mergeSort(arr, left, right);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);

            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {

    }

    private void print(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}
