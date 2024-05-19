package com.anthony.teneth2.screens

import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun HomeScreen() {
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.cacheMode = WebSettings.LOAD_NO_CACHE
            webViewClient = WebViewClient()
            loadUrl("http://www.teneth.net/EN/ABOUT%20US/")

        }
    })

}