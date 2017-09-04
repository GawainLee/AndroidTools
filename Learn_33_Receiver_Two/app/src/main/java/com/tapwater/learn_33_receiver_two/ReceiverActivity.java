package com.tapwater.learn_33_receiver_two;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tapwater on 16-1-21.
 */
public class ReceiverActivity extends Activity {

    private Button buttonReceiverOn, buttonReceiverOff;
    private SMSReceiver smsReceiver = null;
    private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiver);

        buttonReceiverOn = (Button) findViewById(R.id.buttonOpenSMSReceiver);
        buttonReceiverOff = (Button) findViewById(R.id.buttonCloseSMSReceiver);
        buttonReceiverOn.setOnClickListener(new TurnOnSMSReceiver());
        buttonReceiverOff.setOnClickListener(new TurnOffSMSReceiver());
    }

    class TurnOnSMSReceiver implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            smsReceiver = new SMSReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SMS_ACTION);
            ReceiverActivity.this.registerReceiver(smsReceiver,intentFilter);
        }
    }

    class TurnOffSMSReceiver implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            ReceiverActivity.this.unregisterReceiver(smsReceiver);
        }
    }
}
