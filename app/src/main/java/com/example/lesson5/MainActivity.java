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
    String stra;
    String strb;
    String strc;
    String answer;
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

            if (a == 0)
            {
                isValid = false;
                Toast.makeText(this, "a need to be defrent from 0 (it won't be a parabole)", Toast.LENGTH_SHORT).show();
            }
            if (isValid)
            {
                signa = getsign(eta);
                signb = getsign(etb);
                signc = getsign(etc);

                stra = getstr(eta);
                strb = getstr(etb);
                strc = getstr(etc);

                a = Math.abs(a);
                b = Math.abs(b);
                c = Math.abs(c);

                if(signa !="-")
                {
                    url = "https://www.google.com/search?q="+ stra + "x%5E2" +signb+ strb+ "x" +signc+ strc + "&rlz=1C1CHBD_enIL872IL872&oq=x%5E2%2B5x&aqs=chrome.1.69i57j0l7.15066j0j7&sourceid=chrome&ie=UTF-8";
                }
                else {
                    url = "https://www.google.com/search?q=" +signa +stra+ "*" + "x%5E2" + signb+strb + "x"+signc + strc + "&rlz=1C1CHBD_enIL872IL872&oq=x%5E2%2B5x&aqs=chrome.1.69i57j0l7.15066j0j7&sourceid=chrome&ie=UTF-8";
                }
                wv.loadUrl(url);
            }


            eta.setText("");
            etb.setText("");
            etc.setText("");
    }

    private String getstr(EditText et)
    {
        answer ="";

        answer = et.getText().toString();
        if (answer.contains("-"))
        {
            answer= answer.replace("-","");
        }
        return answer;
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
;
    /*
    Input: edit text
    Output: The sign
    read the edit text and dexide what is the sign
     */
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
