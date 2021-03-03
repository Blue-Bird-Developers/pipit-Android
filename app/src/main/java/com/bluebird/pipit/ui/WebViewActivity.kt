package com.bluebird.pipit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import android.widget.TextView
import android.widget.Toast
import com.bluebird.pipit.R
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {

    private var url: String? = null
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        init()
    }

    private fun init(){
        webView = findViewById(R.id.webView)
        webViewSetting()
        openWebView()
        setListeners()
    }

    private fun setListeners(){
        webViewCheckBox.setOnCheckedChangeListener { button, checked ->
            if (checked){
                button.text = "저장됨"
                makeToast()
            }else{
                // TODO: 2021/03/03 저장취소할 때
                button.text = "저장하기"
            }
        }
    }

    private fun makeToast(){
        var layout = layoutInflater.inflate(R.layout.toast_layout, null)
        layout.setBackgroundResource(R.drawable.toast_background)
        var textView: TextView = layout.findViewById(R.id.toastText)
        textView.text = "책갈피에 저장되었어요!"
        var t2 = Toast(this)
        t2.view = layout
        t2.show()
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
            val title = intent.getStringExtra("title")
            titleText.text = title
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