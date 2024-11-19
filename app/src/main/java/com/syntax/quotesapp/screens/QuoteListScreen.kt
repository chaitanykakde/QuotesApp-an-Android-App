package com.syntax.quotesapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.syntax.quotesapp.models.Quote

@Composable
fun QuoteListScreen(data :Array<Quote>,onClick:(quote:Quote)->Unit){
    Column( modifier = Modifier
        .fillMaxSize() // Fills the entire screen
        .padding(8.dp),
        verticalArrangement = Arrangement.Center, // Centers content vertically
        horizontalAlignment = Alignment.CenterHorizontally ) {
        Text("Quotes App",
            modifier = Modifier
                .padding(20.dp,24.dp,)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily.Cursive,
            textAlign = TextAlign.Center


        )
        QuoteList(data =data,onClick )
    }
}
