package katas.multiplesofthreeandfive

fun solution(number: Int): Int {
    val sumOfDividersThree = sumDividables(number, 3)
    val sumOfDividersFive = sumDividables(number, 5)
    val sumOfDividersThreeAndFive = sumDividables(number, 15)

    return sumOfDividersThree + sumOfDividersFive - sumOfDividersThreeAndFive
}

private fun sumDividables(number: Int, divider: Int): Int {
    val numberOfDividables = (number - 1) / divider
    return (1..numberOfDividables).fold(0) { sum, element -> sum + element * divider }
}