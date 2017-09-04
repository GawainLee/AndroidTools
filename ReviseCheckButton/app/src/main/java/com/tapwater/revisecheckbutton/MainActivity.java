package com.tapwater.revisecheckbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView show;
    CheckBox checkBoxRed;
    CheckBox checkBoxBlue;
    CheckBox checkBoxYellow;

    boolean redChecked = true;
    boolean blueChecked = false;
    boolean yellowChecked = false;

    String sex = "Male";
    String colorLike = "Red";



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupSex);
        show = (TextView) findViewById(R.id.showTextView);
        checkBoxRed = (CheckBox) findViewById(R.id.redCheckBox);
        checkBoxBlue = (CheckBox) findViewById(R.id.blueCheckBox);
        checkBoxYellow = (CheckBox) findViewById(R.id.yellowCheckBox);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonMale)
                {
                    sex = "Male";
                }else
                {
                    sex = "Female";
                }
                show.setText(sex + " " +colorLike);
            }
        });

        checkBoxRed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                redChecked = b;
                setShowText();
            }
        });
        checkBoxBlue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                blueChecked = b;
                setShowText();
            }
        });
        checkBoxYellow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                yellowChecked = b;
                setShowText();
            }
        });
    }

    public void setShowText()
    {
        colorLike = "";
        if (redChecked)
        {
            colorLike += "Red ";
        }
        if (blueChecked)
        {
            colorLike += "Blue ";
        }
        if (yellowChecked)
        {
            colorLike += "Yellow ";
        }
        show.setText(sex + " " +colorLike);
    }
}
