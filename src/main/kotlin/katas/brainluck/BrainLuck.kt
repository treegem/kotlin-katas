package katas.brainluck

class BrainLuck(private val code: String) {

    private var commandIndex = 0
    private var inputIndex = 0
    private var cellIndex = 0
    private val cells = (1..5000).map { 0 }.toMutableList()
    private var result = ""

    fun process(input: String): String {
        while (commandIndex <= code.lastIndex) {
            processCurrentCommand(input)
            commandIndex += 1
        }
        return result
    }

    private fun processCurrentCommand(input: String) {
        when (code[commandIndex]) {
            '>' -> cellIndex++
            '<' -> cellIndex--
            '+' -> cells[cellIndex] = getIncreasedOrTruncatedCellValue()
            '-' -> cells[cellIndex] = getDecreasedOrTruncatedCellValue()
            '.' -> result += cells[cellIndex].toChar()
            ',' -> copyInputCharToCell(input)
            '[' -> processOpenBracket()
            ']' -> processClosingBracket()
        }
    }

    private fun copyInputCharToCell(input: String) {
        cells[cellIndex] = input[inputIndex].code
        inputIndex++
    }

    private fun getIncreasedOrTruncatedCellValue() =
        when (val cellValue = cells[cellIndex]) {
            255 -> 0
            else -> cellValue + 1
        }

    private fun getDecreasedOrTruncatedCellValue() =
        when (val cellValue = cells[cellIndex]) {
            0 -> 255
            else -> cellValue - 1
        }

    private fun processOpenBracket() {
        if (cells[cellIndex] == 0) {
            goToMatchingClosingBracket()
        }
    }

    private fun goToMatchingClosingBracket() {
        var bracketHierarchy = 0
        while (!isClosingBracketReached(bracketHierarchy)) {
            commandIndex++
            when {
                code[commandIndex] == '[' -> bracketHierarchy++
                code[commandIndex] == ']' -> bracketHierarchy--
            }
        }
    }

    private fun isClosingBracketReached(bracketHierarchy: Int) =
        bracketHierarchy == -1 && code[commandIndex] == ']'

    private fun processClosingBracket() {
        if (cells[cellIndex] != 0) {
            returnToMatchingOpeningBracket()
        }
    }

    private fun returnToMatchingOpeningBracket() {
        var bracketHierarchy = 0
        while (!isOpeningBracketReached(bracketHierarchy)) {
            commandIndex--
            when {
                code[commandIndex] == ']' -> bracketHierarchy++
                code[commandIndex] == '[' -> bracketHierarchy--
            }
        }
    }

    private fun isOpeningBracketReached(bracketHierarchy: Int) =
        bracketHierarchy == -1 && code[commandIndex] == '['

}
