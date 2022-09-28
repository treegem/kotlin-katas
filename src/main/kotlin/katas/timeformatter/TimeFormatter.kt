package katas.timeformatter

object TimeFormatter {

    fun formatDuration(seconds: Int) =
        FormattedDuration
            .fromSeconds(seconds)
            .printHumanReadable()
}
