package katas.loopcounter

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldNotBeIn
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

internal class NodeTest {

    @Test
    fun createChain__fail__zeroNodes() {
        shouldThrow<IllegalArgumentException> { Node.createChain(0, 0) }
    }

    @Test
    fun createChain__onlyOneTailNode() {
        val result = Node.createChain(1, 0)

        result.next shouldBe null
    }

    @Test
    fun createChain__onlyTwoTailNodes() {
        val result = Node.createChain(2, 0)

        val secondNode = result.next
        secondNode shouldNotBe null
        secondNode!!.next shouldBe null
    }

    @Test
    fun createChain__fail__onlyOneLoopNode() {
        shouldThrow<IllegalArgumentException> { Node.createChain(0, 1) }
    }

    @Test
    fun createChain__onlyTwoLoopNodes() {
        val result = Node.createChain(0, 2)

        val secondNode = result.next!!
        secondNode.next shouldBe result
    }

    @Test
    fun createChain__onlyThreeLoopNodes() {
        val result = Node.createChain(0, 3)

        val secondNode = result.next!!
        val thirdNode = secondNode.next!!
        secondNode.next shouldNotBe result
        thirdNode.next shouldBe result
    }

    @Test
    fun createChain__twoTailNodesAndTwoLoopNodes() {
        val result = Node.createChain(2, 2)

        val secondTailNode = result.next!!
        val firstLoopNode = secondTailNode.next!!
        val secondLoopNode = firstLoopNode.next!!
        result.next shouldNotBeIn listOf(firstLoopNode, secondLoopNode, result)
        secondTailNode.next shouldNotBeIn listOf(secondTailNode, secondLoopNode, result)
        firstLoopNode.next shouldNotBeIn listOf(result, secondTailNode, firstLoopNode)
        secondLoopNode.next shouldBe firstLoopNode
    }
}