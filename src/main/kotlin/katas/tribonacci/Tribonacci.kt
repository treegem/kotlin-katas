package katas.tribonacci

fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
    require(n >= 0) { "n must not be negative" }

    val tribonacciSequence = mutableListOf<Double>()
    for (i in 0 until n) tribonacciSequence.add(calcNextTribonacciElement(tribonacciSequence, signature))
    return tribonacciSequence.toDoubleArray()

}

fun calcNextTribonacciElement(existingSequence: List<Double>, signature: DoubleArray): Double {
    val currentSequenceSize = existingSequence.size
    if (currentSequenceSize < 3) return signature[currentSequenceSize]
    return (1..3).fold(0.0) { sum, element -> sum + existingSequence[currentSequenceSize - element] }
}
