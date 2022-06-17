package com.endava.tmd.soj.junit5.p03.s2;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
    @Test
    @Order(2)
    void zeroShouldNotChangeZero() {
        Assertions.assertEquals(0, sum(0, 0));
        assertThat(sum(5, 0)).isEqualTo(5);
    }

    @Test
    @Order(3)
    void zeroShouldNotChangePositive() {
        assertThat(sum(5, 0)).isEqualTo(5);
    }

    @Test
    @Order(4)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(-5, 0)).isEqualTo(-5);
    }

    @Test
    @Order(5)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5, 5)).isEqualTo(10);
    }

    @Test
    @Order(6)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5, -1)).isEqualTo(-6);
    }

    @Test
    @Order(7)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-1, 5)).isEqualTo(4);
    }

    @Test
    @Order(1)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-5, 1)).isEqualTo(-4);
    }
}
