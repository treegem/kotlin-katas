package katas.deodorantevaporator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class DeodorantEvaporatorTest {

    private val sut = DeodorantEvaporator()

    @Test
    fun evaporate__copiedTestsFromCodeWars() {
        sut.evaporator(10.0, 10.0, 10.0) shouldBe 22
        sut.evaporator(10.0, 10.0, 5.0) shouldBe 29
        sut.evaporator(100.0, 5.0, 5.0) shouldBe 59
    }
}
