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

        result.nextNode shouldBe null
    }

    @Test
    fun createChain__onlyTwoTailNodes() {
        val result = Node.createChain(2, 0)

        val secondNode = result.nextNode
        secondNode shouldNotBe null
        secondNode!!.nextNode shouldBe null
    }

    @Test
    fun createChain__fail__onlyOneLoopNode() {
        shouldThrow<IllegalArgumentException> { Node.createChain(0, 1) }
    }

    @Test
    fun createChain__onlyTwoLoopNodes() {
        val result = Node.createChain(0, 2)

        val secondNode = result.nextNode!!
        secondNode.nextNode shouldBe result
    }

    @Test
    fun createChain__onlyThreeLoopNodes() {
        val result = Node.createChain(0, 3)

        val secondNode = result.nextNode!!
        val thirdNode = secondNode.nextNode
        secondNode.nextNode shouldNotBe result
        thirdNode shouldBe result
    }

    @Test
    fun createChain__twoTailNodesAndTwoLoopNodes() {
        val result = Node.createChain(2, 2)

        val secondTailNode = result.nextNode!!
        val firstLoopNode = secondTailNode.nextNode!!
        val secondLoopNode = firstLoopNode.nextNode!!
        result.nextNode shouldNotBeIn listOf(firstLoopNode, secondLoopNode, result)
        secondTailNode.nextNode shouldNotBeIn listOf(secondTailNode, secondLoopNode, result)
        firstLoopNode.nextNode shouldNotBeIn listOf(result, secondTailNode, firstLoopNode)
        secondLoopNode.nextNode shouldBe firstLoopNode
    }
}