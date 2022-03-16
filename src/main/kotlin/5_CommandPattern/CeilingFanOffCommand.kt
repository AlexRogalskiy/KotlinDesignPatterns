package `5_CommandPattern`

import kotlin.properties.Delegates

class CeilingFanOffCommand(fan: CeilingFan): Command {
    private val currentFan: CeilingFan = fan

    // TODO: discuss it
    var speed by Delegates.notNull<Int>()

    var prevSpeed by Delegates.notNull<Int>()

    override fun execute() {
        // to come back to this speed in undo
        speed = currentFan.giveSpeed()
        currentFan.off()
    }

    override fun undo() {
        when (prevSpeed) {
            CeilingFan.highRegime() -> {
                currentFan.high()
            }
            CeilingFan.mediumRegime() -> {
                currentFan.medium()
            }
            CeilingFan.lowRegime() -> {
                currentFan.low()
            }
            CeilingFan.offRegime() -> {
                currentFan.off()
            }
        }
    }
}