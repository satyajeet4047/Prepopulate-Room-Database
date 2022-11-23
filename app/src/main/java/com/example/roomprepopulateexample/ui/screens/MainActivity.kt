package com.example.roomprepopulateexample.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.roomprepopulateexample.ui.theme.RoomPrePopulateExampleTheme
import com.example.roomprepopulateexample.ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomPrePopulateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                        UserList()
                }
            }
        }
    }
}

@Composable
fun UserList(viewModel: MainViewModel = hiltViewModel()) {
    val users by viewModel.userList.collectAsState(initial = emptyList())

    LazyColumn (contentPadding = PaddingValues(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)){
        items(users) { user ->
            UserItem(user.id.toString(), user.name)
        }
    }


}


@Composable
fun UserItem(id : String = "", userName : String = "") {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight().background(Color.LightGray)) {
        Text(modifier = Modifier.padding(8.dp), text = id, style = Typography.body1)
        Text(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),text = userName , style = Typography.body1)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomPrePopulateExampleTheme {
        UserItem("1", "Dummy")
    }
}