package com.github.Ikhideifidon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.Random;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PartitionTest {

    Random random = new Random(0);
    int[] testArray;

    @BeforeEach
    void setUp() {
        testArray = new int[1_093];
        Arrays.setAll(testArray, i -> i + 1);
        // Shuffle this array
        shuffle();
    }

    @Test
    void lomutoPartition() {
        int pivotIndex = Partition.lomutoPartition(testArray, 0, testArray.length - 1);
        System.out.println(pivotIndex);
    }

    @Test
    void quickSortLomuto() {

    }

    @Test
    void randomizedLomutoPartition() {
        int pivotIndex = Partition.randomizedLomutoPartition(testArray, 0, testArray.length - 1);
        System.out.println(pivotIndex);
    }

    @Test
    void randomizedQuickSortLomuto() {
    }

    @Test
    void hoarePartition() {
        int pivotIndex = Partition.hoarePartition(testArray, 0, testArray.length - 1);
        System.out.println(pivotIndex);
    }

    @Test
    void randomizedHoarePartition() {
        int pivotIndex = Partition.randomizedHoarePartition(testArray, 0, testArray.length - 1);
        System.out.println(pivotIndex);
    }

    @Test
    void medianHoarePartition() {

    }

    @Test
    void middleHoarePartition() {

    }

    @Test
    void hoareQuickSort() {

    }

    @Test
    void randomizedHoareQuickSort() {

    }

    // Utility Methods
    private void shuffle() {
        for (int i = testArray.length; i >= 1;  i--) {
            int j = random.nextInt(i);
            swap(i - 1, j);
        }
    }

    private void swap(int from, int to) {
        int temp = testArray[from];
        testArray[from] = testArray[to];
        testArray[to] = temp;
    }
}