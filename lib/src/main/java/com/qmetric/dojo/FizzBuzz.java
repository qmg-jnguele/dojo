package com.qmetric.dojo;

import java.util.ArrayList;

public class FizzBuzz {
    private final int count;
    private ArrayList<String> values;

    public FizzBuzz(int count) {
        this.count = count;
        resetValues();
    }

    public String solve() {
        resetValues();
        processNumbersToCount();
        return makePrettyString();
    }

    private String makePrettyString() {
        return String.join("-", values);
    }

    private void processNumbersToCount() {
        for (int number = 1; number <= count; number++) {
            process(number);
        }
    }

    private void process(int number) {
        if (isMultipleOfFiveAndSeven(number))
            appendFizzBuzz();
        else if (isMultipleOfFive(number))
            appendFizz();
        else if (isMultipleOfSeven(number))
            appendBuzz();
        else
            appendNumber(number);
    }

    private void appendNumber(int i) {
        values.add(i + "");
    }

    private void appendBuzz() {
        values.add("buzz");
    }

    private void appendFizz() {
        values.add("fizz");
    }

    private void appendFizzBuzz() {
        values.add("fizzbuzz");
    }

    private void resetValues() {
        values = new ArrayList<>();
    }

    private static boolean isMultipleOfSeven(int i) {
        return (i % 7) == 0;
    }

    private static boolean isMultipleOfFive(int i) {
        return (i % 5) == 0;
    }

    private static boolean isMultipleOfFiveAndSeven(int i) {
        return isMultipleOfFive(i) && isMultipleOfSeven(i);
    }
}
