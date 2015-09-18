package edu.spbu.cs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by artemaliev on 07/09/15.
 */
public class IntSort {
    private static int other(int id) {
        return (id == 0 ? 1 : 0);
    }

    private static boolean inRange(int index, int start, int size, int globalSize) {
        return index < size && start + index < globalSize;
    }

    public static void sort(int[] array) {
        int arr[][] = new int[2][array.length];
        for (int id = 0; id < 2; ++id) {
            arr[id] = array;
        }
        int id = 0;
        for (int size = 1; size < array.length; size *= 2, id = other(id)) {
            for (int first = 0; first < array.length; first += 2 * size) {
                int second = first + size;
                int i = 0, j = 0;
                while (inRange(i, first, size, array.length) && inRange(j, second, size, array.length)) {
                    if (arr[id][i] < arr[id][j]) {
                        arr[other(id)][first + i + j] = arr[id][first + i];
                        ++i;
                    }
                    else {
                        arr[other(id)][first + i + j] = arr[id][second + j];
                        ++j;
                    }
                }
                while (inRange(i, first, size, array.length)) {
                    arr[other(id)][first + i + j] = arr[id][first + i];
                    ++i;
                }
                while (inRange(j, second, size, array.length)) {
                    arr[other(id)][first + i + j] = arr[id][second + j];
                    ++j;
                }
            }
        }
        array = arr[id];
    }


  public static void sort (List<Integer> list) {
    Collections.sort(list);
  }
}
