package com.syntax.quotesapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.syntax.quotesapp.models.Quote
import com.syntax.quotesapp.screens.QuoteDetail

import com.syntax.quotesapp.screens.QuoteListScreen
import com.syntax.quotesapp.ui.theme.DataManager
import com.syntax.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {

            App()

        }
    }

}

@Composable
fun App(){
    if(DataManager.isDataLoaded.value){
        if(DataManager.currentPage.value==Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }

        }  else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }else{
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Loading..",
                style = MaterialTheme.typography.labelSmall)
        }
    }
}
enum class Pages{
    LISTING,
    DETAIL
}
