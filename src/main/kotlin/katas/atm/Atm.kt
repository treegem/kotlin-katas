package katas.atm

class Atm {
    fun count(number: Int): Int {
        if (isNotPossible(number)) return -1

        var remainingAmount = number
        var noteCount = 0
        val availableNotes = createDescendingListOfAvailableNotes()
        var biggestNote = availableNotes.first()

        while (remainingAmount > 0) {
            if (remainingAmount >= biggestNote) {
                remainingAmount -= biggestNote
                noteCount++
            } else {
                biggestNote = switchToSmallerNote(availableNotes, biggestNote)
            }
        }
        return noteCount
    }

    private fun switchToSmallerNote(availableNotes: MutableList<Int>, biggestNote: Int): Int {
        availableNotes.remove(biggestNote)
        return availableNotes.first()
    }

    private fun createDescendingListOfAvailableNotes() =
        mutableListOf(10, 20, 50, 100, 200, 500).apply { sortByDescending { it } }

    private fun isNotPossible(number: Int) = number % 10 != 0 || number < 0 || number > 1500
}