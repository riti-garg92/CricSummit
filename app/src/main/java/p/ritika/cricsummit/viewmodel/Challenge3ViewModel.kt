package p.ritika.cricsummit.viewmodel
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import java.util.*

class Challenge3ViewModel : ViewModel() {
    private val _result = mutableStateOf("")
    val result get() = _result.value

    fun playSuperOver(bowlers: Array<String>, batsmen: Array<String>, timings: Array<String>) {
        val random = Random()
        var totalRuns = 0
        var wickets = 0
        val resultBuilder = StringBuilder("SUPER OVER BEGINS")
        for (i in 0 until 6) {
            val bowler = bowlers[random.nextInt(bowlers.size)]
            val batsman = batsmen[random.nextInt(batsmen.size)]
            val timing = timings[random.nextInt(timings.size)]

            val outcome = predictOutcome(timing)
            val commentary = generateCommentary(bowler, batsman, outcome)

            resultBuilder.append("\nBowler: $bowler, Batsman: $batsman, Timing: $timing")
            resultBuilder.append("\nOutcome: $outcome")
            resultBuilder.append("\nCommentary: $commentary")

            if (outcome == "Wicket") {
                wickets++
            } else {
                totalRuns += outcome.toIntOrNull() ?: 0
            }

            if (wickets == 2) {
                resultBuilder.append("\nMATCH ENDS. AUSTRALIA WON BY $totalRuns RUNS.")
                _result.value = resultBuilder.toString()
                return
            }
        }

        resultBuilder.append("\nMATCH ENDS. AUSTRALIA SCORED: $totalRuns RUNS.")
        _result.value = resultBuilder.toString()
    }

    private fun predictOutcome(timing: String): String {
        return if (timing.equals("Late", ignoreCase = true)) {
            "Wicket"
        } else {
            val random = Random()
            random.nextInt(7).toString() // 0 to 6 runs
        }
    }

    private fun generateCommentary(bowler: String, batsman: String, outcome: String): String {
        val random = Random()
        return when (outcome) {
            "Wicket" -> {
                val wicketCommentary = listOf(
                    "Wicket! $batsman is dismissed by $bowler!",
                    "Caught! $batsman skies it and is caught by the fielder!",
                    "Bowled him! The stumps are shattered by $bowler!",
                    "Stumped! $batsman is stumped by the wicketkeeper!",
                    "Run out! Miscommunication between the batsmen leads to a run out!",
                    "LBW! $batsman is trapped in front of the stumps by $bowler!"
                )
                wicketCommentary[random.nextInt(wicketCommentary.size)]
            }
            "Dot Ball" -> {
                val dotBallCommentary = listOf(
                    "Dot ball! Good bowling by $bowler.",
                    "Well defended by $batsman. No run taken.",
                    "Batsman tries to find the gap, but the fielder cuts it off. No run.",
                    "Pitched up by $bowler. Well blocked by $batsman."
                )
                dotBallCommentary[random.nextInt(dotBallCommentary.size)]
            }
            else -> {
                val runsCommentary = listOf(
                    "Great shot! $batsman scores $outcome runs!",
                    "$batsman guides it to the boundary for $outcome!",
                    "That's well played by $batsman. $outcome runs added to the total!",
                    "Excellent timing by $batsman. $outcome runs earned!",
                    "$batsman picks up $outcome runs with that shot!"
                )
                runsCommentary[random.nextInt(runsCommentary.size)]
            }
        }
    }
}
