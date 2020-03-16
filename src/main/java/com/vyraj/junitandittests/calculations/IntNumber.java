package com.vyraj.junitandittests.calculations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class IntNumber {
    private int first;

    boolean isOdd() {
        return first % 2 != 0;
    }

    void add(final int second) {
        first += second;
    }

    void subtract(final int second) {
        first -= second;
    }

    void multiply(final int second) {
        first *= second;
    }

    void divide(final int second) {
        first /= second;
    }

    void modulo(final int second) {
        first %= second;
    }
}
