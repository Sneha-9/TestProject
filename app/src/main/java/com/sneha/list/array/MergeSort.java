package com.sneha.list.array;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public MergeSort() {

    }

    public void mergeSort(List<Integer> arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        System.out.println(mid + " " + lo + " " + hi + " " + arr.size());
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, hi, mid);
    }

    public void merge(List<Integer> arr, int start, int end, int mid) {
        // System.out.println(l.length+ " " + r.length);
        List<Integer> res = new ArrayList<>();
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr.get(i) > arr.get(j)) {
                res.add(arr.get(j));
                j++;
                k++;
            } else {
                res.add(arr.get(i));
                k++;
                i++;
            }
        }
        while (i <= mid) {
            res.add(arr.get(i));
            i++;

        }
        while (j <= end) {
            res.add(arr.get(j));
            j++;
        }

        for (int l = 0; l < res.size(); l++) {
            arr.set(start, res.get(l));
            start += 1;
        }

    }

}
