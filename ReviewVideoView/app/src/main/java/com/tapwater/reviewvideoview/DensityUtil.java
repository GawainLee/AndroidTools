package com.tapwater.reviewvideoview;

import android.content.Context;

/**
 * Created by Tapwater on 17-5-9.
 */

public class DensityUtil {

    public static final float getHeightInPx(Context context) {
        final float height = context.getResources().getDisplayMetrics().heightPixels;
        return height;
    }
    public static final float getWidthInPx(Context context) {
        final float width = context.getResources().getDisplayMetrics().widthPixels;
        return width;
    }


    public static final float dip2px(Context context,float dip) {
        final float width = (context.getResources().getDisplayMetrics().widthPixels) - dip;
        return width;
    }

}
