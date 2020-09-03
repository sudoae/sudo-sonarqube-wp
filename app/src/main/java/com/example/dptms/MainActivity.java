package com.example.dptms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize webview
        webView = findViewById(R.id.web_view);
        webView.setVerticalScrollBarEnabled(true);
        webView.requestFocus();
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // load url
       // webView.loadUrl("https://www.youtube.com/");
        webView.loadUrl("http://dptab.sudo.ae/");

        findViewById(R.id.reload_btn).setOnClickListener(v->{
            if(webView!=null){
                webView.reload();
            }
        });

        findViewById(R.id.exit_btn).setOnClickListener(v->{

            finish();
        });
    }

    @Override
    public void onBackPressed() {
        if(webView!= null && webView.canGoBack())
            webView.goBack();// if there is previous page open it
        else
            super.onBackPressed();//if there is no previous page, close app
    }
}
