package p.ritika.cricsummit.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class Challenge3ViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: Challenge3ViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = Challenge3ViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testPlaySuperOver() {
        val bowlers = arrayOf("Bowler1", "Bowler2", "Bowler3")
        val batsmen = arrayOf("Batsman1", "Batsman2", "Batsman3")
        val timings = arrayOf("Early", "Perfect", "Late")

        viewModel.playSuperOver(bowlers, batsmen, timings)

        assertTrue(viewModel.result.isNotEmpty())
    }
}
