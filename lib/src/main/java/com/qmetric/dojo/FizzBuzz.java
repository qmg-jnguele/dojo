package com.qmetric.dojo;

import java.util.ArrayList;

public class FizzBuzz {
    private final int count;

    public FizzBuzz(int count) {
        this.count = count;
    }

    public String solve() {
        var values = new ArrayList<String>();

        for (int i = 1; i <= count; i++) {
            if (((i % 5) == 0) && ((i % 7) == 0)) // Is it a multiple of 5 & 7?
                values.add("fizzbuzz");
            else if ((i % 5) == 0) // Is it a multiple of 5?
                values.add("fizz");
            else if ((i % 7) == 0) // Is it a multiple of 7?
                values.add("buzz");
            else
                values.add(i + ""); // Not a multiple of 5 or 7
        }

        return String.join("-", values);
    }
}
