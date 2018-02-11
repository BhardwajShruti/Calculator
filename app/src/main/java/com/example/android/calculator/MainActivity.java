package com.example.android.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
EditText ed1,ed2;
    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,equals,plus,minus,divide,multiply,dot;
float num ,num1 ,num2 ;
    boolean flag = false;
    String opt = "";
    //cannot define here any button acc to their ids
    //bcoz we are attaching our layout in onCreate function so definition shud be after setContentView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.edit1);
        // we are making it global as findViewbyId is very costly and we shud do it once
        ed2 = (EditText)findViewById(R.id.edit2);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six  = (Button)findViewById(R.id.six);
        seven= (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply= (Button)findViewById(R.id.divide);
        equals = (Button)findViewById(R.id.equals);
        clear = (Button)findViewById(R.id.clear);
        dot = (Button)findViewById(R.id.dot);

        //main activity implemens onClickListner..defines Onclick//here we can use same ONcLick...differentite by ids
        ed2.setOnClickListener(this);
//implement SetOnClickListner by making anonamous class (new View.OnClickListener())
        ed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "en0ter number", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void numberClick(View view) {
        flag = true;
int a =view.getId();

        switch (a){
            case R.id.dot:
                ed1.setText(ed1.getText()+".");
                ed2.setText(ed2.getText()+".");
                break;
            case R.id.one:
                ed1.setText(ed1.getText()+"1");
                ed2.setText(ed2.getText()+"1");
                break;
            case R.id.two:
                ed1.setText(ed1.getText()+"2");
                ed2.setText(ed2.getText()+"2");
                break;
            case R.id.three:
                ed1.setText(ed1.getText()+"3");
                ed2.setText(ed2.getText()+"3");
                break;
            case R.id.four:
                ed1.setText(ed1.getText()+"4");
                ed2.setText(ed2.getText()+"4");
                break;
            case R.id.five:
                ed1.setText(ed1.getText()+"5");
                ed2.setText(ed2.getText()+"5");
                break;
            case R.id.six:
                ed1.setText(ed1.getText()+"6");
                ed2.setText(ed2.getText()+"6");
                break;
            case R.id.seven:
                ed1.setText(ed1.getText()+"7");
                ed2.setText(ed2.getText()+"7");
                break;
            case R.id.eight:
                ed1.setText(ed1.getText()+"8");
                ed2.setText(ed2.getText()+"8");
                break;
            case R.id.nine:
                ed1.setText(ed1.getText()+"9");
                ed2.setText(ed2.getText()+"9");
                break;
            case R.id.zero:
                ed1.setText(ed1.getText()+"0");
                ed2.setText(ed2.getText()+"0");
                break;}



    }
   public  void clearClicked(View view){
        num1 = 0;
        num2 = 0;
        num =0;
        opt ="";
       ed1.setText("");
       ed1.setTextColor(Color.BLACK);
       ed2.setText("");
       ed1.setTextSize(30);
flag = false;
    }
    public void equalClicked(View view){
        ed1.setTextColor(Color.BLUE);
        ed1.setTextSize(100);
if(num1==0)
    return;
       num2 = Float.parseFloat(ed2.getText() + "");

        switch(opt){
            case "add":{
                num = num1+num2;
                break;
            }
            case "minus":{
                num = num1-num2;
                break;
            }

            case "multiply":{
                num = num1*num2;
                break;
            }
            case "divide":{
                num = num1/num2;
                break;
            }}


     ed1.setText(num+"");
        ed2.setText("");
    }
    public void operatorClick(View view){
        if(flag==false) {
            Toast.makeText(this, "click a number", Toast.LENGTH_SHORT).show();
            return;}

if(opt!="") {
   // Toast.makeText(this, "hey", Toast.LENGTH_SHORT).show();
    num2 = Float.parseFloat(ed2.getText() + "");

    switch (opt) {
        case "add": {
            num = num1 + num2;
            break;
        }
        case "minus": {
            num = num1 - num2;
            break;
        }

        case "multiply": {
            num = num1 * num2;
            break;
        }
        case "divide": {
            num = num1 / num2;
            break;
        }
    }num1 = num;
    num2 = 0;
}else {
    num1 = Float.parseFloat(ed2.getText() + "");
}       int op =view.getId();
        switch (op){
            case R.id.plus:
     //   num1 = Float.parseFloat(ed1.getText() + "");
                opt = "add";
                ed1.setText(ed1.getText()+"+");
                break;
            case R.id.minus:
                opt = "minus";
                ed1.setText(ed1.getText()+"-");
                break;
            case R.id.multiply:
                opt = "multiply";
                ed1.setText(ed1.getText()+"*");
                break;
            case R.id.divide:
                opt = "divide";
                ed1.setText(ed1.getText()+"/");
                break;

        }
ed2.setText(null);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "implemented by activity", Toast.LENGTH_SHORT).show();
    }
}
