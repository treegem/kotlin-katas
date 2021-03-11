package katas.loopcounter

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LoopCountFunctionsKtTest{

    @Test
    fun loopSize__onlyLoopNodes() {
        val startingNode = Node.createChain(0, 4)

        val result = loopSize(startingNode)

        result shouldBe 4
    }

    @Test
    fun loopSize__onlyTailNodes() {
        val startingNode = Node.createChain(4, 0)

        val result = loopSize(startingNode)

        result shouldBe 0
    }

    @Test
    fun loopSize__tailNodesAndLoopNodes() {
        val startingNode = Node.createChain(4, 5)

        val result = loopSize(startingNode)

        result shouldBe 5
    }

}