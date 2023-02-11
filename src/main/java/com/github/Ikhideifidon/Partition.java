package com.github.Ikhideifidon;

import java.util.Random;

/**
 * A class that implements various partitioning schemes.
 */
public class Partition {
    private static final Random random = new Random(0);

    public static int lomutoPartition(int[] A, int left, int right) {
        if (A == null) return -1;                       // Since -1 cannot be an index
        int n = A.length;
        if (n <= 1)                                     // Is "A" an empty array or just s single element array?
            return n == 0 ? -1 : 0;

        int j = left - 1;
        int pivot = A[right];

        for (int i = left; i < right; i++) {
            if (A[i] <= pivot)                          // For a monotonically decreasing order, replace "A[i] <= pivot" with "A[i] >= pivot"
                swap(A, ++j, i);
        }
        swap(A, ++j, right);
        return j;                                       // Index of the pivot element.
    }

    public static void quickSortLomuto(int[] A) {
        quickSortLomutoHelper(A, 0, A.length - 1);
    }

    private static void quickSortLomutoHelper(int[] A, int left, int right) {
        if (left < right) {
            int pivotIndex = lomutoPartition(A, left, right);
            quickSortLomutoHelper(A, left, pivotIndex - 1);
            quickSortLomutoHelper(A, pivotIndex + 1, right);
        }
    }

    public static int randomizedLomutoPartition(int[] A, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(A, i, right);
        return lomutoPartition(A, left, right);
    }

    public static void randomizedQuickSortLomuto(int[] A) {
        randomizedQuickSortLomutoHelper(A, 0, A.length - 1);
    }

    private static void randomizedQuickSortLomutoHelper(int[] A, int left, int right) {
        if (left < right) {
            int pivotIndex = randomizedLomutoPartition(A, left, right);
            randomizedQuickSortLomutoHelper(A, left, pivotIndex - 1);
            randomizedQuickSortLomutoHelper(A, pivotIndex + 1, right);
        }
    }

    // Original Hoare's Partition Scheme
    // Using left element as the pivot
    public static int hoarePartition(int[] A, int left, int right) {
        if (A == null)  return  -1;                                     // -1 is not a valid index.
        if (left > right) return -1;                                    // Empty array.
        else if (left == right) return left;                            // A single-element array.
        int pivot = A[left];
        int i = left - 1;
        int j = right + 1;

        while (true) {
            do
                i++;
            while (A[i] < pivot);

            do
                j--;
            while (A[j] > pivot);

            if (i < j)
                swap(A, i, j);
            else
                return j;
        }
    }

    // Hoare's Partition Scheme
    // Using middle element as the pivot
    public static int middleHoarePartition(int[] A, int left, int right) {
        int middle = left + (right - left) >> 1;
        // swap A[middle] with A[left]
        swap(A, middle, left);
        return hoarePartition(A, left, right);
    }

    // Hoare's Partition Scheme
    // Using random element as the pivot.
    public static int randomizedHoarePartition(int[] A, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(A, i, left);
        return hoarePartition(A, left, right);
    }

    // Hoare's Partition Scheme
    // Using median element as the pivot.
    public static int medianHoarePartition(int[] A, int left, int right) {
        int middle = left + (right - left) >> 1;
        int median = (left + middle + right) / 3;
        swap(A, median, left);
        return hoarePartition(A, left, right);
    }

    public static void hoareQuickSort(int[] A) {
        hoareQuickSortHelper(A, 0, A.length - 1);
    }

    public static void randomizedHoareQuickSort(int[] A) {
        randomizedHoareQuickSortHelper(A, 0, A.length - 1);
    }

    private static void randomizedHoareQuickSortHelper(int[] A, int left, int right) {
        if (left < right) {
            int pivotIndex = randomizedHoarePartition(A, left, right);
            randomizedHoareQuickSortHelper(A, left, pivotIndex);
            randomizedHoareQuickSortHelper(A, pivotIndex + 1, right);
        }
    }

    private static void hoareQuickSortHelper(int[] A, int left, int right) {
        if (left < right) {
            int pivotIndex = hoarePartition(A, left, right);
            hoareQuickSortHelper(A, left, pivotIndex);
            hoareQuickSortHelper(A, pivotIndex + 1, right);
        }
    }

    private static void swap(int[] A, int from, int to) {
        int temp = A[from];
        A[from] = A[to];
        A[to] = temp;
    }


}
