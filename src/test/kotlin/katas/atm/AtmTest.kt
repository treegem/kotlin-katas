package katas.atm

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class AtmTest {

    private val sut = Atm()

    @Test
    fun count__success__impossible() {
        sut.count(1) shouldBe -1
        sut.count(11) shouldBe -1
        sut.count(49) shouldBe -1
    }

    @Test
    fun count__success__0() {
        sut.count(0) shouldBe 0
    }

    @Test
    fun count__success__10() {
        sut.count(10) shouldBe 1
    }

    @Test
    fun count__success__20() {
        sut.count(20) shouldBe 1
    }

    @Test
    fun count__success__30() {
        sut.count(30) shouldBe 2
    }

    @Test
    fun count__success__50() {
        sut.count(50) shouldBe 1
    }

    @Test
    fun count__success__80() {
        sut.count(80) shouldBe 3
    }

    @Test
    fun count__success__1200() {
        sut.count(1200) shouldBe 3
    }
}