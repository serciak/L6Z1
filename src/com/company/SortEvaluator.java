package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class SortEvaluator {

    private int size;
    private MergeSort ms;
    private QuickSort qs;
    private HeapSort hs;

    public SortEvaluator(int size) {
        this.size = size;
    }

    private ArrayList<Integer> randomArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i<size; i++) {
            arrayList.add(random.nextInt(1,1000));
        }
        return arrayList;
    }

    private ArrayList<Integer> invertedSortedArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i<size; i++) {
            arrayList.add(0, i);
        }

        return arrayList;
    }

    private ArrayList<Integer> sortedArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i<size; i++) {
            arrayList.add(i);
        }

        return arrayList;
    }



    private void randomOrder() {
        ArrayList<Integer> list = randomArray();

        qs.sort((ArrayList<Integer>) list.clone());
        ms.sort((ArrayList<Integer>) list.clone());
        hs.sort((ArrayList<Integer>) list.clone());

        System.out.println("Lista losowej kolejnosci:");
    }

    private void sortedOrder() {
        ArrayList<Integer> list = sortedArray();

        qs.sort((ArrayList<Integer>) list.clone());
        ms.sort((ArrayList<Integer>) list.clone());
        hs.sort((ArrayList<Integer>) list.clone());

        System.out.println("Lista posortowana:");
    }

    private void invertedSortedOrder() {
        ArrayList<Integer> list = invertedSortedArray();

        qs.sort((ArrayList<Integer>) list.clone());
        ms.sort((ArrayList<Integer>) list.clone());
        hs.sort((ArrayList<Integer>) list.clone());

        System.out.println("Lista odwrotnie posortowana:");
    }

    public void evaluate(Comparator<Integer> comparator) {

        qs = new QuickSort(comparator);
        ms = new MergeSort(comparator);
        hs = new HeapSort(comparator);

        randomOrder();
        printStats();
        sortedOrder();
        printStats();
        invertedSortedOrder();
        printStats();
    }

    private void printStats() {
        System.out.println("[MergeSort] " + "Porownania: " + ms.getComparisons() + "\tZamiany: " + ms.getSwaps());
        System.out.println("[QuickSort] " + "Porownania: " + qs.getComparisons() + "\tZamiany: " + qs.getSwaps());
        System.out.println("[HeapSort] " + "Porownania: " + hs.getComparisons() + "\tZamiany: " + hs.getSwaps());
        System.out.println("\n");
    }
}
