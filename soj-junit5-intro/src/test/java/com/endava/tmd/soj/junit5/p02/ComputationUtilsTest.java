package com.endava.tmd.soj.junit5.p02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"

@DisplayName("Tests for my sum method")
class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        Assertions.assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(5, 0)).isEqualTo(5);
    }

    @Test
    @DisplayName("5 + 0 = 5")
    void zeroShouldNotChangePositive() {
        assertThat(sum(5, 0)).isEqualTo(5);
    }

    @Test
    @DisplayName("-5 + 0 = -5")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-5, 0)).isEqualTo(-5);
    }

    @Test
    @DisplayName("5 + 5 = 10")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5, 5)).isEqualTo(10);
    }

    @Test
    @DisplayName("-5 + (-1) = -6")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5, -1)).isEqualTo(-6);
    }

    @Test
    @DisplayName("-1 + 5 = 4")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-1, 5)).isEqualTo(4);
    }

    @Test
    @DisplayName("-5 + 1 = -4")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-5, 1)).isEqualTo(-4);
    }

}



