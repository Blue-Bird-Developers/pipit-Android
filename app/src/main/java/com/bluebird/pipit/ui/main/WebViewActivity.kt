package com.bluebird.pipit.ui.main

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {

    private var url: String? = null
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webView = findViewById(R.id.webView)
        webViewSetting()
        openWebView()
    }

    private fun webViewSetting(){
        webView.apply {
            webViewClient = MyWebViewClient()

            settings.setSupportMultipleWindows(false) // 새창 띄우기 허용
            settings.setSupportZoom(false) // 화면 확대 허용
            settings.javaScriptEnabled = true // 자바스크립트 허용
            settings.javaScriptCanOpenWindowsAutomatically = false // 자바스크립트 새창 띄우기 허용
            settings.loadWithOverviewMode = true // html의 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
            settings.useWideViewPort = true // html의 viewport 메타 태그 지원
            settings.builtInZoomControls = false // 화면 확대/축소 허용
            settings.displayZoomControls = false
            settings.cacheMode = WebSettings.LOAD_NO_CACHE // 브라우저 캐쉬 허용
            settings.domStorageEnabled = true // 로컬 저장 허용
            settings.databaseEnabled = true
            settings.allowFileAccess = true
        }
    }

    private fun openWebView(){
        getExtra()
        url?.let { webView.loadUrl(it) }
    }

    private fun getExtra(){
        if(intent.hasExtra("url")){
            url = intent.getStringExtra("url")
        }
    }

    // 웹뷰 띄울 때 새창이 아닌 기존창에서 띄우도록 한다.
    class MyWebViewClient : WebViewClient() {
        // 페이지 이동
        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack() // 이전 페이지로 갈 수 있다면 이동하고
        } else {
            super.onBackPressed() // 더 이상 이전 페이지가 없을 때 앱이 종료된다.
        }
    }
}