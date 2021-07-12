package com.abneralcantara.vacinaja2;

import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebviewPage extends AppCompatActivity {

    WebView Webview;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_webview_page);

        WebView myWebView = (WebView) findViewById(R.id.Webview);
        myWebView.loadUrl("https://abneralcantara.github.io/");
    }
}
