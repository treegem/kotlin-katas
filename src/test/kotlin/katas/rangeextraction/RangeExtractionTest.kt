package katas.rangeextraction

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class RangeExtractionTest {

    private val sut = RangeExtraction()

    @Test
    fun createStringRage__singleInt() {
        val result = sut.createStringRange(10, 10)

        result shouldBe "10"
    }

    @Test
    fun createStringRage__twoIntRange() {
        val result = sut.createStringRange(10, 11)

        result shouldBe "10,11"
    }

    @Test
    fun createStringRage__biggerIntRange() {
        val result = sut.createStringRange(10, 15)

        result shouldBe "10-15"
    }

    @ParameterizedTest
    @MethodSource("provideIntArraysAndResults")
    fun rangeExtraction(arr: IntArray, string: String) {
        val result = sut.rangeExtraction(arr)

        result shouldBe string
    }

    private fun provideIntArraysAndResults(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(
                intArrayOf(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20),
                "-6,-3-1,3-5,7-11,14,15,17-20"
            ),
            Arguments.of(
                intArrayOf(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20),
                "-3--1,2,10,15,16,18-20"
            )
        )
    }
}