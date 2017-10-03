package hk.com.nwd.gawainli.movementimage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by gawainli on 9/29/2017.
 */

public class DIYRelativeLayout extends RelativeLayout {

    private ArrayList<DIYImageView> viewArrayList;
    public DIYRelativeLayout(Context context) {
        super(context);
    }

    public DIYRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DIYRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * get all children in RelativeLayout
     */
    public void getChild()
    {
        int num  = this.getChildCount();
        this.viewArrayList = new ArrayList<DIYImageView>();
        for(int i = 0; i < num; i++)
        {
            viewArrayList.add((DIYImageView)this.getChildAt(i));
        }
    }

    /**
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        //check get children or not
        if (this.viewArrayList==null)
        {
            getChild();
        }

        //flat for imageView draw or not
        boolean notDraw = true;
        //loop all child and redraw in old location
        for (DIYImageView v : viewArrayList)
        {
            if (v.isTouched())
            {
                v.layout(v.getMx(), v.getMy(), v.getMx() + v.getImageWidth(), v.getMy() + v.getImageHeight());
                notDraw = false;
            }
        }

        //if not imageView call then use super
        if (notDraw)
        {
            super.onLayout(changed, l, t, r, b);
        }
    }
}
