package p.ritika.cricsummit
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class Challenge3ActivityTest {

    // This rule is used to create a testing environment for Compose UI tests
    @get:Rule
    val composeTestRule = createAndroidComposeRule<Challenge3Activity>()


    // Test the behavior of the "Play Super Over" button
    @Test
    fun testPlaySuperOverButton() {
// Wait for the text "SUPER OVER BEGINS" to appear on the screen
        runBlocking {
            var retries = 10 // Number of retries
            var foundText = false
            while (!foundText && retries > 0) {
                try {
                    composeTestRule.onNodeWithText("SUPER OVER BEGINS", useUnmergedTree = true)
                    foundText = true // Text found, exit loop
                } catch (e: Exception) {
                    delay(100) // Wait for 100 milliseconds before retrying
                    retries--
                }
            }
        }


// Perform actions/assertions after the text appears
        composeTestRule.onNodeWithText("Play Super Over").performClick()
    }
}
