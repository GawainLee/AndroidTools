package com.tapwater.revisetoast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonMyToast;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        buttonMyToast = (Button) findViewById(R.id.buttonMyToast);
        buttonMyToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                midToast("Show my the money");
            }
        });
    }

    private void midToast(String text)
    {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.my_toast, (ViewGroup) findViewById(R.id.myToast));
        TextView textView = (TextView) view.findViewById(R.id.textViewToast);
        textView.setText(text);
        Toast toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
}
