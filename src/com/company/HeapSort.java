package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort {

    private Comparator<Integer> comparator;
    private int swaps;
    private int comparisons;

    public HeapSort(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> list){
        swaps = 0;
        comparisons = 0;
        heapsort(list, list.size());
        return list;
    }

    private void heapsort(ArrayList<Integer> heap, int n) {
        heapAdjustment(heap, n);
        for(int i=n-1;i>0;i--){
            swap(heap,i,0);
            sink(heap,0,i);
        }
    }

    private void swap(ArrayList<Integer> list, int left, int right) {
        swaps++;
        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

    public void sink(ArrayList<Integer> heap,int idx, int n) {
        int idxOfBigger=2*idx+1;
        if(idxOfBigger<n){
            comparisons++;
            if(idxOfBigger+1<n && comparator.compare(heap.get(idxOfBigger), heap.get(idxOfBigger+1))<0)
                idxOfBigger++;
            comparisons++;
            if(comparator.compare(heap.get(idx), heap.get(idxOfBigger))<0){
                swap(heap,idx,idxOfBigger);
                sink(heap,idxOfBigger,n);
            }
        }
    }

    private void heapAdjustment(ArrayList<Integer> heap,int n) {
        for(int i=(n-1)/2;i>=0;i--)
            sink(heap, i, n);
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
