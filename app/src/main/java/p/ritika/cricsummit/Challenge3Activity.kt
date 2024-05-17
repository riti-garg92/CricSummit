package p.ritika.cricsummit
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import p.ritika.cricsummit.ui.theme.CricSummitTheme
import p.ritika.cricsummit.viewmodel.Challenge3ViewModel

class Challenge3Activity : ComponentActivity() {
    private val viewModel: Challenge3ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CricSummitTheme {
                Challenge3Screen(viewModel)
            }
        }
    }
}

@Composable
fun Challenge3Screen(viewModel: Challenge3ViewModel) {
    val context = LocalContext.current
    val bowlers = context.resources.getStringArray(R.array.bowl_array)
    val batsmen = context.resources.getStringArray(R.array.shot_array)
    val timings = context.resources.getStringArray(R.array.timing_array)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(onClick = { viewModel.playSuperOver(bowlers, batsmen, timings) }) {
            Text("Play Super Over")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = viewModel.result,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Challenge3ScreenPreview() {
    val viewModel = Challenge3ViewModel()
    CricSummitTheme {
        Challenge3Screen(viewModel)
    }
}
