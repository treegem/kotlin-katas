package katas.rangeextraction

class RangeExtraction {
    fun rangeExtraction(arr: IntArray): String {
        val rangeStrings = mutableListOf<String>()
        var lastNumber = arr.first()
        var rangeStart: Int = arr.first()
        var rangeEnd: Int = arr.first()

        arr.forEach { currentNumber ->
            if (currentNumber > lastNumber + 1) {
                rangeStrings.add(createStringRange(rangeStart, rangeEnd))
                rangeStart = currentNumber
            }
            rangeEnd = currentNumber
            lastNumber = currentNumber
        }
        rangeStrings.add(createStringRange(rangeStart, rangeEnd))
        return rangeStrings.joinToString(",")
    }

    fun createStringRange(rangeStart: Int, rangeEnd: Int): String {
        return when {
            rangeStart == rangeEnd -> "$rangeStart"
            rangeStart + 1 == rangeEnd -> "$rangeStart,$rangeEnd"
            else -> "$rangeStart-$rangeEnd"
        }
    }
}