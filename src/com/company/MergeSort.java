package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MergeSort {

    private Comparator<Integer> comparator;
    private int swaps;
    private int comparisons;

    public MergeSort(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> list) {
        return mergesort(list, 0, list.size() - 1);
    }

    private ArrayList<Integer> mergesort(ArrayList<Integer> list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(list.get(startIndex));

            return result;
        }

        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex),
                mergesort(list, splitIndex + 1, endIndex));
    }

    private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Integer> l = left.iterator();
        Iterator<Integer> r = right.iterator();
        int elemL = 0;
        int elemR = 0;
        boolean contL = l.hasNext();
        boolean contR = r.hasNext();

        if(contL) elemL=l.next();
        if(contR) elemR=r.next();

        while (contL && contR) {
            comparisons++;
            if (comparator.compare(elemL, elemR) <= 0){
                result.add(elemL);
                contL=l.hasNext();

                if(contL) {
                    elemL = l.next();
                }
                else {
                    swaps++;
                    result.add(elemR);
                }
            }
            else {
                result.add(elemR);
                contR=r.hasNext();

                if(contR) {
                    elemR = r.next();
                }
                else {
                    swaps++;
                    result.add(elemL);
                }
            }
        }

        while(l.hasNext()) {
            swaps++;
            result.add(l.next());
        }

        while(r.hasNext()) {
            swaps++;
            result.add(r.next());
        }

        return result;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }
}
