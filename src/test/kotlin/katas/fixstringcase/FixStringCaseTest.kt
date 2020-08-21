package katas.fixstringcase

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FixStringCaseTest {

    private val sut = FixStringCase

    @Test
    fun solve__code() {
        val result = sut.solve("code")

        result shouldBe "code"
    }

    @Test
    fun solve__CODE() {
        val result = sut.solve("CODE")

        result shouldBe "CODE"
    }

    @Test
    fun solve__cOde() {
        val result = sut.solve("cOde")

        result shouldBe "code"
    }

    @Test
    fun solve__cODE() {
        val result = sut.solve("cODE")

        result shouldBe "CODE"
    }

    @Test
    fun solve__cOdE() {
        val result = sut.solve("cOdE")

        result shouldBe "code"
    }

}