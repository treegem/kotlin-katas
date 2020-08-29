package katas.nextbiggernumber

fun nextBiggerNumber(currentNumber: Long): Long {
    val twoNextBiggerCandidates = createAndSortTwoNextBiggerCandidates(currentNumber)
    if (twoNextBiggerCandidates.last() == currentNumber) return -1
    return twoNextBiggerCandidates.last()
}

fun createAndSortTwoNextBiggerCandidates(n: Long): List<Long> {
    val candidates = mutableSetOf<String>()
    val originalDigits = n.toString().toCharArray().toMutableList()

    if (originalDigits.toSet().size == 1) return listOf(n)

    var stringLength = 0
    while (stringLength < originalDigits.size) {
        val nextDigitStrings = createCandidatesWithOneMoreDigit(candidates, originalDigits)
        candidates.clear()
        candidates.addAll(getUpdatedCandidates(nextDigitStrings, n))
        stringLength++
    }

    return candidates.map { it.toLong() }.sorted()
}

private fun createCandidatesWithOneMoreDigit(candidates: MutableSet<String>, originalDigits: MutableList<Char>) =
    mutableSetOf<String>().apply {
        when {
            candidates.isEmpty() -> addAll(originalDigits.map { it.toString() })
            else -> candidates.forEach { addAll(getNewDigitStrings(originalDigits, it)) }
        }
    }

private fun getUpdatedCandidates(nextDigitStrings: MutableSet<String>, n: Long): List<String> {
    val digitStringsLargerThanOriginal = getAllPossiblyLargerNumbers(nextDigitStrings, n)
    return getListWithMaximumOfFirstTwoElements(digitStringsLargerThanOriginal)
}

private fun getNewDigitStrings(originalDigits: MutableList<Char>, digitString: String) =
    mutableSetOf<String>().apply {
        getRemainingAvailableDigits(originalDigits, digitString).forEach { add(digitString + it) }
    }

private fun getListWithMaximumOfFirstTwoElements(digitStringsLargerThanOriginal: List<String>) =
    digitStringsLargerThanOriginal.sortedBy { it.toLong() }
        .slice(0..minOf(digitStringsLargerThanOriginal.lastIndex, 1))

private fun getAllPossiblyLargerNumbers(nextDigitStrings: MutableSet<String>, n: Long) =
    nextDigitStrings.filter { it.toLong() >= n.toString().slice(it.indices).toLong() }

private fun getRemainingAvailableDigits(originalDigits: List<Char>, digitString: String) =
    originalDigits.toMutableList().apply { digitString.toCharArray().forEach { char -> remove(char) } }.toSet()