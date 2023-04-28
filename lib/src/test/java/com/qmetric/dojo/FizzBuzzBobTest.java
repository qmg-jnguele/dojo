package com.qmetric.dojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FizzBuzzBobTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1-2",
            "3, 1-2-bob",
            "4, 1-2-bob-4",
            "5, 1-2-bob-4-fizz",
            "6, 1-2-bob-4-fizz-bob",
            "7, 1-2-bob-4-fizz-bob-buzz",
            "8, 1-2-bob-4-fizz-bob-buzz-8",
            "9, 1-2-bob-4-fizz-bob-buzz-8-bob",
            "10, 1-2-bob-4-fizz-bob-buzz-8-bob-fizz",
            "11, 1-2-bob-4-fizz-bob-buzz-8-bob-fizz-11",
            "12, 1-2-bob-4-fizz-bob-buzz-8-bob-fizz-11-bob",
            "13, 1-2-bob-4-fizz-bob-buzz-8-bob-fizz-11-bob-13",
            "14, 1-2-bob-4-fizz-bob-buzz-8-bob-fizz-11-bob-13-buzz",
            "15, 1-2-bob-4-fizz-bob-buzz-8-bob-fizz-11-bob-13-buzz-fizz",
    })
    void solveFor(int number, String expectedResult) {
        assertThat(new FizzBuzzBob(number).solve()).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "106, 104-fizzbuzzbob-106",
            "211, 209-fizzbuzzbob-211",
            "316, 314-fizzbuzzbob-316",
    })
    void solveShowsFizzBuzzBobInRightPlaces(int upperBoundForMatch, String expectedMatch) {
        assertThat(new FizzBuzzBob(upperBoundForMatch).solve()).contains(expectedMatch);
    }
}
