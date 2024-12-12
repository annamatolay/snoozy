package dev.anmatolay.snoozy.android.ui

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.anmatolay.snoozy.android.R
import dev.anmatolay.snoozy.android.ui.theme.SnoozyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnoozyTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        floatingActionButton = {
                            LargeFloatingActionButton(
                                //https://developer.android.com/develop/ui/compose/components/time-pickers-dialogs
                                //                            onClick = { TimePicker() },
                                onClick = {  },
                                shape = CircleShape,
                            ) {
                                Icon(Icons.Filled.Add, "Create new alarm")
                            }
                        },
                        floatingActionButtonPosition = FabPosition.Center,
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
                            // Display the image
                            Image(
                                painter = painterResource(id = R.drawable.elephant_dark),
                                contentDescription = "Alarm Image",
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
//                                            TimePickerDialog(
//                                                onCancel = {},
//                                                onConfirm = {},
//                                                content = {}
//                                            ) // FIXME
                        // https://stackoverflow.com/questions/75853449/timepickerdialog-in-jetpack-compose
                        //https://www.google.com/search?q=compose+TimePickerDialog&sca_esv=9ee8fdcc760d43dd&sxsrf=ADLYWIKJZwVdjsLbghYnNXqbi8kh6KO8ag%3A1729713146010&ei=-lMZZ9MgwIGL6A_G1J3ADQ&ved=0ahUKEwjThYbNo6WJAxXAwAIHHUZqB9gQ4dUDCA8&uact=5&oq=compose+TimePickerDialog&gs_lp=Egxnd3Mtd2l6LXNlcnAiGGNvbXBvc2UgVGltZVBpY2tlckRpYWxvZzIFEAAYgAQyBhAAGAUYHjILEAAYgAQYhgMYigUyCxAAGIAEGIYDGIoFMgsQABiABBiGAxiKBTILEAAYgAQYhgMYigUyCBAAGIAEGKIEMggQABiABBiiBDIIEAAYgAQYogQyCBAAGIAEGKIESNMLUOwIWOwIcAJ4AZABAJgBeaABeaoBAzAuMbgBA8gBAPgBAZgCA6ACigHCAgoQABiwAxjWBBhHmAMA4gMFEgExIECIBgGQBgiSBwMyLjGgB_IF&sclient=gws-wiz-serp

                    }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnoozyTheme {
        Greeting("Android")
    }
}
