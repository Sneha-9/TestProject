package com.sneha.list.array;

public class ArrayUtils {

    public static <T> void printArray(T[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%d, ", ar[i]);
        }
        System.out.println();
    }

}
