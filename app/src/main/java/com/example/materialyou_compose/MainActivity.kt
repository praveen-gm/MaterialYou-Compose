package com.example.materialyou_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialyou_compose.ui.theme.AppTheme
import com.example.materialyou_compose.ui.theme.AppTypography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SamplePaymentScreen()
                }
            }
        }
    }
}

@Composable
fun SamplePaymentScreen() {
    Scaffold(
        topBar = {
            CustomTopBar()
        }, backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                BalanceInfo()
                Spacer(modifier = Modifier.height(36.dp))
                Text(
                    "Add Money", style = AppTypography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Column {
                    MoneySource("Card")
                    MoneySource("Wallet")
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text("More Options")
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        "Complete Payment",
                        style = AppTypography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimary)
                    )
                }
            }
        }
    }
}

@Composable
fun BalanceInfo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Your Balance",
                style = AppTypography.titleSmall.copy(color = MaterialTheme.colorScheme.onSecondaryContainer)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "₹20.4k",
                style = AppTypography.titleLarge.copy(color = MaterialTheme.colorScheme.onSecondaryContainer)
            )
        }
    }
}

@Composable
fun CustomTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextButton(
            onClick = { /*TODO*/ }
        ) {
            Text(
                "Overview",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                Icons.Default.KeyboardArrowDown,
                "Icon Drop Down",
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                Icons.Default.Info,
                "Icon Drop Down",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun MoneySource(sourceText: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 8.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = false, onClick = { /*TODO*/ },
                colors = RadioButtonDefaults.colors(
                    unselectedColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                sourceText,
                style = AppTypography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        SamplePaymentScreen()
    }
}