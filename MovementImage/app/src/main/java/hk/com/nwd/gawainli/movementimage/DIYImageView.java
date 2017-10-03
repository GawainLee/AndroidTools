package hk.com.nwd.gawainli.movementimage;


import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by gawainli on 9/29/2017.
 */

public class DIYImageView extends android.support.v7.widget.AppCompatImageView {

    private Context mContext;

    private float x, y;    // 原本圖片存在的X,Y軸位置
    private int mx, my; // 圖片被拖曳的X ,Y軸距離長度
    private int imageWidth, imageHeight;
    private int oldx = 0,oldy = 0;
    private boolean touched;
    private View viewImageView;


    public DIYImageView(Context context) {
        super(context);
        this.mContext = context;
        setOnTouchListener(null);
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {

        OnTouchListener onTouchListener = new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                touched = true;
                viewImageView = v;
                imageWidth = v.getWidth();
                imageHeight = v.getHeight();
                switch (event.getAction()) {          //判斷觸控的動作

                    case MotionEvent.ACTION_DOWN:// 按下圖片時
                        x = event.getX();                  //觸控的X軸位置
                        y = event.getY();                  //觸控的Y軸位置

                        v.bringToFront();
                        v.layout((int)oldx, (int)oldy, (int)oldx + v.getWidth(), (int)oldy + v.getHeight());

                    case MotionEvent.ACTION_MOVE:// 移動圖片時

                        //getX()：是獲取當前控件(View)的座標

                        //getRawX()：是獲取相對顯示螢幕左上角的座標
                        mx = (int) (event.getRawX() - x);
                        my = (int) (event.getRawY() - y);
                        v.layout(mx, my, mx + v.getWidth(), my + v.getHeight());
                        oldx = mx;
                        oldy = my;
                        break;
                }
//                Log.e("address", String.valueOf(mx) + "~~" + String.valueOf(my)); // 記錄目前位置
                return true;
            }
        };

        super.setOnTouchListener(onTouchListener);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (touched)
        {
            super.onLayout(changed, mx, my, mx + imageWidth, my + imageHeight);
        }
        else
        {
            super.onLayout(changed, left, top, right, bottom);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public int getMx() {
        return mx;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMy() {
        return my;
    }

    public void setMy(int my) {
        this.my = my;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }
}
