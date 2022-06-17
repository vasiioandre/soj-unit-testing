package com.endava.tmd.soj.junit5.p05.s2;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta

import com.endava.tmd.soj.junit5.p05.s1.ComputationUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        assertEquals(0, ComputationUtils.sum(0, 0));
        assertThat(ComputationUtils.sum(5, 0)).isEqualTo(5);
    }

    @Test
    @DisplayName("5 + 0 = 5")
    void zeroShouldNotChangePositive() {
        assertThat(ComputationUtils.sum(5, 0)).isEqualTo(5);
    }

    @Test
    @DisplayName("-5 + 0 = -5")
    void zeroShouldNotChangeNegative() {
        assertThat(ComputationUtils.sum(-5, 0)).isEqualTo(-5);
    }

    @Test
    @DisplayName("5 + 5 = 10")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(ComputationUtils.sum(5, 5)).isEqualTo(10);
    }

    @Test
    @DisplayName("-5 + (-1) = -6")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(ComputationUtils.sum(-5, -1)).isEqualTo(-6);
    }

    @Test
    @DisplayName("-1 + 5 = 4")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(ComputationUtils.sum(-1, 5)).isEqualTo(4);
    }

    @Test
    @DisplayName("-5 + 1 = -4")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(ComputationUtils.sum(-5, 1)).isEqualTo(-4);
    }

    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(ComputationUtils.sum(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, -5)).isEqualTo(2147483642);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(ComputationUtils.sum(0, Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, 5)).isEqualTo(-2147483643);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(ComputationUtils.sum(Integer.MIN_VALUE, Integer.MAX_VALUE)).isEqualTo(-1);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(ComputationUtils.sum(Integer.MAX_VALUE, 1)).isEqualTo(2147483648L);
    }


    @Test
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
        // assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
//        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
//        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @Test
    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        assertThatThrownBy(() -> ComputationUtils.sum(-2147483648, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
