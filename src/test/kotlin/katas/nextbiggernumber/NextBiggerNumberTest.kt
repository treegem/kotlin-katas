package katas.nextbiggernumber

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class NextBiggerNumberTest {

    @Test
    fun nextBiggerNumber__noNextBiggerNumber() {
        nextBiggerNumber(9) shouldBe -1
        nextBiggerNumber(111) shouldBe -1
        nextBiggerNumber(531) shouldBe -1
    }

    @Test
    fun nextBiggerNumber__noNextBiggerNumber_withReallyBigNumber() {
        nextBiggerNumber(1111111111111111111) shouldBe -1
    }

    @Test
    fun nextBiggerNumber__getNextBiggerNumber() {
        nextBiggerNumber(12) shouldBe 21
        nextBiggerNumber(513) shouldBe 531
        nextBiggerNumber(144) shouldBe 414
    }

    @Test
    fun nextBiggerNumber__getNextBiggerNumber_withReallyBigNumber() {
        nextBiggerNumber(989_999_999_999_999_999) shouldBe 998_999_999_999_999_999
        nextBiggerNumber(999_999_999_999_998_999) shouldBe 999_999_999_999_999_899
        nextBiggerNumber(9_223_372_036_854_775_612) shouldBe 9_223_372_036_854_775_621
    }

    @Test
    fun createAndSortAllPossibleNumbers__singleDigit() {
        createAndSortTwoNextBiggerCandidates(2) shouldBe sortedSetOf(2)
        createAndSortTwoNextBiggerCandidates(7) shouldBe sortedSetOf(7)
    }

    @Test
    fun createAndSortAllPossibleNumbers__twoDigits() {
        createAndSortTwoNextBiggerCandidates(21) shouldBe sortedSetOf(21)
        createAndSortTwoNextBiggerCandidates(53) shouldBe sortedSetOf(53)
    }

    @Test
    fun createAndSortAllPossibleNumbers__threeDigits() {
        createAndSortTwoNextBiggerCandidates(753) shouldBe sortedSetOf(753)
    }

    @Test
    fun createAndSortAllPossibleNumbers__fourDigits() {
        createAndSortTwoNextBiggerCandidates(7513) shouldBe sortedSetOf(7513, 7531)
    }
}