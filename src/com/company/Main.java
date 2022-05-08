package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compareTo;
        SortEvaluator sortEvaluator = new SortEvaluator(1000);

        sortEvaluator.evaluate(comparator);
    }
}
