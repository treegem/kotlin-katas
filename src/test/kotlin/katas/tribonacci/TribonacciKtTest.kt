package katas.tribonacci

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class TribonacciKtTest {

    @Test
    fun tribonacci__fail__nNegative() {
        shouldThrow<IllegalArgumentException> { tribonacci(doubleArrayOf(0.0, 1.0, 2.0), -1) }
    }

    @Test
    fun tribonacci__nZero() {
        tribonacci(doubleArrayOf(0.0, 1.0, 2.0), 0) shouldBe doubleArrayOf()
    }

    @Test
    fun tribonacci__nOne() {
        tribonacci(doubleArrayOf(0.0, 1.0, 2.0), 1) shouldBe doubleArrayOf(0.0)
    }

    @Test
    fun tribonacci__nTwo() {
        tribonacci(doubleArrayOf(0.0, 1.0, 2.0), 2) shouldBe doubleArrayOf(0.0, 1.0)
    }

    @Test
    fun tribonacci__nThree() {
        tribonacci(doubleArrayOf(0.0, 1.0, 2.0), 3) shouldBe doubleArrayOf(0.0, 1.0, 2.0)
    }

    @Test
    fun tribonacci__nFour() {
        tribonacci(doubleArrayOf(0.0, 1.0, 2.0), 4) shouldBe doubleArrayOf(0.0, 1.0, 2.0, 3.0)
    }

    @Test
    fun tribonacci__nFive() {
        tribonacci(doubleArrayOf(0.0, 1.0, 2.0), 5) shouldBe doubleArrayOf(0.0, 1.0, 2.0, 3.0, 6.0)
    }

    @Test
    fun tribonacci__fromWebsite() {
        tribonacci(doubleArrayOf(1.0, 1.0, 1.0), 10) shouldBe
                doubleArrayOf(1.0, 1.0, 1.0, 3.0, 5.0, 9.0, 17.0, 31.0, 57.0, 105.0)
    }
}