package katas.stringincrementer

fun incrementString(str: String): String {
    val (letters, numbers) = separateStringAndFinalNumbers(str)
    val increasedNumbers = increaseNumbers(numbers)
    return letters + increasedNumbers
}

private fun increaseNumbers(numbers: String): String {
    return when (numbers) {
        "" -> "1"
        else -> (numbers.toInt() + 1).toString().padStart(numbers.length, '0')
    }
}

fun separateStringAndFinalNumbers(str: String): Pair<String, String> {
    val lastNonNumericChar = str.lastOrNull() { it.isLetter() }
    val highestNonNumericIndex = str.indexOfLast { it == lastNonNumericChar }
    val letters = str.slice(0..highestNonNumericIndex)
    val finalNumbers = str.slice(highestNonNumericIndex + 1..str.lastIndex)
    return Pair(
        letters,
        finalNumbers
    )
}