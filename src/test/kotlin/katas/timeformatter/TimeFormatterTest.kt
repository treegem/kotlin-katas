package katas.timeformatter

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class TimeFormatterTest {

    @Test
    fun `format to 'now' for zero seconds`() {
        TimeFormatter.formatDuration(0) shouldBe "now"
    }

    @Test
    fun `format 1 second correctly`() {
        TimeFormatter.formatDuration(1) shouldBe "1 second"
    }

    @Test
    fun `format multiple seconds below one minute correctly`() {
        TimeFormatter.formatDuration(59) shouldBe "59 seconds"
    }

    @Test
    fun `format exactly one minute correctly`() {
        TimeFormatter.formatDuration(60) shouldBe "1 minute"
    }

    @Test
    fun `format one minute and one second correctly`() {
        TimeFormatter.formatDuration(61) shouldBe "1 minute and 1 second"
    }

    @Test
    fun `format one hour one minute and two seconds correctly`() {
        TimeFormatter.formatDuration(3662) shouldBe "1 hour, 1 minute and 2 seconds"
    }
}
