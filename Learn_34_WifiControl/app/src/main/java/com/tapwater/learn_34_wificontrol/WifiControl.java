package com.tapwater.learn_34_wificontrol;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Tapwater on 16-1-22.
 */
public class WifiControl extends Activity {

    private Button buttonWifiOn, buttonWifiOff, buttonWifiStatus;

    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_layout);

        buttonWifiOn = (Button) findViewById(R.id.buttonWifiOn);
        buttonWifiOff = (Button) findViewById(R.id.buttonWifiOff);
        buttonWifiStatus = (Button) findViewById(R.id.buttonWifiStatus);
        buttonWifiOn.setOnClickListener(new TurnOnWifi());
        buttonWifiOff.setOnClickListener(new TurnOffWifi());
        buttonWifiStatus.setOnClickListener(new CheckWifiStatus());
    }

    class TurnOnWifi implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            wifiManager = (WifiManager) WifiControl.this.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(true);
            System.out.println("Wifi Status: " + wifiManager.getWifiState());
            Toast.makeText(WifiControl.this,"Wifi Status: " + wifiManager.getWifiState(),Toast.LENGTH_SHORT).show();
        }
    }

    class TurnOffWifi implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            wifiManager = (WifiManager) WifiControl.this.getSystemService(Context.WIFI_SERVICE);
            wifiManager.setWifiEnabled(false);
            System.out.println("Wifi Status: " + wifiManager.getWifiState());
            Toast.makeText(WifiControl.this,"Wifi Status: " + wifiManager.getWifiState(),Toast.LENGTH_SHORT).show();
        }
    }
    class CheckWifiStatus implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            wifiManager = (WifiManager) WifiControl.this.getSystemService(Context.WIFI_SERVICE);
            System.out.println("Wifi Status: " + wifiManager.getWifiState());
            Toast.makeText(WifiControl.this,"Wifi Status: " + wifiManager.getWifiState(),Toast.LENGTH_SHORT).show();
        }
    }

}
