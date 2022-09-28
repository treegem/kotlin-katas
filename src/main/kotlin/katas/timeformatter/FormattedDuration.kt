package katas.timeformatter

import kotlin.time.DurationUnit.SECONDS
import kotlin.time.toDuration

data class FormattedDuration(
    val years: Int,
    val days: Int,
    val hours: Int,
    val minutes: Int,
    val seconds: Int,
) {
    fun printHumanReadable() =
        listOfNotNull(
            createUnitString(years, "year"),
            createUnitString(days, "day"),
            createUnitString(hours, "hour"),
            createUnitString(minutes, "minute"),
            createUnitString(seconds, "second")
        )
            .joinToString()
            .replaceLast(oldValue = ", ", newValue = " and ")
            .takeIf { it.isNotBlank() } ?: "now"

    private fun createUnitString(amount: Int, unit: String) =
        ("$amount $unit" + printPotentialPlural(amount)).takeIf { amount > 0 }

    private fun printPotentialPlural(amount: Int) = "s".takeIf { amount > 1 } ?: ""

    companion object {
        private const val DAYS_IN_YEAR = 365
        private const val HOURS_IN_DAY = 24
        private const val MINUTES_IN_HOUR = 60
        private const val SECONDS_IN_MINUTE = 60

        fun fromSeconds(seconds: Int): FormattedDuration {
            val duration = seconds.toDuration(SECONDS)

            return FormattedDuration(
                years = duration.inWholeDays.floorDiv(DAYS_IN_YEAR).toInt(),
                days = duration.inWholeDays.toInt() % DAYS_IN_YEAR,
                hours = duration.inWholeHours.toInt() % HOURS_IN_DAY,
                minutes = duration.inWholeMinutes.toInt() % MINUTES_IN_HOUR,
                seconds = duration.inWholeSeconds.toInt() % SECONDS_IN_MINUTE
            )
        }
    }
}

private fun String.replaceLast(oldValue: String, newValue: String) =
    this.reversed().replaceFirst(oldValue = oldValue.reversed(), newValue = newValue.reversed()).reversed()
