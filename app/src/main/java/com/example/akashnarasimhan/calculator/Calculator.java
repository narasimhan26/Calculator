package com.example.akashnarasimhan.calculator;

import android.widget.Toast;

import java.util.Stack;

/**
 * Created by Admin on 1/18/2018.
 */

public class Calculator {
    public Calculator(){}

    public static Double Evaluate(String expr){
        char[] string = expr.toCharArray();

        Stack<Double> value = new Stack<Double>();
        Stack<Character> Operator = new Stack<Character>();

        for(int i=0;i<string.length;i++){
            if(string[i]==' ')
                continue;

            if(string[i]>='0' && string[i]<='9'){
                StringBuffer stringBuffer = new StringBuffer();
                while(i<string.length && ((string[i]>='0' && string[i]<='9') || string[i]=='.'))
                    stringBuffer.append(string[i++]);
                i--;
                value.push(Double.parseDouble(stringBuffer.toString()));
            }

            else if(string[i] == '(')
                Operator.push(string[i]);

            else if(string[i] == ')'){
                while(Operator.peek()!='(')
                    value.push(calculate(Operator.pop(), value.pop(), value.pop()));
                Operator.pop();
            }

            else if(string[i] == '+' || string[i] == '-' || string[i] == '*' || string[i] == '/'){
                while(!Operator.empty()&& hasPrecedence(string[i], Operator.peek()))
                    value.push(calculate(Operator.pop(),value.pop(), value.pop()));

                Operator.push(string[i]);
            }
        }
        while(!Operator.empty())
            value.push(calculate(Operator.pop(), value.pop(), value.pop()));
        return value.pop();
    }

    public static boolean hasPrecedence(char c1, char c2) {
        if (c2 == '(' || c2 == ')')
            return false;
        if ((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-'))
            return false;
        else
            return true;
    }

    public static double calculate(char operator , double b , double a){
        switch (operator){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if(b==0)
                    throw new
                    UnsupportedOperationException("Cant divide by zero");
                return a / b;
        }
        return 0;
    }
}
