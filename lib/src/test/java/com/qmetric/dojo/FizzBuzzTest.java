package com.qmetric.dojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FizzBuzzTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1-2",
            "3, 1-2-3",
            "4, 1-2-3-4",
            "5, 1-2-3-4-fizz",
            "6, 1-2-3-4-fizz-6",
            "7, 1-2-3-4-fizz-6-buzz",
            "8, 1-2-3-4-fizz-6-buzz-8",
            "9, 1-2-3-4-fizz-6-buzz-8-9",
            "10, 1-2-3-4-fizz-6-buzz-8-9-fizz",
            "11, 1-2-3-4-fizz-6-buzz-8-9-fizz-11",
            "12, 1-2-3-4-fizz-6-buzz-8-9-fizz-11-12",
            "13, 1-2-3-4-fizz-6-buzz-8-9-fizz-11-12-13",
            "14, 1-2-3-4-fizz-6-buzz-8-9-fizz-11-12-13-buzz",
            "15, 1-2-3-4-fizz-6-buzz-8-9-fizz-11-12-13-buzz-fizz",
    })
    void solveFor(int number, String expectedResult) {
        assertThat(new FizzBuzz(number).solve()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "36, 34-fizzbuzz-36",
            "71, 69-fizzbuzz-71",
            "106, 104-fizzbuzz-106",
    })
    void solveShowsFizzBuzzInRightPlaces(int upperBoundForMatch, String expectedMatch) {
        assertThat(new FizzBuzz(upperBoundForMatch).solve()).contains(expectedMatch);
    }
}
