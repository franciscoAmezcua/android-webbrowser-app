package com.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class LayOutWebView extends AppCompatActivity {

    WebView myWebView;
    private static final String TAG = "Correct loading";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lay_out_web_view);

//        WebView webView = new WebView(this);
//        setContentView(webView);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://opensource.com/");
//       Toast.makeText(getBaseContext(),"Connected to website",Toast.LENGTH_LONG);
//       Log.d(TAG,"Welcome to website");



        myWebView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");


        // Option to take user to google chrome
//        webView.loadUrl("https://google.ca");

        //Option to develop a view with HTML
//        String summary = "<html><body><title>WebView</title> <h1>This is the webView</h1>.</body></html>";
//        webView.loadData(summary, "text/html", null);

        Context context = getApplicationContext();
        CharSequence text = "Website loading...";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.d(TAG,"Welcome to website");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

    public void backHome(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
