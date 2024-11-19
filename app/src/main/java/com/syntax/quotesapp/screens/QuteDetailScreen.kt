package com.syntax.quotesapp.screens

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.syntax.quotesapp.MainActivity
import com.syntax.quotesapp.models.Quote

import com.syntax.quotesapp.ui.theme.DataManager

@Preview
@Composable
fun preview(){
    QuoteDetail(Quote(text="A human never knows the animals emotions", author = "Chaitany kakde"))
}
@Composable
fun QuoteDetail(quote: Quote){
    BackHandler (){
        DataManager.switchPages(null)
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                colors = listOf(
                    Color(0xFFFFFFFF),
                    Color(0xFF535353)
                )
            )))

    {
        Card(elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)

            ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
                    .align(alignment = Alignment.Start)

            ){
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)

                )
                Text(text=quote.text,
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(Modifier.height(16.dp))
                Text(text=quote.author,
                    fontFamily = FontFamily.SansSerif,
                    style = MaterialTheme.typography.titleLarge
                )





            }

        }

    }


}



