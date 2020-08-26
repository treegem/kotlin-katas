package katas.stringincrementer

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class IncrementStringTest {

    @Test
    fun incrementString__emptyString() {
        incrementString("") shouldBe "1"
    }

    @Test
    fun incrementString__notEndingWithNumber() {
        incrementString("abc") shouldBe "abc1"
    }

    @Test
    fun incrementString__alreadyEndingWithNumber() {
        incrementString("abc1") shouldBe "abc2"
        incrementString("abc55") shouldBe "abc56"
    }

    @Test
    fun incrementString__withNumberWithLeadingZero() {
        incrementString("abc0005") shouldBe "abc0006"
    }

    @Test
    fun separateStringAndFinalNumbers__noNumber() {
        separateStringAndFinalNumbers("abc") shouldBe Pair("abc", "")
    }

    @Test
    fun separateStringAndFinalNumbers__withNumber() {
        separateStringAndFinalNumbers("abc13") shouldBe Pair("abc", "13")
    }

    @Test
    fun separateStringAndFinalNumbers__withLeadingZeros() {
        separateStringAndFinalNumbers("abc0013") shouldBe Pair("abc", "0013")
    }
}