package com.endava.tmd.soj.junit5.p04;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        Assertions.assertEquals(0, sum(0, 0));
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

    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(Integer.MAX_VALUE, -5)).isEqualTo(2147483642);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(0, Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(Integer.MIN_VALUE, 5)).isEqualTo(-2147483643);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MIN_VALUE, Integer.MAX_VALUE)).isEqualTo(-1);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE, 1)).isEqualTo(2147483648L);
    }

}
