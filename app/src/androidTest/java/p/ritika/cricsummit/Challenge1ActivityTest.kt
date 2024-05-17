package p.ritika.cricsummit

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class Challenge1ActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<Challenge1Activity>()

    @Test
    fun testPredictOutcomeButton() {

        // Click to open the dropdown menu for selecting the bowl
        composeTestRule.onNodeWithText("Select Bowl").performClick()
        // Select "Bouncer" from the dropdown menu
        composeTestRule.onNodeWithText("Bouncer").performClick()

        // Click to open the dropdown menu for selecting the shot
        composeTestRule.onNodeWithText("Select Shot").performClick()
        // Select "SquareCut" from the dropdown menu
        composeTestRule.onNodeWithText("Straight").performClick()

        // Click to open the dropdown menu for selecting the timing
        composeTestRule.onNodeWithText("Select Timing").performClick()
        // Select "Perfect" from the dropdown menu
        composeTestRule.onNodeWithText("Early").performClick()

        // Click the button to predict the outcome
        composeTestRule.onNodeWithText("Predict Outcome").performClick()
    }
}
