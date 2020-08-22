package katas.deodorantevaporator

class DeodorantEvaporator {
    fun evaporator(@Suppress("UNUSED_PARAMETER") content: Double, evap_per_day: Double, threshold: Double): Int {
        var fillingPercentage = 100.0
        val remainingPercentage = 1 - 0.01 * evap_per_day
        var day = 0

        while (fillingPercentage > threshold) {
            fillingPercentage *= remainingPercentage
            day += 1
        }
        return day
    }
}