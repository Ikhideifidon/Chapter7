package com.github.Ikhideifidon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {2, 8, 7, 1, 3, 5, 6, 4};
        int[] B = {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println(Partition.randomizedLomutoPartition(A, 0, A.length - 1));
        System.out.println(Arrays.toString(A));
        Partition.quickSortLomuto(B);
        System.out.println(Arrays.toString(B));

    }
}