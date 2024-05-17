package p.ritika.cricsummit.viewmodel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import androidx.arch.core.executor.testing.InstantTaskExecutorRule

@ExperimentalCoroutinesApi
class Challenge1ViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: Challenge1ViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = Challenge1ViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testPredictOutcomeLateTiming() {
        viewModel.bowl = "Fast"
        viewModel.shot = "Pull"
        viewModel.timing = "Late"
        viewModel.predictOutcome()

        assertEquals("Wicket", viewModel.result)
        assertEquals("It's a Wicket. Excellent line and length.", viewModel.commentary)
    }

    @Test
    fun testPredictOutcome() {
        viewModel.bowl = "Fast"
        viewModel.shot = "Pull"
        viewModel.timing = "Early"
        viewModel.predictOutcome()

        val expectedResults = listOf("1 run", "2 runs", "3 runs", "4 runs", "5 runs", "6 runs", "Wicket")
        assert(expectedResults.contains(viewModel.result))
    }
}
