package katas.deodorantevaporator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DeodorantEvaporatorTest {

    private val sut = DeodorantEvaporator()

    @Test
    fun evaporate__copiedTestsFromCodeWars() {
        assertEquals(22, sut.evaporator(10.0, 10.0, 10.0))
        assertEquals(29, sut.evaporator(10.0, 10.0, 5.0))
        assertEquals(59, sut.evaporator(100.0, 5.0, 5.0))
    }
}
