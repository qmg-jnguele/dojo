package com.qmetric.dojo;

import java.util.ArrayList;

public class FizzBuzzBob {
    private final int count;
    private ArrayList<String> values;

    public FizzBuzzBob(int count) {
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
        if (isMultipleOfFiveAndSevenAndThree(number))
            appendFizzBuzzBob();
        else if (isMultipleOfFive(number))
            appendFizz();
        else if (isMultipleOfSeven(number))
            appendBuzz();
        else if (isMultipleOfThree(number))
            appendBob();
        else
            appendNumber(number);
    }

    private void appendBob() {
        values.add("bob");
    }

    private boolean isMultipleOfThree(int number) {
        return isMultipleOf(number, 3);
    }

    private static boolean isMultipleOf(int number, int x) {
        return (number % x) == 0;
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

    private void appendFizzBuzzBob() {
        values.add("fizzbuzzbob");
    }

    private void resetValues() {
        values = new ArrayList<>();
    }

    private static boolean isMultipleOfSeven(int number) {
        return isMultipleOf(number, 7);
    }

    private static boolean isMultipleOfFive(int number) {
        return isMultipleOf(number, 5);
    }

    private static boolean isMultipleOfFiveAndSevenAndThree(int i) {
        return isMultipleOfFive(i) && isMultipleOfSeven(i);
    }
}
