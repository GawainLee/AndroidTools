package com.tapwater.learn_8_calculate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity implements OnClickListener{

    private Button button1,button2,button3,button4
    ,button5,button6,button7,button8,button9,button0
    ,buttonAdd,buttonSubtract,buttonMultiply,buttonDivide
    ,buttonPoint,buttonClean,buttonDelete,buttonEqual;

    private TextView textView;

    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_layout);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(this);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(this);

        buttonClean = (Button) findViewById(R.id.buttonClean);
        buttonClean.setOnClickListener(this);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(this);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(this);
        buttonPoint = (Button) findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        this.result = textView.getText().toString();
        switch (view.getId())
        {
            case R.id.button0:
                if(result!="0") {
                    result = result + "0";
                }
            break;

            case R.id.button1:
                result = result + "1";
                break;

            case R.id.button2:
                result = result + "2";
                break;

            case R.id.button3:
                result = result + "3";
                break;

            case R.id.button4:
                result = result + "4";
                break;

            case R.id.button5:
                result = result + "5";
                break;

            case R.id.button6:
                result = result + "6";
                break;

            case R.id.button7:
                result = result + "7";
                break;

            case R.id.button8:
                result = result + "8";
                break;

            case R.id.button9:
                result = result + "9";
                break;

            case R.id.buttonAdd:
                result = result + " + ";
                break;

            case R.id.buttonSubtract:
                result = result + " - ";
                break;

            case R.id.buttonMultiply:
                result = result + " X ";
                break;

            case R.id.buttonDivide:
                result = result + " / ";
                break;
            case R.id.buttonClean:
                result = "";
                break;
            case R.id.buttonDelete:
                if(result.length()!=0) {
                    result = result.substring(0, result.length() - 1);
                }
                break;
            case R.id.buttonPoint:
                result = result + ".";
                break;
            case R.id.buttonEqual:
                if(result.indexOf(" ")>0)
                {
                    runAnalysis();
                }
                break;
        }

        textView.setText(result);
    }

    public void runAnalysis()
    {
        String[] elements = result.split(" ");
        ArrayList elementsList = new ArrayList();
        for(int i = 0; i < elements.length; i++)
        {
            elementsList.add(elements[i]);
        }

        for(int i  = 1; (2*i)< elementsList.size(); i++)
        {
            if(elementsList.get(2*i).equals("X"))
            {
                double d1 = Double.parseDouble(elementsList.get(i).toString());
                double d2 = Double.parseDouble(elementsList.get(i+2).toString());
                double d3 = d1 * d2;

                elementsList.remove(i);
                elementsList.remove(i+1);
                elementsList.remove(i+2);

                elementsList.add(i,d3);

                i--;
            }
        }

        textView.setText(elementsList.get(1).toString());
    }
}
