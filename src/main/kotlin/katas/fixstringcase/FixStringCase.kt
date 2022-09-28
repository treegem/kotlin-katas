package katas.fixstringcase

object FixStringCase {

    fun solve(inputString: String) = when {
        hasMoreUppercaseThanLowercase(inputString) -> inputString.uppercase()
        else -> inputString.lowercase()
    }

    private fun hasMoreUppercaseThanLowercase(inputString: String): Boolean {
        val (upperCases, lowerCases) = inputString.toCharArray().partition { char -> char.isUpperCase() }
        return upperCases.size > lowerCases.size
    }

}
