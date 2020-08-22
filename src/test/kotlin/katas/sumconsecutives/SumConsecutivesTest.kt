package katas.sumconsecutives

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class SumConsecutivesTest {

    @Test
    fun sumConsecutives__singleEntry() {
        sumConsecutives(listOf(1)) shouldBe listOf(1)
    }

    @Test
    fun sumConsecutives__singleEntries() {
        sumConsecutives(listOf(1, 2, 3)) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun sumConsecutives__firstEntriesDouble() {
        sumConsecutives(listOf(1, 1, 2, 3)) shouldBe listOf(2, 2, 3)
    }

    @Test
    fun codeWarsTests() {
        sumConsecutives(listOf(1, 4, 4, 4, 0, 4, 3, 3, 1)) shouldBe listOf(1, 12, 0, 4, 6, 1)
        sumConsecutives(listOf(1, 1, 7, 7, 3)) shouldBe listOf(2, 14, 3)
        sumConsecutives(listOf(-5, -5, 7, 7, 12, 0)) shouldBe listOf(-10, 14, 12, 0)
        sumConsecutives(listOf(3, 3, 3, 3, 1)) shouldBe listOf(12, 1)
    }

}