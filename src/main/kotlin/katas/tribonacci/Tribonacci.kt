package katas.tribonacci

fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
    require(n >= 0) { "n must not be negative" }

    val tribonacciSequence = mutableListOf<Double>()

    for (i in 0 until n) {
        tribonacciSequence.add(calcTribonacciElement(i, signature))
    }

    return tribonacciSequence.toDoubleArray()

}

fun calcTribonacciElement(i: Int, signature: DoubleArray): Double {
    if (i < 3) return signature[i]
    return (1..3).fold(0.0) { sum, element -> sum + calcTribonacciElement(i - element, signature) }
}
