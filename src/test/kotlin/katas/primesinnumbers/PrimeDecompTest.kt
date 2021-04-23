package katas.primesinnumbers

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PrimeDecompTest {

    @Test
    fun factorize__success__oneFactorLinear() {
        PrimeDecomp.factorize(2) shouldBe mapOf(2 to 1)
    }

    @Test
    fun factorize__success__twoFactorsLinear() {
        PrimeDecomp.factorize(6) shouldBe mapOf(2 to 1, 3 to 1)
    }

    @Test
    fun factorize__success__twoFactorsQuadratic() {
        PrimeDecomp.factorize(36) shouldBe mapOf(2 to 2, 3 to 2)
    }

    @Test
    fun factorize__success__twoBigFactorsQuadratic() {
        PrimeDecomp.factorize(7 * 7 * 11 * 11) shouldBe mapOf(7 to 2, 11 to 2)
    }

    @Test
    fun mapToString__success__oneFactorLinear() {
        PrimeDecomp.mapToString(mapOf(2 to 1)) shouldBe "(2)"
    }

    @Test
    fun mapToString__success__twoFactorsLinear() {
        PrimeDecomp.mapToString(mapOf(2 to 1, 3 to 1)) shouldBe "(2)(3)"
    }

    @Test
    fun mapToString__success__twoFactorsOneLinearOneQuadratic() {
        PrimeDecomp.mapToString(mapOf(2 to 2, 3 to 1)) shouldBe "(2**2)(3)"
    }

    @Test
    fun factors__success() {
        PrimeDecomp.factors(7775460) shouldBe "(2**2)(3**3)(5)(7)(11**2)(17)"
    }

}