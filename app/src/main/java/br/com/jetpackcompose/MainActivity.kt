package br.com.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Preview
    @Composable
    private fun MainScreen() {
        Scaffold(
            topBar = {
                TopBar()
            },
            content = {
                Content()
            }
        )
    }

    @Composable
    private fun TopBar() {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            backgroundColor = colorResource(id = R.color.purple_500),
            contentColor = Color.White
        )
    }

    @Composable
    private fun Content() {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            items(25) { item ->
                ContactItem(item)
            }
        }
    }

    @Composable
    private fun ContactItem(item: Int) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        Toast
                            .makeText(applicationContext, "Toast item $item", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
                .background(Color.LightGray)
                .padding(16.dp),
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Rounded.Person, contentDescription = "Contact image")
                    Text(
                        text = "Usuário $item",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        )
    }

}