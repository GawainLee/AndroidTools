package hk.com.nwd.gawainli.movementimage;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static hk.com.nwd.gawainli.movementimage.R.mipmap.ic_launcher;

public class MainActivity extends Activity {

    // diy image view
    private DIYImageView iv, iv2;

    //diy relativelayout
    private DIYRelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //create imageView
        iv = new DIYImageView(this);
        //set image source
        iv.setImageResource(R.drawable.images);


        //create imageView
        iv2 = new DIYImageView(this);
        //set image source
        iv2.setImageResource(R.mipmap.ic_launcher_round);

        //find diy relativeLayout
        relativeLayout = (DIYRelativeLayout) findViewById(R.id.drawRelativeLayout);
        //create LayoutParams to manage imageView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        relativeLayout.addView(iv, lp);
        //create LayoutParams to manage imageView
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeLayout.addView(iv2, lp2);

    }
}
