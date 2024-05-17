package p.ritika.cricsummit.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.*

class Challenge1ViewModel : ViewModel() {
    var bowl by mutableStateOf("")
    var shot by mutableStateOf("")
    var timing by mutableStateOf("")
    var result by mutableStateOf("")
    var commentary by mutableStateOf("")

    fun predictOutcome() {
        if (timing.equals("Late", ignoreCase = true)) {
            result = "Wicket"
            commentary = generateCommentary("Wicket")
        } else {
            result = predictOutcome(bowl, shot, timing)
            commentary = "${generateCommentary(result)} - $result"
        }
    }

    private fun predictOutcome(bowl: String, shot: String, timing: String): String {
        val random = Random()
        val outcomes = listOf("1 run", "2 runs", "3 runs", "4 runs", "5 runs", "6 runs", "Wicket")
        return outcomes[random.nextInt(outcomes.size)]
    }

    private fun generateCommentary(outcome: String): String {
        return when (outcome) {
            "Wicket" -> "It's a Wicket. Excellent line and length."
            "4 runs", "6 runs" -> "Its huge hit. Just over the fielder."
            "1 run", "2 runs", "3 runs" -> "Edged and Taken. Excellent running between the wickets."
            else -> "That's massive and out of the ground."
        }
    }
}
