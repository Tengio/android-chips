package com.tengio.android.chips;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ChipView extends RelativeLayout {

    private TextView title;

    public ChipView(Context context) {
        super(context);
    }

    public ChipView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ChipView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static ChipView inflate(@LayoutRes int layout, ViewGroup group) {
        return (ChipView) LayoutInflater.from(group.getContext()).inflate(layout, group, false);
    }

    public static ChipView deletable(ViewGroup group) {
        return inflate(R.layout.deletable_chip_view, group);
    }

    public static ChipView standard(ViewGroup group) {
        return inflate(R.layout.chip_view, group);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        title = (TextView) findViewById(com.tengio.android.chips.R.id.chip_view_title);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                Drawable drawable = view.getBackground();
                drawable.getOutline(outline);
            }
        };

        this.setOutlineProvider(viewOutlineProvider);
    }

    public void update(Chip chip) {
        title.setText(chip.getLabel());
    }
}
