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

    boolean isValid;
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
            isValid = true;
            a = getnumber(eta,"a");
            b = getnumber(etb,"b");
            c = getnumber(etc,"c");

            if (isValid)
            {
                signa = getsign(eta);
                signb = getsign(etb);
                signc = getsign(etc);

                a = Math.abs(a);
                b = Math.abs(b);
                c = Math.abs(c);

                if(signa !="-")
                {
                    url = "https://www.google.com/search?q="+ a + "x%5E2" + signb + b + "x" + signc + c + "&rlz=1C1CHBD_enIL872IL872&oq=x%5E2%2B5x&aqs=chrome.1.69i57j0l7.15066j0j7&sourceid=chrome&ie=UTF-8";
                }
                else {
                    url = "https://www.google.com/search?q=" + signa + a + "*" + "x%5E2" + signb + b + "x" + signc + c + "&rlz=1C1CHBD_enIL872IL872&oq=x%5E2%2B5x&aqs=chrome.1.69i57j0l7.15066j0j7&sourceid=chrome&ie=UTF-8";
                }
                wv.loadUrl(url);
            }


            eta.setText("");
            etb.setText("");
            etc.setText("");
    }

    private float getnumber(EditText et, String a) {
        float value =0;
        str = et.getText().toString();
        if (str.equals("")||str.equals(".")||str.equals("-")) {
            isValid = false;
            Toast.makeText(this, "please put a number in "+a, Toast.LENGTH_SHORT).show();
        }
        else
        {
            value = Float.parseFloat(et.getText().toString());
        }
        return value;
    }

    private String getsign(EditText et) {
        String sign ="";
        str = et.getText().toString();

        if (str.contains("-"))
        {
            sign ="-";
        }
        else
        {
            sign ="%2B";
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
