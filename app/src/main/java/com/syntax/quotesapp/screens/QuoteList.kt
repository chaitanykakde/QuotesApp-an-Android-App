package com.syntax.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.syntax.quotesapp.models.Quote

@Composable
fun QuoteList(data:Array<Quote>,onClick:(quote:Quote)->Unit){
    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(bottom = 20.dp),
        content = {
        items(data){
            QuoteListItem(quote = it,onClick)
        }
    })
}
