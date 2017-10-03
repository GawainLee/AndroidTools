package hk.com.nwd.gawainli.androidmacaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,MacUtils.getMac(),Toast.LENGTH_LONG).show();
        Log.i(this.getLocalClassName(),MacUtils.getMac());
    }
}
