package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.MethodName.class)
class ComputationUtilsTest {
    @Test
    void zeroShouldNotChangeZero() {
        Assertions.assertEquals(0, sum(0, 0));
        assertThat(sum(5, 0)).isEqualTo(5);
    }

    @Test
    void zeroShouldNotChangePositive() {
        assertThat(sum(5, 0)).isEqualTo(5);
    }

    @Test
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-5, 0)).isEqualTo(-5);
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5, 5)).isEqualTo(10);
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5, -1)).isEqualTo(-6);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-1, 5)).isEqualTo(4);
    }

    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-5, 1)).isEqualTo(-4);
    }

}
