package p.ritika.cricsummit

import p.ritika.cricsummit.viewmodel.Challenge1ViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import p.ritika.cricsummit.ui.theme.CricSummitTheme

class Challenge1Activity : ComponentActivity() {
    private val viewModel: Challenge1ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CricSummitTheme {
                Challenge1Screen(viewModel)
            }
        }
    }
}

@Composable
fun Challenge1Screen(viewModel: Challenge1ViewModel) {
    val context = LocalContext.current
    val bowlOptions = context.resources.getStringArray(R.array.bowl_array).toList()
    val shotOptions = context.resources.getStringArray(R.array.shot_array).toList()
    val timingOptions = context.resources.getStringArray(R.array.timing_array).toList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        DropdownMenu("Select Bowl", bowlOptions, viewModel.bowl) { viewModel.bowl = it }
        Spacer(modifier = Modifier.height(7.dp))
        DropdownMenu("Select Shot", shotOptions, viewModel.shot) { viewModel.shot = it }
        Spacer(modifier = Modifier.height(7.dp))
        DropdownMenu("Select Timing", timingOptions, viewModel.timing) { viewModel.timing = it }
        Spacer(modifier = Modifier.height(7.dp))
        Button(
            onClick = {
                viewModel.predictOutcome()
            }
        ) {
            Text("Predict Outcome")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = viewModel.result, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = viewModel.commentary, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun DropdownMenu(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionState by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(vertical = 7.dp)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(4.dp))
                .padding(horizontal = 10.dp, vertical = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = selectedOption.ifEmpty { selectedOptionState }, fontSize = 16.sp)
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOptionState = option
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Challenge1ScreenPreview() {
    val viewModel = Challenge1ViewModel()
    CricSummitTheme {
        Challenge1Screen(viewModel)
    }
}