package com.example.akashnarasimhan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tx1,tx2;
    String Str1 = "";
    String Str2;
    int flag = 0;
    Double val1,val2,result;
    Calculator calc = new Calculator();
    EvaluateString es = new EvaluateString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx1 = findViewById(R.id.text1);
        tx2 = findViewById(R.id.text2);
        //tx1.setText(null);
        tx1.setText("0");
        tx2.setText("=");
    }

    public void Zero(View view){
        if(!Str1.equals("")){
            Str1 = Str1 + "0";
            tx1.setText(Str1);
            flag = 0;
        }
    }

    public void One(View view){
        Str1 = Str1 + "1";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Two(View view){
        Str1 = Str1 + "2";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Three(View view){
        Str1 = Str1 + "3";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Four(View view){
        Str1 = Str1 + "4";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Five(View view){
        Str1 = Str1 + "5";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Six(View view){
        Str1 = Str1 + "6";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Seven(View view){
        Str1 = Str1 + "7";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Eight(View view){
        Str1 = Str1 + "8";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Nine(View view){
        Str1 = Str1 + "9";
        tx1.setText(Str1);
        flag = 0;
    }

    public void Cancel(View view){
        Str1 = "";
        tx1.setText("0");
        tx2.setText("=");
        flag = 0;
    }

    public void Plus(View view){
        if(!Str1.equals("")&&flag==0){
            Str1 = Str1 + "+";
            tx1.setText(Str1);
            flag = 1;
        }
    }

    public void Minus(View view){
       if(flag==0){
           Str1 = Str1 + "-";
           tx1.setText(Str1);
           flag = 1;
       }
    }

    public void Multiply(View view){
        if(!Str1.equals("") && flag==0){
            Str1 = Str1 + "*";
            tx1.setText(Str1);
            flag = 1;
        }
    }

    public void Divide(View view){
        if(!Str1.equals("")&&flag==0){
            Str1 = Str1 + "/";
            tx1.setText(Str1);
            flag = 1;
        }
    }

    public void Dot(View view){
        if(!Str1.equals("")&&flag==0){
            Str1 = Str1 + ".";
            tx1.setText(Str1);
            flag = 1;
        }
    }

    public void Backspace(View view){
        if(!Str1.equals("")){
            Str1 = Str1.substring(0,Str1.length()-1);
            tx1.setText(Str1);
            flag = 0;}
    }

    public void Equals(View view){
        if(!Str1.equals("")){
        if(flag==0)
            result = calc.Evaluate(Str1);
        else{
            Str1 = Str1.substring(0,Str1.length()-1);
            result = calc.Evaluate(Str1);
        }
        if((result - result.intValue()) != 0 ){
            result = (Math.round(result*10000000)/(double)10000000);
            String resultstr = "=" + result;
            tx2.setText(resultstr);
        }
        else{
            String resultstr = "=" + result.intValue();
            tx2.setText(resultstr);
        }
    }}
}
