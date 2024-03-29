package com.zhowin.timediary.common.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * ItemDecoration的间距
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int left;
    private int bottom;
    private int right;
    private int top;

    public SpacesItemDecoration(int left, int bottom, int right, int top) {
        this.left = left;
        this.bottom = bottom;
        this.right = right;
        this.top = top;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = left;
        outRect.bottom = bottom;
        outRect.right = right;
        outRect.top = top;

        if (parent.getChildPosition(view) == 0) {
            outRect.top = top;
        } else {
            outRect.top = 0;
        }
    }
}
