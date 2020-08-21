package katas.fixstringcase

object FixStringCase {

    fun solve(inputString: String) = when {
        hasMoreUppercaseThanLowercase(inputString) -> inputString.toUpperCase()
        else -> inputString.toLowerCase()
    }

    private fun hasMoreUppercaseThanLowercase(inputString: String): Boolean {
        val (upperCases, lowerCases) = inputString.toCharArray().partition { char -> char.isUpperCase() }
        return upperCases.size > lowerCases.size
    }

}