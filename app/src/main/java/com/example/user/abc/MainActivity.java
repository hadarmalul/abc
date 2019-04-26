package com.example.user.abc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    String st1,st2,st3;
    TextView tv1,tv2,tv3;
    double a,b,c,x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        Intent gi = getIntent();
        x1 = gi.getDoubleExtra("x1",0);
        x2 = gi.getDoubleExtra("x2",0);
        tv1.setText("last solution1: "+ x1);
        tv2.setText("last solution2: "+ x2);
        tv3.setText(" ");
    }

    public void sol(View view) {

        st1 = et1.getText().toString();
        st2 = et2.getText().toString();
        st3 = et3.getText().toString();

        if ((st1.length() == 0) || (st2.length() == 0) || st3.length() == 0) {
            tv3.setText("try again");
        }

        else {
            a = Double.parseDouble(st1);
            b = Double.parseDouble(st2);
            c = Double.parseDouble(st3);


            Intent si = new Intent(this, Main2Activity.class);
            si.putExtra("a", a);
            si.putExtra("b", b);
            si.putExtra("c", c);
            startActivity(si);

        }
    }



    public void ran(View view) {

        Random rnd = new Random();
        a = rnd.nextInt(51);
        et1.setText(a+"");
        b = rnd.nextInt(51);
        et2.setText(b+"");
        c = rnd.nextInt(51);
        et3.setText(c+"");

    }

}
