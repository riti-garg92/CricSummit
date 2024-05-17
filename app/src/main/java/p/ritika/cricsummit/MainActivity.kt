package p.ritika.cricsummit
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import p.ritika.cricsummit.ui.theme.CricSummitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CricSummitTheme {
                MainScreen(
                    onChallenge12Click = {
                        startActivity(Intent(this, Challenge1Activity::class.java))
                    },
                    onChallenge3Click = {
                        startActivity(Intent(this, Challenge3Activity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun MainScreen(onChallenge12Click: () -> Unit, onChallenge3Click: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Button(
            onClick = onChallenge12Click,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(text = "Challenge 1: Predict Outcome & Challenge 2: Commentary", fontSize = 16.sp)
        }
        Button(
            onClick = onChallenge3Click,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(text = "Challenge 3: Super Over", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CricSummitTheme {
        MainScreen(onChallenge12Click = {}, onChallenge3Click = {})
    }
}
