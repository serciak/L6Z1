package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Comparator<Integer> comparator = Integer::compareTo;

        list.add(10);
        list.add(1);
        list.add(12);
        list.add(34);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(99);
        list.add(0);

        QuickSort mergeSort = new QuickSort(comparator);

        System.out.println(mergeSort.sort(list));
    }
}
