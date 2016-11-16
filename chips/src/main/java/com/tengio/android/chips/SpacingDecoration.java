package com.tengio.android.chips;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacingDecoration extends RecyclerView.ItemDecoration {

    private final int left;
    private final int right;
    private final int top;
    private final int bottom;

    public SpacingDecoration(int leftInPx, int rightInPx, int topInPx, int bottomInPx) {
        this.left = leftInPx;
        this.right = rightInPx;
        this.top = topInPx;
        this.bottom = bottomInPx;
    }

    public SpacingDecoration(Context context, int leftResId, int rightResId, int topResId, int bottomResId) {
        this.left = getDimensionPixelSize(context, leftResId);
        this.right = getDimensionPixelSize(context, rightResId);
        this.top = getDimensionPixelSize(context, topResId);
        this.bottom = getDimensionPixelSize(context, bottomResId);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (isFirstPosition(view, parent)) {
            if (isVerticalLinearLayoutManager(parent)) {
                outRect.left = left;
                outRect.right = right;
                outRect.bottom = bottom;
            } else {
                outRect.top = top;
                outRect.bottom = bottom;
                outRect.right = right;
            }
            return;
        }
        if (isLastPosition(view, parent)) {
            if (isVerticalLinearLayoutManager(parent)) {
                outRect.left = left;
                outRect.right = right;
                outRect.top = top;
            } else {
                outRect.top = top;
                outRect.bottom = bottom;
                outRect.left = left;
            }
            return;
        }
        outRect.left = left;
        outRect.right = right;
        outRect.bottom = bottom;
        outRect.top = top;
    }

    private boolean isVerticalLinearLayoutManager(RecyclerView parent) {
        if (parent.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager manager = (LinearLayoutManager) parent.getLayoutManager();
            return manager.getOrientation() == LinearLayoutManager.VERTICAL;
        }
        throw new IllegalStateException("Requires a Linear Layout Manager");
    }

    private boolean isFirstPosition(View view, RecyclerView parent) {
        return parent.getChildAdapterPosition(view) == 0;
    }

    private boolean isLastPosition(View view, RecyclerView parent) {
        return parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1;
    }

    private int getDimensionPixelSize(Context context, int resId) {
        if (resId == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(resId);
    }
}