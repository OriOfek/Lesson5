package com.example.lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String url;
    WebView wv;
    String signa;
    String signb;
    String signc;
    EditText eta;
    EditText etb;
    EditText etc;
    float a;
    float b;
    float c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView) findViewById(R.id.wv);
        eta = (EditText) findViewById(R.id.a);
        etb = (EditText) findViewById(R.id.b);
        etc = (EditText) findViewById(R.id.c);

        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());
    }

    public void submit(View view) {
        char sign = '%';
        a = Float.parseFloat(eta.getText().toString());
        b = Float.parseFloat(etb.getText().toString());
        c = Float.parseFloat(etc.getText().toString());

        signa = getsign(a);
        signb = getsign(b);
        signc = getsign(c);

        url = "https://www.google.com/search?q="+signa + a +"x"+signb+b+signc+c+"&rlz=1C1CHBD_enIL872IL872&oq=2x&aqs=chrome.0.69i59j69i57j69i59j69i60.3522j0j7&sourceid=chrome&ie=UTF-8";
        wv.loadUrl(url);

    }

    private String getsign(float a) {
        String sign ="";

        if (a>0)
        {
            sign ="%2B";
        }
        else
        {
            sign ="%5E2";
        }
        return sign;
    }


    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
