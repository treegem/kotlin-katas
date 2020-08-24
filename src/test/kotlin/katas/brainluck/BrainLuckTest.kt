package katas.brainluck

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BrainLuckTest {

    @Test
    fun testEchoUntilByte255Encountered() {
        BrainLuck(",+[-.,+]").process("Codewars" + 255.toChar()) shouldBe "Codewars"
    }

    @Test
    fun testEchoUntilByte0Encountered() {
        BrainLuck(",[.[-],]").process("Codewars" + 0.toChar()) shouldBe "Codewars"
    }

    @Test
    fun testTwoNumbersMultiplier() {
        val input = charArrayOf(8.toChar(), 9.toChar())
        BrainLuck(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.")
            .process(input[0].toString() + input[1].toString()) shouldBe
                (input[0].toInt() * input[1].toInt()).toChar().toString()
    }
}