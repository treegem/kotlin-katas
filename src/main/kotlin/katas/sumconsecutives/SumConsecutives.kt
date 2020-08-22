package katas.sumconsecutives

fun sumConsecutives(integerList: List<Int>): List<Int> {
    val resultList = mutableListOf<Int>()

    var currentInteger = integerList.first()
    var currentIntegerSum = 0

    integerList.forEach { integer ->
        when (integer) {
            currentInteger -> currentIntegerSum += integer
            else -> {
                resultList.add(currentIntegerSum)
                currentIntegerSum = integer
                currentInteger = integer
            }
        }
    }
    resultList.add(currentIntegerSum)

    return resultList
}