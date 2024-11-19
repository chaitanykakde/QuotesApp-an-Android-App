package com.syntax.quotesapp.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.syntax.quotesapp.Pages
import com.syntax.quotesapp.models.Quote

@SuppressLint("StaticFieldLeak")
object DataManager {
    var con: Context? =null

    var currentQuote:Quote?=null
    var data= emptyArray<Quote>()

    var currentPage= mutableStateOf(Pages.LISTING)
    var isDataLoaded= mutableStateOf(false)
    fun loadAssetsFromFile(context:Context){
        con= context
        val inputStream=context.assets.open("quotes.json")
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer, charset = Charsets.UTF_8)
        val gson=Gson()
        data=gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true

    }
    fun switchPages(quote:Quote?){
        if(currentPage.value==Pages.LISTING){
            currentQuote=quote
            currentPage.value=Pages.DETAIL
        }else{
            currentPage.value=Pages.LISTING
        }
    }
    fun getContext(): Context? {
        return con
    }
}