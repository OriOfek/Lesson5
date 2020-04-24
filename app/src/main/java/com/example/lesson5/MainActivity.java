package com.example.lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String str;
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
            a = getnumber(eta,"a");
            if (a!=0)
            {
                b = getnumber(etb,"b");
                c = getnumber(etc,"c");

                signa = getsign(a);
                signb = getsign(b);
                signc = getsign(c);

                a = checknumber(a);
                b = checknumber(b);
                c = checknumber(c);
                url = "https://www.google.com/search?q=" + a + "x%5E2" + signb + b + "x" + signc + c + "&rlz=1C1CHBD_enIL872IL872&oq=x%5E2%2B5x&aqs=chrome.1.69i57j0l7.15066j0j7&sourceid=chrome&ie=UTF-8";
                wv.loadUrl(url);
            }
            eta.setText("");
            etb.setText("");
            etc.setText("");
    }

    private float getnumber(EditText et, String a) {
        float value =0;
        str = et.getText().toString();
        if((a=="a") && (str.matches("")||str.matches(".")||str.matches("-"))) {
            Toast.makeText(this, "if you don't write a value in a it won't work", Toast.LENGTH_SHORT).show();
        }
        else if (str.matches("")||str.matches(".")||str.matches("-")) {
            Toast.makeText(this, "you don't wirte a number in the "+a+" it consider it like a 0", Toast.LENGTH_SHORT).show();
        }
        else
        {
            value = Float.parseFloat(et.getText().toString());
        }
        return value;
    }

    private float checknumber(float a) {
        if (a<0)
        {
            return a*-1;
        }
        return a;
    }

    private String getsign(float a) {
        String sign ="";

        if (a>0)
        {
            sign ="%2B";
        }
        else
        {
            sign ="-";
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
