package katas.primesinnumbers

object PrimeDecomp {

    fun factors(l: Int): String {
        val factorizationMap = factorize(l)
        return mapToString(factorizationMap)
    }

    fun mapToString(factorizationMap: Map<Int, Int>): String {

        return factorizationMap.entries.fold("") { resultString, entry ->
            val exponent = "**${entry.value}".takeIf { entry.value > 1 } ?: ""
            resultString + "(${entry.key}$exponent)"
        }
    }

    fun factorize(number: Int): Map<Int, Int> {
        val primeNumbers = primeNumbersLessOrEqualThan(number)
        val factorizationMap = mutableMapOf<Int, Int>()
        var remainder = number

        primeNumbers.forEach { primeNumber ->
            var exponent = 0
            while (remainder % primeNumber == 0) {
                exponent += 1
                remainder /= primeNumber
            }
            factorizationMap[primeNumber] = exponent
            if (remainder == 0) return@forEach
        }

        return factorizationMap.filter { it.value != 0 }.toMap()
    }

    private fun primeNumbersLessOrEqualThan(number: Int): List<Int> {
        val potentialPrimeNumbers = (2..number)
        val nonPrimeNumbers = mutableSetOf<Int>()
        potentialPrimeNumbers.forEach { n ->
            if (!nonPrimeNumbers.contains(n)) {
                nonPrimeNumbers.addAll(createMultiples(n, number))
            }

        }
        return potentialPrimeNumbers - nonPrimeNumbers
    }

    private fun createMultiples(baseNumber: Int, maximum: Int): List<Int> {
        val maxTimes = maximum / baseNumber
        return (2 * baseNumber..maxTimes).map { it * baseNumber }
    }
}