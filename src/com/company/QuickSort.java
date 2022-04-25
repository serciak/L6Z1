package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class QuickSort {

    private Comparator<Integer> comparator;
    private int swaps;
    private int comparisons;

    public QuickSort(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    private void swap(ArrayList<Integer> list, int left, int right) {
        if (left != right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        quicksort(list, 0, list.size() - 1);
        return list;
    }

    private void quicksort(ArrayList<Integer> list, int startIndex, int endIndex) {
        if (endIndex > startIndex) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(ArrayList<Integer> list, int left, int right) {
        int value = list.get(right);
        int i = left-1;

        while (left <= right){
            if(comparator.compare(list.get(left), value) <= 0)
                swap(list, ++i,left);
            ++left;}
        return i<right ? i :i-1;
    }
}
