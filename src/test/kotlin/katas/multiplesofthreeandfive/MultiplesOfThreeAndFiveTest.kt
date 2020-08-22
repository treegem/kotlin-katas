package katas.multiplesofthreeandfive

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class MultiplesOfThreeAndFiveTest {

    @Test
    fun solution__negativeNumber() {
        solution(-1) shouldBe 0
    }

    @Test
    fun solution__zero() {
        solution(0) shouldBe 0
    }

    @Test
    fun solution__one() {
        solution(1) shouldBe 0
    }

    @Test
    fun solution__three() {
        solution(3) shouldBe 0
    }

    @Test
    fun solution__four() {
        solution(4) shouldBe 3
    }

    @Test
    fun solution__five() {
        solution(5) shouldBe 3
    }

    @Test
    fun solution__six() {
        solution(6) shouldBe 8
    }

    @Test
    fun solution__ten() {
        solution(10) shouldBe 23
    }

    @Test
    fun solution__twenty() {
        solution(20) shouldBe 78
    }

}