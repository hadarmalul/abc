package com.example.user.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    WebView wv;
    TextView tv1, tv2;
    double a,b,c,x1,x2,sqrt;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wv = (WebView) findViewById(R.id.wv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        Intent gi = getIntent();
        a = gi.getDoubleExtra("a",0);
        b = gi.getDoubleExtra("b",0);
        c = gi.getDoubleExtra("c",0);
        wv.getSettings().setJavaScriptEnabled(true);
        st =  "https://www.google.co.il/search?ei=hHNQXISFEYLmsAfUxrqACQ&q=";
        st= st+a+"x%5E2%2B"+b+"x%2B"+c+"&oq";
        wv.loadUrl(st);
        sqrt= Math.sqrt((b*b)-(4*a*c));
        if (sqrt>0){
            x1 = (-b+sqrt)/(2*a);
            tv1.setText("x1= "+x1);
            x2 = (-b-sqrt)/(2*a);
            tv2.setText("x2= "+x2);
        }
        if (sqrt==0){
            x1 = -b/(2*a);
            tv1.setText("x= "+x1);
            tv2.setText(" ");
        }
        if (sqrt<0){
            tv1.setText("no solution");
            tv2.setText(" ");
        }

    }


    public void back(View view) {
        Intent si = new Intent(this, MainActivity.class);
        si.putExtra("x1", x1);
        si.putExtra("x2", x2);
        startActivity(si);

    }
}
